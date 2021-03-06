package com.jpk.threads;

public class ThreadX
    extends Thread
{

    private String id;
    private final int sleepTime = 1000;

    public ThreadX( String id )
    {
        this.id = id;
    }


    public void run()
    {
        threadStatus();
    }


    private void threadStatus()
    {
        System.out.println( "Starting thread No. " + id );
        try
        {
            Thread.sleep( sleepTime );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        System.out.println( "Ending Thread No. " + id );
    }
}
