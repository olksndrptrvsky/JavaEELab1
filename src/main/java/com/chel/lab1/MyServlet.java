package com.chel.lab1;

import com.chel.lab1.controller.Controller;
import com.chel.lab1.entities.Race;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@WebServlet("/api/*")
public class MyServlet extends HttpServlet {

    private Controller controller = Controller.getInstance();
//
//    public Map<String, String> getParams(HttpServletRequest request) {
//        String command = "get";
//        String parameters[] = request.getQueryString().split("[&]");
//
//        Map<String, String> params = new HashMap<>();
//        for (String parameter : parameters) {
//            String string[] = parameter.split("=");
//            params.put(string[0], string[1]);
//        }
//        return params;
//    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        try{
            Class.forName("com.google.gson.Gson");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //out.println(req.getMethod());
        //out.println(req.getRequestURI());
        try {
            out.println(new Gson().toJson(controller.executeCommand(req, resp)));
        } catch (Exception ex) {
            //out.println("EXCEPTION IS OCCURRED");
            ex.printStackTrace();
        }
    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        Map<String, String> params = this.getParams(request);
//        String command = "get" + controller.firstUpperCase(params.get("table"));
//        params.remove("table");
//        PrintWriter out = response.getWriter();
//
//
//        try {
//            out.print(controller.execute(command, params));
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("Hello from doPost");
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("Hello from doPut");
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("Hello from doDelete");
//        System.out.println("Hello from doDelete");
//    }
}
