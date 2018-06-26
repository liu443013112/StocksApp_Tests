package com.yxj.stocks.application.services;

import com.yxj.stocks.application.pojo.Symbols;
import com.yxj.stocks.application.repositories.SymbolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymbolsService {

    @Autowired
    private SymbolsRepository symbolsRepository;

    public Symbols getSymbols(String symbol){
        return symbolsRepository.find(symbol);

    }

    public void saveSymbols (Symbols symbols){
        symbolsRepository.save(symbols);

    }
}
