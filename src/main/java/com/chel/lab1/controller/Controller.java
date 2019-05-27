package com.chel.lab1.controller;

import com.chel.lab1.controller.commands.Command;
import com.chel.lab1.controller.commands.CommandFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class Controller {

    private static Controller instance;


    public static Controller getInstance(){
        if (instance==null) instance = new Controller();
        return instance;
    }


    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public Object executeCommand(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {
        CommandFactory commandFactory = new CommandFactory();
        //System.out.println(req.getRequestURI());
        Command command = commandFactory.getCommand(req.getRequestURI(), req.getMethod());
        return command.execute(req, res);
    }

}
