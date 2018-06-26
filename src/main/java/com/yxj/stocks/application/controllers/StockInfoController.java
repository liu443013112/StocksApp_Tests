package com.yxj.stocks.application.controllers;

import com.yxj.stocks.application.payloads.GetStockInfoResponsePayload;
import com.yxj.stocks.application.pojo.ExternalStockQuote;
import com.yxj.stocks.application.services.StockInfoService;
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


@RestController
public class StockInfoController {

    @Autowired
    private StockInfoService stockInfoService;

    private static final Logger logger = LoggerFactory.getLogger(StockInfoController.class);


    @GetMapping(path = "/stockInfo/{symbol}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = GetStockInfoResponsePayload.class),
            @ApiResponse(code = 404, message = "Not Found", response = Errors.class),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity <GetStockInfoResponsePayload> getStockInfoBySymbol (@RequestHeader(value="requestId", required=true) String requestId,
                                                                              @PathVariable String symbol) {

        GetStockInfoResponsePayload stockInfoResponsePayload = new GetStockInfoResponsePayload ();

        logger.info(symbol);

        if (!PrimativeTypeValidator.isStrValid(symbol, "^[A-Za-z]*$")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(stockInfoResponsePayload);
        }


        try {
            ExternalStockQuote externalStockQuote = stockInfoService.getQuote(symbol);

            stockInfoResponsePayload.setSymbol(externalStockQuote.getSymbol());
            stockInfoResponsePayload.setLongName(externalStockQuote.getCompanyName());
            stockInfoResponsePayload.setCurrentPrice(externalStockQuote.getLatestPrice());

            return ResponseEntity.ok(stockInfoResponsePayload);

        } catch (Exception e) {

            stockInfoResponsePayload.setErrorMsg("Error while processing");
            return ResponseEntity.status(500)
                    .body(stockInfoResponsePayload);
        }



    }
}
