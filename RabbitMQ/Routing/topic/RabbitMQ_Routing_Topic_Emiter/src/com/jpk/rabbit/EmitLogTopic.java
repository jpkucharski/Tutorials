package com.jpk.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class EmitLogTopic
{
    private static final String EXCHANGE_NAME = "topic_logs";
    private static int counter = 0;
    private static int swich = 1;


    public static void main( String[] argv ) throws InterruptedException
    {
        Connection connection = null;
        Channel channel = null;
        String[] routingTable = { "lazy", "quick.orange.rabbit", "leazy.pink.elephant" };
        while( true )
        {
            try
            {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost( "localhost" );
                connection = factory.newConnection();
                channel = connection.createChannel();
                channel.exchangeDeclare( EXCHANGE_NAME, "topic" );

                String routingKey = getRouting( routingTable );
                String message = "Routing key: " + routingKey + " ,Topic_Test_Message_No: " + counter;

                channel.basicPublish( EXCHANGE_NAME, routingKey, null, message.getBytes( "UTF-8" ) );
                System.out.println( " [x] Sent '" + routingKey + "':'" + message + "'" );

                channel.close();
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
            finally
            {
                if( connection != null )
                {
                    try
                    {
                        connection.close();
                    }
                    catch( Exception ignore )
                    {
                    }
                }
            }
            counter++;
            swich++;
            Thread.sleep( 500 );
        }
    }


    private static String getRouting( String[] strings )
    {
        String actualRoutingKey = null;

        if( swich == 4 )
        {
            swich = 1;
        }
        if( swich == 1 )
        {
            actualRoutingKey = strings[0];
        }
        if( swich == 2 )
        {
            actualRoutingKey = strings[1];
        }
        if( swich == 3 )
        {
            actualRoutingKey = strings[2];
        }
        return actualRoutingKey;
    }
}
