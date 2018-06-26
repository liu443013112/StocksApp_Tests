package com.yxj.stocks.application.repositories;

import com.yxj.stocks.application.pojo.ExternalStockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StockInfoRepositoryImpl implements StockInfoRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, ExternalStockQuote> hashOperations;


    private static final String KEY = "StockInfo";

    @Autowired
    public StockInfoRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(ExternalStockQuote externalStockQuote) {

        hashOperations.put(KEY, externalStockQuote.getSymbol(), externalStockQuote);
    }

    @Override
    public ExternalStockQuote find(String symbol) {
        return hashOperations.get(KEY, symbol);
    }
}
