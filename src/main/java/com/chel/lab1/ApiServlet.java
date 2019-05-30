package com.chel.lab1;

import com.chel.lab1.controller.commands.Command;
import com.chel.lab1.controller.commands.CommandFactory;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;


@WebServlet("/api/*")
public class ApiServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ApiServlet.class.getName());


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();

        try {
            Class.forName("com.google.gson.Gson");
            CommandFactory commandFactory = new CommandFactory();
            Command command = commandFactory.getCommand(req.getRequestURI(), req.getMethod());
            out.println(new Gson().toJson(command.execute(req, resp)));
        } catch (SQLException | ClassNotFoundException ex) {
            logger.info(ex.getMessage());
        }
    }

}
