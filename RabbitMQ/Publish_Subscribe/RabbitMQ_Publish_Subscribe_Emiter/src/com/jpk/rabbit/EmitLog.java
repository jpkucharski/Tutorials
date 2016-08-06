package com.jpk.rabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class EmitLog
{

    private static final String EXCHANGE_NAME = "logs";
    private static int counter = 0;


    public static void main( String[] argv ) throws java.io.IOException, TimeoutException, InterruptedException
    {

        while( true )
        {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost( "localhost" );
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare( EXCHANGE_NAME, "fanout" );

            String message = "emited log no: " + counter;

            channel.basicPublish( EXCHANGE_NAME, "", null, message.getBytes() );
            System.out.println( " [x] Sent '" + message + "'" );

            channel.close();
            connection.close();
            counter++;
            Thread.sleep(500);
        }
    }
}
