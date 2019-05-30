package com.chel.lab1.controller.commands;

public class UrlEntry {
    private String pattern;
    private String method;

    private UrlEntry(String pattern, String method) {
        this.pattern = pattern;
        this.method = method;
    }

    private String getPattern() {
        return pattern;
    }

    private String getMethod() {
        return method;
    }
}
