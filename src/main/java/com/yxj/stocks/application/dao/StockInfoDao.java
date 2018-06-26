package com.yxj.stocks.application.dao;

import com.yxj.stocks.application.pojo.ExternalStockQuote;
import org.springframework.stereotype.Component;



public interface StockInfoDao {

    ExternalStockQuote retrieveStockQuote (String symbol) throws Exception;
}

