package com.yxj.stocks.application.pojo;

import java.io.Serializable;

public class UserPreferences implements Serializable {

    private String language;
    private String favouriteWatchListId;
    private String userId;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFavouriteWatchListId() {
        return favouriteWatchListId;
    }

    public void setFavouriteWatchListId(String favouriteWatchListId) {
        this.favouriteWatchListId = favouriteWatchListId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("UserPreferences {language='%s', favouriteWatchListId='%s', userId='%d'}", language, favouriteWatchListId, userId);

    }
}
