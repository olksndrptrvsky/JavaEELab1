package com.chel.lab1.entities;

public class Client {
    private int id;
    private String login;
    private String pass;
    private double account;
    private String name;

    public Client(int id, String login, String pass, double account, String name) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.account = account;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", account=" + account +
                ", name='" + name + '\'' +
                '}';
    }
}
