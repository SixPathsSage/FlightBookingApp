package com.leafvillage.flightbookingapp.helper;

import com.leafvillage.flightbookingapp.exceptions.InvalidParameterTypeException;

public class ConversionHelper {
    public static Long toLong(String input) {
        try {
            return Long.parseLong(input);
        }catch (NumberFormatException exception) {
            throw new InvalidParameterTypeException(exception);
        }
    }
}
