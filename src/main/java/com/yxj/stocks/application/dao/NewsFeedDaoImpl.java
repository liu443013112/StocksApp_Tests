package com.yxj.stocks.application.dao;

import com.yxj.stocks.application.pojo.ExternalNewsFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class NewsFeedDaoImpl implements NewsFeedDao {

    @Value("${stock.info.endpoint}")
    private String stockInfoEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ExternalNewsFeed[] retrieveNewsFeed(String symbol) throws Exception {
        try {
            return restTemplate.getForObject(stockInfoEndpoint + "/" + symbol + "/news", ExternalNewsFeed[].class);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
