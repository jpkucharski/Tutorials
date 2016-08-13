package com.jpk.rabbit;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class EmitLog
{

    private static final String EXCHANGE_NAME = "TEST_1";
    private static int counter = 0;


    public static void main( String[] argv ) throws java.io.IOException, TimeoutException, InterruptedException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "localhost" );

        while( true )
        {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare( EXCHANGE_NAME, "fanout" );

            String message = "Message number: " + counter;

            channel.basicPublish( EXCHANGE_NAME, "", null, message.getBytes() );
            System.out.println( " Sent '" + message + "'" );

            channel.close();
            connection.close();
            counter++;
            Thread.sleep( 500 );
        }
    }
}
