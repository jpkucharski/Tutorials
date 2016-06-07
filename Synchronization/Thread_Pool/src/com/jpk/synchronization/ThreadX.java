package com.jpk.synchronization;

public class ThreadX implements Runnable
{

    private int taskId;


    public ThreadX( int id )
    {
        this.taskId = id;
    }


    @Override
    public void run()
    {

        System.out.println( "Starting new thread with task No.: " + taskId );
        try
        {
            Thread.sleep( 500 );
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println( "Termination of thread with task No. "+ taskId );
    }

}
