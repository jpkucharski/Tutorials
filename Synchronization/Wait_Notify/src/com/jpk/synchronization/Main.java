package com.jpk.synchronization;

public class Main
{
    public static void main( String[] arg )
    {
        final ThreadX threadX = new ThreadX();

        Thread t1 = new Thread( new Runnable()
        {

            
            @Override
            public void run()
            {
                threadX.produce();

            }
        } );
        Thread t2 = new Thread( new Runnable()
        {

            @Override
            public void run()
            {
                threadX.consume();

            }
        } );

        t1.start();
        t2.start();
        
        try
        {
            t1.join();
            t2.join();
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
