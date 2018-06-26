package com.yxj.stocks.application.pojo;

import java.io.Serializable;

public class ExternalStockQuote implements Serializable {

    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String sector;
    private double open;
    private long openTime;
    private double close;
    private double high;
    private double low;
    private double latestPrice;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }


    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    @Override
    public String toString () {
        return String.format("StockInfo {symbol='%s', companyName='%s', primaryExchange='%s', sector='%s', open='%s', openTime='%s', close='%s', high='%f', low='%f', latestPrice=%f}", symbol, companyName, primaryExchange, sector, open, openTime, close, high, low, latestPrice);
    }
}
