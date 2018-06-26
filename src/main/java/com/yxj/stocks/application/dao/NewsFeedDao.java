package com.yxj.stocks.application.dao;

import com.yxj.stocks.application.pojo.ExternalNewsFeed;

public interface NewsFeedDao {

    ExternalNewsFeed[] retrieveNewsFeed (String symbol) throws Exception;
}
