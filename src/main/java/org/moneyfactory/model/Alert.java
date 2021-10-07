package org.moneyfactory.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Alert {
    private String symbol;
    private BigDecimal price;
    private String direction;

    public Alert (String symbol, BigDecimal price, String direction ){
        this.symbol=symbol;
        this.price=price;
        this.direction=direction;
    }
}
