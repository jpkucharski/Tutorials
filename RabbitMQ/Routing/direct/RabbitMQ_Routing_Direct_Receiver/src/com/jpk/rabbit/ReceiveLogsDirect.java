package com.jpk.rabbit;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;


public class ReceiveLogsDirect
{
/**
 * Remember to determine SEVERITY ("001X" or "002X" as in message-emitter for setting correct Routing key of Queue.
 */
    
    private static final String EXCHANGE_NAME = "direct_logs_test2";
    private static final String SEVERITY = "002X";


    public static void main( String[] argv ) throws java.io.IOException, java.lang.InterruptedException, TimeoutException
    {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost( "localhost" );
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare( EXCHANGE_NAME, "direct" );
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind( queueName, EXCHANGE_NAME, SEVERITY );

        System.out.println( " [*] Waiting for messages. To exit press CTRL+C" );

        QueueingConsumer consumer = new QueueingConsumer( channel );
        channel.basicConsume( queueName, true, consumer );

        while( true )
        {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String( delivery.getBody() );
            String routingKey = delivery.getEnvelope().getRoutingKey();

            System.out.println( "Received. Queue name: "+ queueName + ", Routing key: " + routingKey + ", Message: " + message );
        }
    }
}