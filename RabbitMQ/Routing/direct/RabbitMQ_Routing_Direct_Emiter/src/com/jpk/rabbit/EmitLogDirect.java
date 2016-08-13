package com.jpk.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;


public class EmitLogDirect
{
    /**
     * These (SEVERITY 1 and 2) are a Routing keys for Queues. Allows sending messages to the correct queue. If it will be not the same as
     * in receiver, you will be not able to send message to queue.
     */

    private static final String EXCHANGE_NAME = "direct_logs_test2";
    private static final String SEVERITY1 = "001X";
    private static final String SEVERITY2 = "002X";

    private static int counter = 0;


    public static void main( String[] argv ) throws java.io.IOException, TimeoutException, InterruptedException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "localhost" );

        while( true )
        {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare( EXCHANGE_NAME, "direct" );
            
            String severity = SEVERITY1;

            if( counter % 2 == 0 )
            {
               severity = SEVERITY2;
            }
           
            String message = "Emited direct_log for Routing key: " + severity + ", Message number: " + counter;
            channel.basicPublish( EXCHANGE_NAME, severity, null, message.getBytes() );
            System.out.println( "Sent message to queue with Routing key: " + 
                                severity + ", Message text: " + message );

            channel.close();
            connection.close();
            counter++;
            Thread.sleep( 500 );
        }
    }

}
