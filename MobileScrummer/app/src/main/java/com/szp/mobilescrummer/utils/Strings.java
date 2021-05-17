package com.szp.mobilescrummer.utils;

public class Strings {
    public static boolean isEmptyOrNull(String string) {
        if (string == null)
            return true;

        string = string.trim();
        return string.isEmpty();

    }
}
