package com.jpk.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Main
{
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>( 10 );

    private List<Thread> threadsList;

    public static void main( String[] args )
    {
        Main main = new Main();
        
        main.threadListCreator();
        for( int i = 0; i < 1; i++ )
        {
            Thread thread = new Thread( new ProducerThread( main ) );
            main.threadsList.add( thread );
        }
        for( int i = 0; i < 10; i++ )
        {
            Thread thread = new Thread( new ConsumerThread( main) );
            main.threadsList.add( thread );
        }
        main.threadsStarterFromList();
    }


    private List<Thread> threadListCreator()
    {
        threadsList = new ArrayList<>();
        return threadsList;
    }


    private void threadsStarterFromList()
    {
        for( Thread t : threadsList )
        {
            t.start();
        }
        for( Thread t : threadsList )
        {
            try
            {
                t.join();
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }


    public BlockingQueue<Integer> getQueue()
    {
        return queue;
    }
}
