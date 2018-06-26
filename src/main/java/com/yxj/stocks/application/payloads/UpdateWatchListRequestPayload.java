package com.yxj.stocks.application.payloads;

public class UpdateWatchListRequestPayload {

    private int watchListId;
    private String symbol;
    private UpdateWatchListOperation updateWatchListOperation;

    public enum UpdateWatchListOperation {
        ADD, REMOVE
    }

    public int getWatchListId() {
        return watchListId;
    }

    public void setWatchListId(int watchListId) {
        this.watchListId = watchListId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public UpdateWatchListOperation getUpdateWatchListOperation() {
        return updateWatchListOperation;
    }

    public void setUpdateWatchListOperation(UpdateWatchListOperation updateWatchListOperation) {
        this.updateWatchListOperation = updateWatchListOperation;
    }

}
