package org.moneyfactory.service;

import lombok.extern.log4j.Log4j2;
import org.moneyfactory.model.Alert;
import org.moneyfactory.model.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service(value = "cronService")
public class CronService {

    @Autowired
    AlertService alertService;
    @Autowired
    NseRestService nseRestService;
    private List<Alert> alertList = new ArrayList<>();

    public void updateQuotes() {
        alertList.parallelStream().forEach(alert -> triggerAlert(alert));
    }

    private void triggerAlert(Alert symbol) {
        try {
            StockQuote quote = nseRestService.getQuote(symbol.getSymbol());
            if (symbol.getDirection().equalsIgnoreCase("BUY") && nseRestService.getQuote(symbol.getSymbol()).getLastPrice().compareTo(symbol.getPrice()) <= 0) {
                alertService.sendAlertEmail(symbol, quote);
                return;
            }
            if (symbol.getDirection().equalsIgnoreCase("SELL") && nseRestService.getQuote(symbol.getSymbol()).getLastPrice().compareTo(symbol.getPrice()) >= 0) {
                alertService.sendAlertEmail(symbol, quote);
                return;
            }
        } catch (Exception e) {
            log.error("error wile tiggering alert ", e);
        }

    }

    public void updateAlerts(Alert alert) {
        alertList.add(alert);
    }
}
