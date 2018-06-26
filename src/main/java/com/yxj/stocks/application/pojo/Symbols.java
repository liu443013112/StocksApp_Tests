package com.yxj.stocks.application.pojo;

import java.io.Serializable;

public class Symbols implements Serializable {

    private Double currentPrice;
    private Double openPrice;
    private String symbol;

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.format("Symbols {currentPrice='%s', openPrice='%s', symbol='%d'}", currentPrice, openPrice, symbol);

    }

}