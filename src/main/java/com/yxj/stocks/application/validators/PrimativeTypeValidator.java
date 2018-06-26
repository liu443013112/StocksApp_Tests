package com.yxj.stocks.application.validators;

public class PrimativeTypeValidator {

    public static boolean isStrValid (String tobeValidated, String regularExpression) {
        return tobeValidated.matches(regularExpression);
    }


}
