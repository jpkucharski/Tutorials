package com.jppk.rabbit;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;
import com.rabbitmq.client.AMQP.BasicProperties;
import java.util.UUID;

public class RPCClient {

  private Connection connection;
  private Channel channel;
  private String requestQueueName = "rpc_queue";
  private String replyQueueName;
  private QueueingConsumer consumer;
  

  public RPCClient() throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    connection = factory.newConnection();
    channel = connection.createChannel();

    replyQueueName = channel.queueDeclare().getQueue();
    consumer = new QueueingConsumer(channel);
    channel.basicConsume(replyQueueName, true, consumer);
  }

  public String call(String message) throws Exception {
    String response = null;
    String corrId = UUID.randomUUID().toString();

    BasicProperties props = new BasicProperties
                                .Builder()
                                .correlationId(corrId)
                                .replyTo(replyQueueName)
                                .build();

    channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

    while (true) {
      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
      if (delivery.getProperties().getCorrelationId().equals(corrId)) {
        response = new String(delivery.getBody(),"UTF-8");
        break;
      }
    }

    return response;
  }

  public void close() throws Exception {
    connection.close();
  }

  public static void main(String[] argv) throws InterruptedException {
    RPCClient fibonacciRpc = null;
    String response = null;
   String name = "Peter";
    try {
      fibonacciRpc = new RPCClient();

      System.out.println(" [x] Am I a member? "+ name);
      response = fibonacciRpc.call(name);
      System.out.println(" [.] Got responce from server. '" + response + "'");
    }
    catch  (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (fibonacciRpc!= null) {
        try {
          fibonacciRpc.close();
        }
        catch (Exception ignore) {}
      }
    }
    
   
    
  }
}

