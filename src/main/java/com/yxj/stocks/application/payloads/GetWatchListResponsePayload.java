package com.yxj.stocks.application.payloads;

import com.yxj.stocks.application.pojo.ExternalStockQuote;

import java.util.List;

public class GetWatchListResponsePayload extends BaseResponsePayload {

    private List<ExternalStockQuote> externalStockQuoteList;

    public List<ExternalStockQuote> getExternalStockQuoteList() {
        return externalStockQuoteList;
    }

    public void setExternalStockQuoteList(List<ExternalStockQuote> externalStockQuoteList) {
        this.externalStockQuoteList = externalStockQuoteList;
    }
}
