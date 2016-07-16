package com.jpk.rest.status;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jpk.rest.dao.QueriesForSQL;


@Path( "/v3" )
public class V3_status
{

    private static final String VERSION = "003";


    @GET
    @Produces( MediaType.TEXT_HTML )
    public String returnTitle()
    {
        return "<p>Java Web Service V3 <br>" + "/version for version <br>" +
            "/employees for all employees from database in JSONArray format <br>" +
            "/employees/programmer <-- profession for all employess with programmer profession in JSONArray format <p>";
    }


    @GET
    @Produces( MediaType.TEXT_HTML )
    @Path( "/version" )
    public String returnVersion()
    {
        return "<p>Version of this API is: </p>" + VERSION;
    }


    @Path( "/employees" )
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnEmployees()

        throws Exception
    {

        String returnString = null;
        JSONArray jsonArray = new JSONArray();

        try
        {

            QueriesForSQL dao = new QueriesForSQL();
            jsonArray = dao.queryReturnAll();
            returnString = jsonArray.toString();
            return Response.ok( returnString ).build();

        }
        catch( SQLException e )
        {
            e.printStackTrace();
            return Response.status( 400 ).entity( "No database connection" ).build();
        }

        catch( Exception e )
        {
            e.printStackTrace();
            System.out.println( "Error" );
            return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
        }

    }


    @Path( "employees/{profession}" )
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnEmployeesByProfession( @PathParam( "profession" ) String profession) throws Exception
    {

        String returnString = null;
        JSONArray jsonArray = new JSONArray();

        try
        {

            QueriesForSQL dao = new QueriesForSQL();
            jsonArray = dao.queryReturnProfession( profession );
            returnString = jsonArray.toString();

        }
        catch( Exception e )
        {
            e.printStackTrace();
            return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
        }

        return Response.ok( returnString ).build();
    }


    @Path( "employees/{profession}/{name}" )
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnSpecificBrandItem( @PathParam( "profession" ) String profession, @PathParam( "name" ) String name)
        throws Exception
    {

        String returnString = null;
        JSONArray jsonArray = new JSONArray();
        QueriesForSQL dao = new QueriesForSQL();

        try
        {

            jsonArray = dao.queryReturnEmployeesByProfessionAndName( profession, name );
            returnString = jsonArray.toString();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
        }

        return Response.ok( returnString ).build();
    }


    @POST
    @Consumes( { MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON } )
    @Produces( MediaType.APPLICATION_JSON )
    public Response addEmployeeByObject( String incomingData ) throws Exception
    {

        String returnString = null;
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        QueriesForSQL dao = new QueriesForSQL();

        try
        {
            JSONObject partsData = new JSONObject( incomingData );
            System.out.println( "jsonData: " + partsData.toString() );

            int http_code = dao.insertInToEmployeesList( partsData.optString( "name" ),
                                                         partsData.optString( "email" ),
                                                         partsData.optString( "profession" ) );
            if( http_code == 200 )
            {
                jsonObject.put( "HTTP_CODE", "200" );
                jsonObject.put( "MSG", "Item has been entered successfully, Version 3" );
                returnString = jsonArray.put( jsonObject ).toString();
            }
            else
            {
                return Response.status( 500 ).entity( "Unable to enter Item" ).build();
            }
            System.out.println( "returnString: " + returnString );
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
        }

        return Response.ok( returnString ).build();
    }
       
}