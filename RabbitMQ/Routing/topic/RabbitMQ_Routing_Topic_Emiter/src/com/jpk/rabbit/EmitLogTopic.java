package com.jpk.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class EmitLogTopic
{

    private static final String EXCHANGE_NAME = "EXCHANGE_NAME_FOR_TOPIC";
    private static final String ROUTING_KEY = "ROUTING_KEY_NAME_1";
    private static final String TEST_MESSAGE_TEXT = "TEST_MESSAGE_1_FROM_TOPIC_EMITER";
    private static int counter = 0;


    public static void main( String[] argv ) throws InterruptedException
    {
        Connection connection = null;
        Channel channel = null;

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "localhost" );
        while( true )
        {
            try
            {
                connection = factory.newConnection();

                channel = connection.createChannel();

                channel.exchangeDeclare( EXCHANGE_NAME, "topic" );
                String message = TEST_MESSAGE_TEXT + "_" + counter;

                channel.basicPublish( EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes( "UTF-8" ) );
                System.out.println( " [x] Sent '" + ROUTING_KEY + "':'" + message + "'" );
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
                counter++;
                Thread.sleep( 500 );
            }
        }
    }
}
