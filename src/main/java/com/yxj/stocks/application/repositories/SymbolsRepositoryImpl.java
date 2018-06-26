package com.yxj.stocks.application.repositories;

import com.yxj.stocks.application.pojo.Symbols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

@Repository
public class SymbolsRepositoryImpl implements SymbolsRepository{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Symbols> hashOperations;

    private static final String KEY = "Symbols";


    @Autowired
    public SymbolsRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(Symbols.class));
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Symbols symbols) {
        hashOperations.put(KEY, symbols.getSymbol(), symbols);

    }

    @Override
    public Symbols find(String symbol) {

        return hashOperations.get(KEY, symbol);
    }

}
