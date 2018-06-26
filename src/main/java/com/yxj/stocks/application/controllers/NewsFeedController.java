package com.yxj.stocks.application.controllers;

import com.yxj.stocks.application.payloads.GetNewsFeedResponsePayload;
import com.yxj.stocks.application.pojo.ExternalNewsFeed;
import com.yxj.stocks.application.services.NewsFeedService;
import com.yxj.stocks.application.validators.PrimativeTypeValidator;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsFeedController {

    @Autowired
    private NewsFeedService newsFeedService;

    private static final Logger logger = LoggerFactory.getLogger(StockInfoController.class);


    @GetMapping(path = "/news/{symbol}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = GetNewsFeedResponsePayload.class),
            @ApiResponse(code = 404, message = "Not Found", response = Errors.class),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<GetNewsFeedResponsePayload> getNewsFeedBySymbol (@RequestHeader(value="requestId", required=true) String requestId,
                                                                             @PathVariable String symbol) {

        GetNewsFeedResponsePayload newsFeedResponsePayload = new GetNewsFeedResponsePayload ();


        logger.info(symbol);

        if (!PrimativeTypeValidator.isStrValid(symbol, "^[A-Za-z]*$")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(newsFeedResponsePayload);
        }


        try {
            ExternalNewsFeed[] externalNewsFeed = newsFeedService.getNews(symbol);

            List<GetNewsFeedResponsePayload.NewsFeedResponse> newsFeedResponseList = new ArrayList<GetNewsFeedResponsePayload.NewsFeedResponse>();

            for (ExternalNewsFeed news: externalNewsFeed) {
                GetNewsFeedResponsePayload.NewsFeedResponse newsFeedPayload = newsFeedResponsePayload.new NewsFeedResponse();
                newsFeedPayload.setDatetime(news.getDatetime());
                newsFeedPayload.setHeadline(news.getHeadline());
                newsFeedPayload.setRelated(news.getRelated());
                newsFeedPayload.setSource(news.getSource());
                newsFeedPayload.setSummary(news.getSummary());
                newsFeedPayload.setUrl(news.getUrl());

                newsFeedResponseList.add(newsFeedPayload);

            }

            newsFeedResponsePayload.setNewsFeedResponseList(newsFeedResponseList);

            return ResponseEntity.ok(newsFeedResponsePayload);

        } catch (Exception e) {

            newsFeedResponsePayload.setErrorMsg("Error while processing");
            return ResponseEntity.status(500)
                    .body(newsFeedResponsePayload);
        }

    }


}
