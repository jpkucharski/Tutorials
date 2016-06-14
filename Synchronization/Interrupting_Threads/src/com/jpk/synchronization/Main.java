package com.jpk.synchronization;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Main
{
    public static void main( String[] arg ) throws InterruptedException
    {

        System.out.println( "Program start." );

        ExecutorService exec = Executors.newCachedThreadPool();

        Future<?> future = exec.submit( new Callable<Void>()
        {

            @Override
            public Void call() throws Exception
            {
                Random random = new Random();

                for( int i = 0; i < 1E8; i++ )
                {

                    if( Thread.currentThread().isInterrupted() )
                    {
                        System.out.println( "Thread interrupted!" );
                        break;

                    }
                    Math.sin( random.nextDouble() );

                }
                return null;
            }

        } );

        exec.shutdown();

        Thread.sleep( 500 );

        future.cancel( true );
        // or
        exec.shutdownNow();

        exec.awaitTermination( 1, TimeUnit.DAYS );

        System.out.println( "Program finished." );

    }
}
