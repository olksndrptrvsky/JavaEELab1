package com.chel.lab1.entities;

import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Race {
    private int id;
    private String dateTime;
    private String place;
    private int distance;
    private String winner;

    public Race() {
    }

    public Race(int id, String dateTime, String place, int distance, String winner) {
        this.id = id;
        this.dateTime = dateTime;
        this.place = place;
        this.distance = distance;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", place='" + place + '\'' +
                ", distance=" + distance +
                ", winner='" + winner + '\'' +
                '}';
    }

    public void formatDate() {
        dateTime = dateTime.replace(' ', 'T');
        dateTime+=".000Z";
    }
}
