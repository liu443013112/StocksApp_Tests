package com.yxj.stocks.application.repositories;

import com.yxj.stocks.application.pojo.ExternalStockQuote;


public interface StockInfoRepository {

    void save (ExternalStockQuote externalStockQuote);
    ExternalStockQuote find (String symbol);


}
