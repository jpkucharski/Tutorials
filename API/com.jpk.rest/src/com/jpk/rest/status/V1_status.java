package com.jpk.rest.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;

import com.mysql.jdbc.PreparedStatement;


@Path( "/v1" )
public class V1_status
{
    public static final String VERSION = "001";
    public static Connection connection = null;


    @GET
    @Produces( MediaType.TEXT_HTML )
    public String returnTitle()
    {
        return "<p>Java Web Service @GET retirnTitle method content. </p>";
    }


    @GET
    @Produces( MediaType.TEXT_HTML )
    @Path( "/version" )
    public String returnVersion()
    {
        return "<p>Version of this API is: </p>" + VERSION;

    }


    @GET
    @Produces( MediaType.TEXT_HTML )
    @Path( "/sql" )
    public Response returnJSON() 
    {
        String QUERY = "SELECT * FROM users";

        String responce = null;
        try
        {
            getConnection();
            PreparedStatement query = (PreparedStatement)connection.prepareStatement( QUERY );
            ResultSet rs = query.executeQuery();
            JSONArray jsonArray = com.jpk.rest.status.converter.ResultSetConverter.convert( rs );
            responce = "" + jsonArray;
        }
        catch( SQLException e )
        {
            System.out.println( "Sorry we was not able to connect to your dattabase. " );
            e.printStackTrace();
            responce = "<p>Sorry something was wrong in SQL connection.</p>";
        }
        catch(Exception e){
            e.printStackTrace();
            responce = "<p>Sorry something was wrong in JSON compilator.</p>";
        }
        return Response.ok( responce ).build();
    }


    public Connection getConnection()
    {

        String USER = "root";
        String URL = "jdbc:mysql://localhost:3306/mydb";
        String PASSWORD = "";

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
