package com.yxj.stocks.application.payloads;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


public class UserPreferencesRequestPayload {

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


}
