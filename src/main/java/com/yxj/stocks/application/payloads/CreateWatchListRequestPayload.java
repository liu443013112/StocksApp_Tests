package com.yxj.stocks.application.payloads;


import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateWatchListRequestPayload {

    @NotNull
    private int userId;

    @NotNull
    private String watchListName;


    private List<String> watchListStockSymbols;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWatchListName() {
        return watchListName;
    }

    public void setWatchListName(String watchListName) {
        this.watchListName = watchListName;
    }

    public List<String> getWatchListStockSymbols() {
        return watchListStockSymbols;
    }

    public void setWatchListStockSymbols(List<String> watchListStockSymbols) {
        this.watchListStockSymbols = watchListStockSymbols;
    }
}
