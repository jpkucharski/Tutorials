package com.jpk.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;


import com.rabbitmq.client.AMQP.BasicProperties;


public class RPCServer
{

    private static final String RPC_QUEUE_NAME = "rpc_queue";
    private static String[] custommers = { "Peter", "Alex", "Megan", "Tom", "Lorraine" };

    private static boolean membership( String member )
    {
        boolean membership = false;
        outerloop:
        for( String x : custommers )
        {
           if( x.equals( member ) == true){
               membership = true;
               break outerloop;
           };
        }
        return membership;
    }

    public static void main( String[] argv )
    {
        Connection connection = null;
        Channel channel = null;

        try
        {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost( "localhost" );

            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare( RPC_QUEUE_NAME, false, false, false, null );

            channel.basicQos( 1 );

            QueueingConsumer consumer = new QueueingConsumer( channel );
            channel.basicConsume( RPC_QUEUE_NAME, false, consumer );

            System.out.println( " [x] Awaiting RPC requests:" );

            while( true )
            {
                String response = null;

                QueueingConsumer.Delivery delivery = consumer.nextDelivery();

                BasicProperties props = delivery.getProperties();
                BasicProperties replyProps = new BasicProperties.Builder().correlationId( props.getCorrelationId() ).build();

                try
                {
                    String message = new String( delivery.getBody(), "UTF-8" );
                    boolean responceToClient = membership(message);
                    
                    System.out.println( " [.]" + " Is "+message +" a member? "+responceToClient);

                    response = "If you are a member? Answer is: " + responceToClient;
                }
                catch( Exception e )
                {
                    System.out.println( " [.] " + e.toString() );
                    response = "";
                }
                finally
                {
                    channel.basicPublish( "", props.getReplyTo(), replyProps, response.getBytes( "UTF-8" ) );

                    channel.basicAck( delivery.getEnvelope().getDeliveryTag(), false );
                }
            }
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
    }
}
