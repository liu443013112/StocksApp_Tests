package com.yxj.stocks.application.controllers;

import com.yxj.stocks.application.payloads.CreateWatchListRequestPayload;
import com.yxj.stocks.application.payloads.CreateWatchListResponsePayload;
import com.yxj.stocks.application.payloads.GetWatchListResponsePayload;
import com.yxj.stocks.application.payloads.UpdateWatchListRequestPayload;
import com.yxj.stocks.application.services.WatchListService;
import com.yxj.stocks.application.validators.CreateWatchListValidator;
import com.yxj.stocks.application.validators.PrimativeTypeValidator;
import com.yxj.stocks.application.validators.UpdateWatchListValidator;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class WatchListController {

    @Autowired
    private CreateWatchListValidator createWatchListValidator;

    @Autowired
    private UpdateWatchListValidator updateWatchListValidator;

    @Autowired
    private WatchListService watchListService;

    @InitBinder("createWatchListRequestPayload")
    public void setupCreateWatchListBinder(WebDataBinder binder) {
        binder.addValidators(createWatchListValidator);
    }

    @InitBinder("updateWatchListRequestPayload")
    public void setupUpdateWatchListBinder(WebDataBinder binder) {
        binder.addValidators(updateWatchListValidator);
    }

    @PostMapping ("/watchList")
    public ResponseEntity <CreateWatchListResponsePayload> createWatchList (@RequestBody @Valid CreateWatchListRequestPayload createWatchListRequestPayload){

        return ResponseEntity.ok(new CreateWatchListResponsePayload());

    }

    @PutMapping("/watchList")
    public ResponseEntity updateWatchList (@RequestBody @Valid UpdateWatchListRequestPayload updateWatchListRequestPayload){

        return ResponseEntity.ok().build();

    }

    @GetMapping(path = "/watchList/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = GetWatchListResponsePayload.class),
            @ApiResponse(code = 404, message = "Not Found", response = Errors.class),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity <GetWatchListResponsePayload> getWatchListStockInfo (@PathVariable int id) {

        GetWatchListResponsePayload getWatchListResponsePayload = new GetWatchListResponsePayload();

        if (!PrimativeTypeValidator.isStrValid(String.valueOf(id), "^[0-9]*$")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(getWatchListResponsePayload);
        }

        List<String> symbols = new ArrayList<String>();

        symbols.add("AAPL");
        symbols.add("GOOG");
        symbols.add("NFLX");
        symbols.add("PVTL");
        symbols.add("IQ");
        symbols.add("AMZN");
        symbols.add("FAKESYMBOL");

        watchListService.getWatchListStockInfo(symbols);

        return ResponseEntity.ok(getWatchListResponsePayload);

    }

}
