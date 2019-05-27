package com.chel.lab1.entities;

public class Participant {
    private int id;
    private int raceId;
    private int riderId;
    private double coeff;

    public Participant(int id, int raceId, int riderId, double coeff) {
        this.id = id;
        this.raceId = raceId;
        this.riderId = riderId;
        this.coeff = coeff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }
}
