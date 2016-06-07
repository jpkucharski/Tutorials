package com.jpk.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main
{

    public static void main( String Args[] )
    {
        ExecutorService executor = Executors.newFixedThreadPool( 5 );

        for( int i = 0; i < 10; i++ )
        {
            executor.submit( new ThreadX( i ) );
        }
        executor.shutdown();

        System.out.println( "Tasks assigned." );

        try
        {
            executor.awaitTermination( 1, TimeUnit.HOURS );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        System.out.println( "All tasks completed." );
        System.out.println( "Is Executor terminated? "+executor.isTerminated() );
    }

}
