package org.moneyfactory.service;

import org.moneyfactory.model.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("nseRestService")
public class NseRestService {

    @Autowired
    RestTemplate restTemplate;
    public StockQuote getQuote(String symbol) throws Exception {
        return restTemplate.getForObject("http://127.0.0.1:5000/get/quote/"+symbol, StockQuote.class);
    }

}
