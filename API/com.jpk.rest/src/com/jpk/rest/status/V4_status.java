package com.jpk.rest.status;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jpk.rest.dao.QueriesForSQL;

@Path( "/v4" )
public class V4_status
{

    @GET
    @Produces( MediaType.TEXT_HTML )
    public String returnTitle()
    {
        return "<p>Java Web Service V4 <br>" + "/version for version <p>";
    }

    @Path( "/update" )
    @PUT
    @Consumes( { MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON } )
    @Produces( MediaType.APPLICATION_JSON )
    public Response updateItem( String incomingData ) throws Exception
    {
        String returnString = null;
        int http_code;

        QueriesForSQL dao = new QueriesForSQL();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        try
        {
            JSONObject partsData = new JSONObject( incomingData );
            String id_string = partsData.optString( "ID_name" );
            int id = Integer.parseInt( id_string );
            String e_mail = partsData.optString( "EMAIL_name" );
            http_code = dao.updatePC_PARTS( id, e_mail );
            if( http_code == 200 )
            {
                jsonObject.put( "HTTP_CODE", "200" );
                jsonObject.put( "MSG", "Item has been updated successfully" );
            }
            else
            {
                return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
            }
            returnString = jsonArray.put( jsonObject ).toString();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return Response.status( 500 ).entity( "Server was not able to process your request" ).build();
        }
        return Response.ok( returnString ).build();
    }
    
    @Path("/delete")
    @DELETE
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem( String incomingData) throws Exception {
        
        System.out.println("incomingData: " + incomingData);
       
        
        
        int http_code = 0;
        String returnString = null;
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        QueriesForSQL dao = new QueriesForSQL();
        
        try {
            
            JSONObject partsData = new JSONObject( incomingData );
            String id_string = partsData.optString( "ID_name" );
            int id = Integer.parseInt( id_string );
            
            http_code = dao.deleteEmployee(id);
            
            if(http_code == 200) {
                jsonObject.put("HTTP_CODE", "200");
                jsonObject.put("MSG", "Item has been deleted successfully");
            } else {
                return Response.status(500).entity("Server was not able to process your request").build();
            }
            
            returnString = jsonArray.put(jsonObject).toString();
            
        } catch(Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Server was not able to process your request").build();
        }
        
        return Response.ok(returnString).build();
    }
}
    
