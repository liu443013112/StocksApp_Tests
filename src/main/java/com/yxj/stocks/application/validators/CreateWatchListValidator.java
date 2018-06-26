package com.yxj.stocks.application.validators;

import com.yxj.stocks.application.payloads.CreateWatchListRequestPayload;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CreateWatchListValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateWatchListRequestPayload.class.equals(clazz);
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {

        CreateWatchListRequestPayload createWatchListRequestPayload = (CreateWatchListRequestPayload) target;

        if (createWatchListRequestPayload.getUserId() == (123)) {
            errors.reject("123");
            errors.reject("456");
            errors.rejectValue("userId","111","we dont like user 123");
        }


    }
}
