package org.moneyfactory.service;

import com.google.gson.Gson;
import org.moneyfactory.model.Alert;
import org.moneyfactory.model.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service(value = "alertService")
public class AlertService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendAlertEmail(Alert alert, StockQuote quote) throws MessagingException, UnsupportedEncodingException {
        String toAddress = "moneymakersystemalert@gmail.com";
        String fromAddress = "moneymakersystemalert@gmail.com";
        String senderName = "MoneyMaker";
        String subject = "Alert !!! - "+ alert.getSymbol() + " breached limit for direction "+alert.getDirection()
                + " current price " + quote.getLastPrice() + " is less/more than alert price"+ alert.getPrice();
        String content = new Gson().toJson(quote);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
//        content = content.replace("[[name]]", user.getUsername());
//        String verifyURL = "http://localhost:8080/verifyEmail" + "/verify?code=" + token;
//        content = content.replace("[[URL]]", verifyURL);
        helper.setText(content, true);
        mailSender.send(message);
    }

}
