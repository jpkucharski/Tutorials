package com.jpk.synchronization;

import java.util.concurrent.CountDownLatch;


public class ThreadX
    implements Runnable
{

    private CountDownLatch latch;
    private int id;


    public ThreadX( CountDownLatch latch, int id )
    {
        this.latch = latch;
        this.id = id;
    }


    @Override
    public void run()
    {
        System.out.println( "Start thread..." );
        System.out.println( "Thread No.:" + id + " latch status in begining: " + latch.getCount() );
        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        latch.countDown();
        try
        {
            Thread.sleep( 10 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
            System.out.println( "Thread No.:" + id + " latch status in end: " + latch.getCount() );
    }

}
