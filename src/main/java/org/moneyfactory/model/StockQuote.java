package org.moneyfactory.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class StockQuote {
    private BigDecimal adhocMargin;
    private BigDecimal applicableMargin;
    private BigDecimal averagePrice;
    private BigDecimal basePrice;

    private BigDecimal buyPrice1;
    private BigDecimal buyPrice2;
    private BigDecimal buyPrice3;
    private BigDecimal buyPrice4;
    private BigDecimal buyPrice5;
    private BigDecimal buyQuantity1;
    private BigDecimal buyQuantity2;
    private BigDecimal buyQuantity3;
    private BigDecimal buyQuantity4;
    private BigDecimal buyQuantity5;
    private BigDecimal change;
    private BigDecimal closePrice;
    private BigDecimal cm_ffm;
    private String companyName;
    private String css_status_desc;
    private BigDecimal dayHigh;
    private BigDecimal dayLow;
    private BigDecimal deliveryQuantity;
    private BigDecimal deliveryToTradedQuantity;
    private BigDecimal extremeLossMargin;
    private BigDecimal faceValue;
    private BigDecimal high52;
    private BigDecimal indexVar;
    private boolean isExDateFlag;
    private String isinCode;
    private BigDecimal lastPrice;
    private BigDecimal low52;
    private String marketType;
    private BigDecimal open;
    private BigDecimal pChange;
    private BigDecimal previousClose;
    private String purpose;
    private BigDecimal quantityTraded;
    private BigDecimal securityVar;
    private BigDecimal sellPrice1;
    private BigDecimal sellPrice2;
    private BigDecimal sellPrice3;
    private BigDecimal sellPrice4;
    private BigDecimal sellPrice5;
    private BigDecimal sellQuantity1;
    private BigDecimal sellQuantity2;
    private BigDecimal sellQuantity3;
    private BigDecimal sellQuantity4;
    private BigDecimal sellQuantity5;
    private String series;
    private String symbol;
    private BigDecimal totalBuyQuantity;
    private BigDecimal totalSellQuantity;
    private BigDecimal totalTradedValue;
    private BigDecimal totalTradedVolume;
    private BigDecimal varMargin;
}
