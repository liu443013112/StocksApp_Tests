package com.yxj.stocks.application.services;

import com.yxj.stocks.application.pojo.ExternalStockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class WatchListService {

    @Autowired
    private StockInfoService stockInfoService;

    @Autowired
    private Executor executor;

    public List<ExternalStockQuote> getWatchListStockInfo (List<String> symbols) {

       List<ExternalStockQuote> externalStockQuotes = new ArrayList<>();

       for (String symbol: symbols) {
           new CompletableFuture<ExternalStockQuote>().supplyAsync(() ->
           {
               try {
                   System.out.println (String.format("handling %s", symbol));
                   return stockInfoService.getQuote(symbol, 0);
               } catch (Exception e) {
                   System.out.println (String.format("%s is not a valid stock symbol", symbol));
                   return null;
               }
           }, executor)
                   .thenAcceptAsync(s ->
                   {
                       if (null != s) {
                           externalStockQuotes.add(s);
                           System.out.println(String.format("added %s", s.getSymbol()));
                       }

                   });

               }


        return externalStockQuotes;
    }
}
