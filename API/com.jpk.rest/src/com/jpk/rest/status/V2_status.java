package com.jpk.rest.status;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;

import com.jpk.rest.dao.EmployeeMapperClass;
import com.jpk.rest.dao.QueriesForSQL;


@Path( "/v2" )
public class V2_status
{

    private static final String VERSION = "002";


    @GET
    @Produces( MediaType.TEXT_HTML )
    public String returnTitle()
    {

        return "<p>Java Web Service V2 <br>" + "/version for version <br>" +
            "/employees for all employees from database in JSONArray format <br>" +
            "/employees?proffesion=programmer for all employess with programmer profession in JSONArray format <br>" +
            "http://localhost:8080/com.jpk.rest/post.html for update form in V2. </p>";
    }


    @GET
    @Produces( MediaType.TEXT_HTML )
    @Path( "/version" )
    public String returnVersion()
    {
        return "<p>Version of this API is: </p>" + VERSION;
    }


    @GET
    @Path( "/employees" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnBrandParts( @QueryParam( "profession" ) String profession)
    {

        String returnString = null;
        JSONArray jsonArray = new JSONArray();
        QueriesForSQL dao = new QueriesForSQL();

        try
        {
            if( profession == null )
            {
                jsonArray = dao.queryReturnAll();
            }
            else
            {
                jsonArray = dao.queryReturnProfession( profession );
            }
            returnString = jsonArray.toString();

        }
        catch( Exception e )
        {
            e.printStackTrace();
            return Response.status( 500 ).entity( "Wrong profession of employee." ).build();
        }

        return Response.ok( returnString ).build();

    }

   
    @POST
    @Consumes( { MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON } )
    @Produces( MediaType.APPLICATION_JSON )
    public Response addEmployeeByMapper( String incomingData ) throws Exception
    {

        String returnString = null;
        QueriesForSQL dao = new QueriesForSQL();

        try
        {
            System.out.println( "incomingData: " + incomingData );

            ObjectMapper mapper = new ObjectMapper();
            EmployeeMapperClass employeeMapperEntry = mapper.readValue( incomingData, EmployeeMapperClass.class );

            int http_code = dao.insertInToEmployeesList( employeeMapperEntry.name, employeeMapperEntry.email, employeeMapperEntry.profession );

            if( http_code == 200 )
            {
                returnString = "Item inserted";
            }
            else
            {
                return Response.status( 500 ).entity( "Unable to process Item" ).build();
            }

        }
        catch( Exception e )
        {
            e.printStackTrace();
            return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
        }

        return Response.ok( returnString ).build();
    }

}
