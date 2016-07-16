package com.jpk.rest.status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import com.mysql.jdbc.PreparedStatement;


@Path( "/v1" )
public class V1_status
{
    private static final String VERSION = "001";
    private static Connection connection = null;
    private static final String SELECT_ALL_QUERY = "SELECT id, name, email, profession FROM users";


    @GET
    @Produces( MediaType.TEXT_HTML )
    public String returnTitle()
    {
        return "<p>Java Web Service V1. <br>" +
            "Search by profession example:   '../api/v1/sql_search_profession?profession=programmer'  </p>";
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
    @Path( "/sqlall" )
    public Response returnAllUsers() throws SQLException
    {
        String responce = null;
        try
        {
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            PreparedStatement query = (PreparedStatement)connection.prepareStatement( SELECT_ALL_QUERY );
            ResultSet resultSet = query.executeQuery();
            JSONArray jsonArray = com.jpk.rest.status.converter.ResultSetConverter.convert( resultSet );
            query.close();
            responce = "" + jsonArray;
        }
        catch( Exception e )
        {
            e.printStackTrace();
            responce = "<p>Sorry something was wrong.</p>";
        }
        finally
        {
            if( connection != null )
            {
                connection.close();
            }
        }
        return Response.ok( responce ).build();
    }


    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "/sql_search_profession" )
    public Response returnSearchProfession( @QueryParam( "profession" ) String profession) throws SQLException
    {
        String responce = null;

        try
        {
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            PreparedStatement query = (PreparedStatement)connection
                .prepareStatement( "SELECT id, name, email, profession FROM users " + "where profession = ? " );
            query.setString( 1, profession );
            ResultSet resultSet = query.executeQuery();
            JSONArray jsonArray = com.jpk.rest.status.converter.ResultSetConverter.convert( resultSet );
            query.close();
            responce = jsonArray.toString();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            responce = "<p>Sorry something was wrong.</p>";
        }
        finally
        {
            if( connection != null )
            {
                connection.close();
            }
        }

        return Response.ok( responce ).build();
    }
}
