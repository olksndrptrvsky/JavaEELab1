package com.chel.lab1.entities;

public class Rider {
    private int id;
    private String fullName;
    private String horseBreed;
    private int winsCount;

    public Rider(int id, String fullName, String horseBreed, int winsCount) {
        this.id = id;
        this.fullName = fullName;
        this.horseBreed = horseBreed;
        this.winsCount = winsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHorseBreed() {
        return horseBreed;
    }

    public void setHorseBreed(String horseBreed) {
        this.horseBreed = horseBreed;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(int winsCount) {
        this.winsCount = winsCount;
    }
}
