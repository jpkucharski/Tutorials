import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;


public class NewTask
{

    private static final String TASK_QUEUE_NAME = "task_queue";
    static int counter = 0;
    static Random random = new Random();

    public static void main( String[] argv ) throws java.io.IOException, TimeoutException, InterruptedException
    {
        while( true )
        {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost( "localhost" );
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare( TASK_QUEUE_NAME, true, false, false, null );

            String message = "Hello_RabbitMQ_" + counter;

            channel.basicPublish( "", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes() );
            System.out.println( " [x] Sent '" + message + "'" );

            channel.close();
            connection.close();
            counter++;
            Thread.sleep( random.nextInt( 1000 ) );
        }
    }
}
