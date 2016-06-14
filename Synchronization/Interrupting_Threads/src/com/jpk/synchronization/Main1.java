package com.jpk.synchronization;

import java.util.Random;

public class Main1
{

    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Program start." );

        Thread thread = new Thread( new Runnable()
        {

            @Override
            public void run()
            {
                Random random = new Random();
                for ( int i=0; i<1E8;i++){
                   
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println( "Thread Interrupted!" );
                        break;
                    }
                    Math.sin( random.nextDouble() );
                }
                
            }
        } );

        thread.start();
        
        Thread.sleep( 500 );
        
        thread.interrupt();
        
        thread.join();

        System.out.println( "Program finished." );

    }

}
