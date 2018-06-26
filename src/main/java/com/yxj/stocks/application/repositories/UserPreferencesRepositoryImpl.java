package com.yxj.stocks.application.repositories;

import com.yxj.stocks.application.pojo.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;


@Repository
public class UserPreferencesRepositoryImpl implements UserPreferencesRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, UserPreferences> hashOperations;

    private static final String KEY = "UserPreferences";


    @Autowired
    public UserPreferencesRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(UserPreferences.class));
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(UserPreferences userPreferences) {
        hashOperations.put(KEY, userPreferences.getUserId(), userPreferences);

    }

    @Override
    public UserPreferences find(String userId) {

        return hashOperations.get(KEY, userId);
    }
}
