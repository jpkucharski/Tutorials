package com.jpk.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection
{

    public static Connection connection = null;
    private static final String USER = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String PASSWORD = "";
    
    
    public static Connection getConnection()
    {
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            connection = DriverManager.getConnection( URL, USER, PASSWORD );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        return connection;
    }
}
