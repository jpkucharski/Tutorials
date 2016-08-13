package com.jpk.rabbit;

import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;


public class EmitLogHeader
{
    private static final String EXCHANGE_NAME = "header_test";
    private static int counter;

    public static void main( String[] argv ) throws Exception
    {
        String routingKey = "ourTestRoutingKey";


        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put( "header_1", "argument_1" );

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "localhost" );

        while( true )
        {
            String message = "message_" + counter;

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare( EXCHANGE_NAME, "headers" );

            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
           
            builder.deliveryMode( MessageProperties.PERSISTENT_TEXT_PLAIN.getDeliveryMode() );
            builder.priority( MessageProperties.PERSISTENT_TEXT_PLAIN.getPriority() );
          
            builder.headers( headers );
            
            AMQP.BasicProperties theProps = builder.build();
           
            channel.basicPublish( EXCHANGE_NAME, routingKey, theProps, message.getBytes( "UTF-8" ) );
            System.out.println( " [x] Sent message: '" + message + "'" );
            Thread.sleep( 1000 );
            counter++;
        }
    }
}
