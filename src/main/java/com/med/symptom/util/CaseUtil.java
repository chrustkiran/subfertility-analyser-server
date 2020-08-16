package com.med.symptom.util;

public class CaseUtil {
    public static String camelToSnake(String word) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return (word
                .replaceAll(regex, replacement)
                .toLowerCase());
    }
}
