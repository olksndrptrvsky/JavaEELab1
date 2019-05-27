package com.chel.lab1.controller.commands;

import com.chel.lab1.entities.Client;
import com.chel.lab1.model.ClientModel;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.sql.SQLException;
import java.util.ArrayList;


public class GetClientsCommand implements Command {

    @Override
     public ArrayList<Client> execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException  {

        return new ClientModel().getAllClients();
    }
}
