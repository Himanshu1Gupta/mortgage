package com.proptiger.mortgage.util;

import java.util.function.Supplier;

public class CommonUtil {

    public static <T> T getValue(Supplier<T> statement) {
        try {
            return statement.get();
        } catch (Exception exc) {
            return null;
        }
    }

    public static <T> T getValue(Supplier<T> statement, T defaultValue) {
        try {
            T value = statement.get();
            return value != null ? value : defaultValue;
        } catch (NullPointerException exc) {
            return defaultValue;
        }
    }

    public static Boolean getValueFromBoolean(Boolean val) {
        return val == null ? false : val;
    }
}
