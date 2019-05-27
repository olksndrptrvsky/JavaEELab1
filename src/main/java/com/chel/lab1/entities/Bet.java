package com.chel.lab1.entities;

public class Bet {
    private int id;
    private int clientId;
    private int participantId;
    private double sum;
    private String state;

    public Bet(int id, int clientId, int participantId, double sum, String state) {
        this.id = id;
        this.clientId = clientId;
        this.participantId = participantId;
        this.sum = sum;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
