package com.chel.lab1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    protected Connection connection;

    public void createNewConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            final String MYSQLSERVER = "localhost",
                    DATABASE = "horserace",
                    USER = "connector",
                    PASSWORD = "1111";


            connection = DriverManager
                    .getConnection("jdbc:mysql://"+MYSQLSERVER+"/"+DATABASE+"?"
                            + "user="+USER+"&password="+PASSWORD+"&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
