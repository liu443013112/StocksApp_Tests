package com.yxj.stocks.application.controllers;


import com.yxj.stocks.application.payloads.CreateWatchListResponsePayload;
import com.yxj.stocks.application.payloads.GetStockInfoResponsePayload;
import com.yxj.stocks.application.payloads.UserPreferencesRequestPayload;
import com.yxj.stocks.application.pojo.UserPreferences;
import com.yxj.stocks.application.services.UserPreferencesService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserPreferencesController {

    @Autowired
    private UserPreferencesService userPreferencesService;

    @PostMapping("/userPreferences")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid Payload"),
            @ApiResponse(code = 500, message = "Application Failure")})
    public ResponseEntity<CreateWatchListResponsePayload> saveUserPreferences (@RequestBody @Valid UserPreferencesRequestPayload userPreferencesRequestPayload){

        UserPreferences userPreferences = new UserPreferences();

        userPreferences.setLanguage(userPreferencesRequestPayload.getLanguage());
        userPreferences.setUserId(userPreferencesRequestPayload.getUserId());
        userPreferences.setFavouriteWatchListId(userPreferencesRequestPayload.getFavouriteWatchListId());

        userPreferencesService.saveUserPreferences(userPreferences);

        return ResponseEntity.ok().build();

    }
}
