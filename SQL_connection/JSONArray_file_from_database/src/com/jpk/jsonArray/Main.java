package com.jpk.jsonArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.mysql.jdbc.PreparedStatement;

public class Main
{

    public static void main( String[] args )
    {
        String USER = "root";
        String URL = "jdbc:mysql://localhost:3306/mydb";
        String PASSWORD = "";
        String QUERY = "SELECT * FROM users";

        Connection connection;
        try
        {
            connection = DriverManager.getConnection( URL, USER, PASSWORD );
            PreparedStatement query = (PreparedStatement)connection.prepareStatement( QUERY );
            System.out.println( "Connection sucess." );
            ResultSet rs = query.executeQuery();
            JSONArray jsonArray = toJSONArray( rs );
            System.out.println( "JSON Array from database: " + connection.getCatalog() );
            System.out.println( jsonArray );
            connection.close();
            System.out.println( "Connection close." );
        }
        catch( SQLException e)
        {
            System.out.println( "Sorry we was not able to connect to your dattabase. " );
            e.printStackTrace();
        }

    }


    public static JSONArray toJSONArray( ResultSet rs )
    {
        JSONArray json = new JSONArray();

        try
        {
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();

            while( rs.next() )
            {
                int numColumns = rsmd.getColumnCount();
                JSONObject jsonObject = new JSONObject();

                for( int i = 1; i <= numColumns; i++ )
                {
                    String column_name = rsmd.getColumnName( i );

                    if( rsmd.getColumnType( i ) == java.sql.Types.VARCHAR )
                    {
                        jsonObject.put( column_name, rs.getString( i) );
                    }
                    if( rsmd.getColumnType( i ) == java.sql.Types.INTEGER )
                    {
                        jsonObject.put( column_name, rs.getInt( i ) );
                    }
                    else
                    {
                    }
                }
                json.put( jsonObject );
            }

        }
        catch( JSONException e )
        {
            System.out.println( "There was a problem with JSON file." );
            e.printStackTrace();
        }
        catch( SQLException e )
        {
            System.out.println( "There was a problem with SQL database." );
            e.printStackTrace();
        }

        return json;
    }

}

