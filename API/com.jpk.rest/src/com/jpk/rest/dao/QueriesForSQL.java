package com.jpk.rest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import com.mysql.jdbc.PreparedStatement;

public class QueriesForSQL
{

    public JSONArray queryReturnProfession( String profession ) throws Exception
    {

        JSONArray jsonArray = new JSONArray();
        Connection connection = null;
        try
        {
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            PreparedStatement query =
                (PreparedStatement)connection.prepareStatement( "SELECT id, name, email, profession FROM users where profession = ? " );
            query.setString( 1, profession );
            ResultSet resultSet = query.executeQuery();
            jsonArray = com.jpk.rest.status.converter.ResultSetConverter.convert( resultSet );
            query.close();
            connection.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return jsonArray;
        }
        finally
        {
            if( connection != null )
                connection.close();
        }

        return jsonArray;
    }


    public JSONArray queryReturnAll() throws Exception
    {

        JSONArray jsonArray = new JSONArray();
        Connection connection = null;
        try
        {
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            PreparedStatement query = (PreparedStatement)connection.prepareStatement( "SELECT id, name, email, profession FROM users" );
            ResultSet resultSet = query.executeQuery();
            jsonArray = com.jpk.rest.status.converter.ResultSetConverter.convert( resultSet );
            query.close();
            connection.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return jsonArray;
        }
        finally
        {
            if( connection != null )
                connection.close();
        }

        return jsonArray;
    }


    public int insertInToEmployeesList( String name, String email, String profession ) throws Exception
    {

        PreparedStatement query = null;
        Connection connection = null;

        try
        {

            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            query = (PreparedStatement)connection
                .prepareStatement( "insert into users " + "( name, email, profession) " + "VALUES ( ?, ?, ? ) " );

            query.setString( 1, name );
            query.setString( 2, email );
            query.setString( 3, profession );

            query.executeUpdate();

        }
        catch( Exception e )
        {
            e.printStackTrace();
            return 500;
        }
        finally
        {
            if( connection != null )
                connection.close();
        }

        return 200;
    }


    public JSONArray queryReturnEmployeesByProfessionAndName( String name, String profession ) throws Exception
    {

        PreparedStatement query = null;
        Connection connection = null;

        JSONArray jsonArray = new JSONArray();

        try
        {
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            query = (PreparedStatement)connection
                .prepareStatement( "select id, name, email, profession " + "from users " + "where profession = ? " + "and name = ?" );
            query.setString( 1, name );
            query.setString( 2, profession );
            ResultSet resultSet = query.executeQuery();
            jsonArray = com.jpk.rest.status.converter.ResultSetConverter.convert( resultSet );
            query.close();
        }
        catch( SQLException sqlError )
        {
            sqlError.printStackTrace();
            return jsonArray;
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return jsonArray;
        }
        finally
        {
            if( connection != null )
                connection.close();
        }

        return jsonArray;
    }


    public int updatePC_PARTS( int id, String email ) throws Exception
    {

        PreparedStatement query = null;
        Connection connection = null;

        try
        {
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            query = (PreparedStatement)connection.prepareStatement( "update users " + "set email = ? " + "where id = ? " );
            query.setString( 1, email );
            query.setInt( 2, id );
            query.executeUpdate();
            System.out.println( "updated in SQL database" );

        }
        catch( Exception e )
        {
            e.printStackTrace();
            return 500;
        }
        finally
        {
            if( connection != null )
                connection.close();
        }
        return 200;
    }

public int deleteEmployee(int pk) throws Exception {
        
        PreparedStatement query = null;
        Connection connection = null;
        
        try {
                     
            connection = com.jpk.rest.dao.SQLConnection.getConnection();
            query = (PreparedStatement)connection.prepareStatement("delete from users " +
                                            "where id = ? ");
            
            query.setInt(1, pk);
            query.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
            return 500;
        }
        finally {
            if (connection != null) connection.close();
        }
        
        return 200;
    }

}
