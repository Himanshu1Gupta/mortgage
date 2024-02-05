package com.proptiger.mortgage.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

public class StringUtil {
    public static List<String> convertCommaSeparatedStringToStringList(String str) {
        if (StringUtil.isNullOrEmpty(str)) return new ArrayList<>();
        return Arrays.stream(str.split(",")).collect(Collectors.toList());
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty() || s.equalsIgnoreCase("null");
    }

    public static Boolean isNullOrEmptyString(Object obj) {
        return obj == null || String.valueOf(obj).isEmpty();
    }
}
