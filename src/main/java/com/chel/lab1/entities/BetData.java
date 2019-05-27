package com.chel.lab1.entities;

public class BetData {
    private String riderFullName;
    private String racePlace;
    private String raceDateTime;
    private double sum;
    private double coeff;
    private String state;

    public BetData(double sum, String state) {
        this.sum = sum;
        this.state = state;
    }

    public String getRiderFullName() {
        return riderFullName;
    }

    public void setRiderFullName(String riderFullName) {
        this.riderFullName = riderFullName;
    }

    public String getRacePlase() {
        return racePlace;
    }

    public void setRacePlace(String racePlace) {
        this.racePlace = racePlace;
    }

    public String getRaceDateTime() {
        return raceDateTime;
    }

    public void setRaceDateTime(String raceDateTime) {
        this.raceDateTime = raceDateTime;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BetData{" +
                "riderFullName='" + riderFullName + '\'' +
                ", racePlace='" + racePlace + '\'' +
                ", raceDateTime=" + raceDateTime +
                ", sum=" + sum +
                ", coeff=" + coeff +
                ", state='" + state + '\'' +
                '}';
    }
}
