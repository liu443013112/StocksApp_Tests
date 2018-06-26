package com.yxj.stocks.application.controllers;

import com.yxj.stocks.application.payloads.CreateWatchListResponsePayload;
import com.yxj.stocks.application.payloads.GetStockInfoResponsePayload;
import com.yxj.stocks.application.payloads.SymbolsRequestPayload;
import com.yxj.stocks.application.pojo.Symbols;
import com.yxj.stocks.application.services.SymbolsService;
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
public class SymbolsController {

    @Autowired
    private SymbolsService symbolsService;

    @PostMapping("/Symbols")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid Payload"),
            @ApiResponse(code = 500, message = "Application Failure")})
    public ResponseEntity<CreateWatchListResponsePayload> saveSymbols (@RequestBody @Valid SymbolsRequestPayload symbolsRequestPayload){

        Symbols symbols = new Symbols();

        symbols.setCurrentPrice(symbolsRequestPayload.getCurrentPrice());
        symbols.setSymbol(symbolsRequestPayload.getSymbol());
        symbols.setOpenPrice(symbolsRequestPayload.getOpenPrice());

        symbolsService.saveSymbols(symbols);

        return ResponseEntity.ok().build();

    }

}
