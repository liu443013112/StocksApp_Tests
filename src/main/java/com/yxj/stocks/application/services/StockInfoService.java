package com.yxj.stocks.application.services;

import com.yxj.stocks.application.dao.StockInfoDao;
import com.yxj.stocks.application.pojo.ExternalStockQuote;
import com.yxj.stocks.application.repositories.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockInfoService {

    @Autowired
    private StockInfoDao stockInfoDao;

    @Autowired
    private StockInfoRepository stockInfoRepository;


    public ExternalStockQuote getQuote (String symbol, int delay) throws Exception {
        Thread.sleep(delay);
        return getQuote(symbol);
    }

    public ExternalStockQuote getQuote (String symbol) throws Exception {


        return stockInfoDao.retrieveStockQuote(symbol);



    }
}
