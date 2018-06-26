package com.yxj.stocks.application.validators;

import com.yxj.stocks.application.payloads.UpdateWatchListRequestPayload;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateWatchListValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UpdateWatchListRequestPayload.class.equals(clazz);
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {

        UpdateWatchListRequestPayload UpdateWatchListRequestPayload = (UpdateWatchListRequestPayload) target;

        if (UpdateWatchListRequestPayload.getSymbol().equalsIgnoreCase("AAPL")) {

            errors.rejectValue("symbol","111","we dont like APPLE PRODUCTS");
        }


    }
}
