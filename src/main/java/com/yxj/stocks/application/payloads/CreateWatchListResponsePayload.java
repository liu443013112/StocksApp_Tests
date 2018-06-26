package com.yxj.stocks.application.payloads;

public class CreateWatchListResponsePayload extends BaseResponsePayload {

    private String watchListId;

    public String getWatchListId() {
        return watchListId;
    }

    public void setWatchListId(String watchListId) {
        this.watchListId = watchListId;
    }

}
