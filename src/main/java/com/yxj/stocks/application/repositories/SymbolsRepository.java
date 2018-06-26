package com.yxj.stocks.application.repositories;

import com.yxj.stocks.application.pojo.Symbols;

public interface SymbolsRepository {

    void save (Symbols symbols);
    Symbols find (String symbol);
}
