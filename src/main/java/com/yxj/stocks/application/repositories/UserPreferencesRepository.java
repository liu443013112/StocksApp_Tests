package com.yxj.stocks.application.repositories;

import com.yxj.stocks.application.pojo.UserPreferences;

public interface UserPreferencesRepository {

    void save (UserPreferences userPreferences);
    UserPreferences find (String userId);
}
