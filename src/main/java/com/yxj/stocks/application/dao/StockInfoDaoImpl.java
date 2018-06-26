package com.yxj.stocks.application.dao;

import com.yxj.stocks.application.pojo.ExternalStockQuote;
import com.yxj.stocks.application.repositories.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StockInfoDaoImpl implements StockInfoDao {

    @Value("${stock.info.endpoint}")
    private String stockInfoEndpoint;

    @Autowired
    private StockInfoRepository stockInfoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ExternalStockQuote retrieveStockQuote(String symbol) throws Exception {


        try {
            return restTemplate.getForObject(stockInfoEndpoint + "/" + symbol + "/quote", ExternalStockQuote.class);
        } catch (Exception e) {
            throw new Exception();
        }


    }

}
