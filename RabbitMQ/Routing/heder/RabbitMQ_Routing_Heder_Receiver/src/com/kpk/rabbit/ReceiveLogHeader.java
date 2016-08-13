package com.kpk.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReceiveLogHeader
{
    private static final String EXCHANGE_NAME = "header_test";

    public static void main( String[] argv ) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "localhost" );
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare( EXCHANGE_NAME, "headers" );

        String routingKeyFromUser = "ourTestRoutingKey";

        String queueInputName = "Queue_1";

        Map<String, Object> headers = new HashMap<String, Object>();

        headers.put( "header_1", "argument_1" );

        String queueName = channel.queueDeclare( queueInputName, true, false, false, null ).getQueue();
        channel.queueBind( queueName, EXCHANGE_NAME, routingKeyFromUser, headers );

        System.out.println( "Queue "+ queueInputName + " was created." );
        System.out.println( "[*] Waiting for messages. To exit press CTRL+C" );

        Consumer consumer = new DefaultConsumer( channel )
        {
            @Override
            public void handleDelivery( String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body )
                throws IOException
            {
                String message = new String( body, "UTF-8" );
                System.out.println( "Received. Queue name: "+queueInputName + ", Routing key: "+envelope.getRoutingKey() +
                    ", Header: "+headers.get( "header_1" )+
                    ", Message: " + message );
            }
        };
        channel.basicConsume( queueName, true, consumer );
    }
}
