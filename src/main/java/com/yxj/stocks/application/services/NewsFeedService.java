package com.yxj.stocks.application.services;

import com.yxj.stocks.application.dao.NewsFeedDao;
import com.yxj.stocks.application.pojo.ExternalNewsFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsFeedService {

    @Autowired
    private NewsFeedDao newsFeedDao;

    public ExternalNewsFeed[] getNews (String symbol) throws Exception {


        return newsFeedDao.retrieveNewsFeed(symbol);



    }

}
