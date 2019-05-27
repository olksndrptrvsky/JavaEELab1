package com.chel.lab1.controller.commands;

import java.util.regex.Pattern;

public class UrlEntry {
    private String pattern;
    private String method;

    public UrlEntry(String pattern, String method) {
        this.pattern = pattern;
        this.method = method;
    }

    public String getPattern() {
        return pattern;
    }

    public String getMethod() {
        return method;
    }
}
