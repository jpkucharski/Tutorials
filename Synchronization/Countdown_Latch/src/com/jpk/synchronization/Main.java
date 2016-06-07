package com.jpk.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main
{

    public static void main( String[] args )
    {
        long startTime = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch( 3 );
        ExecutorService executor = Executors.newFixedThreadPool( 5 );

        for( int i = 0; i < 5; i++ )
        {
            Thread thread = new Thread(new ThreadX(latch, i));
            executor.submit( thread );
           
        }
        try
        {
            latch.await();
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println( "Program ended. Time: "+ (endTime-startTime)+ "ms" );
    }
}
