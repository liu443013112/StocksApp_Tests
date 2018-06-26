package com.yxj.stocks.application.services;

import com.yxj.stocks.application.pojo.UserPreferences;
import com.yxj.stocks.application.repositories.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferencesService {

    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    public UserPreferences getUserPreferences(String userId){
        return userPreferencesRepository.find(userId);

    }

    public void saveUserPreferences (UserPreferences userPreferences){
        userPreferencesRepository.save(userPreferences);

    }
}
