package com.chel.lab1.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public interface Command<T> {
    T execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException ;
}
