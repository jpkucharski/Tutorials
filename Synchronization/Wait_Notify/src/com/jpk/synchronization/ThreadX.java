package com.jpk.synchronization;

import java.util.Scanner;


public class ThreadX
{

    public void produce()
    {
        synchronized( this )
        {
            System.out.println( "Producer Thread running..." );
            try
            {
                wait();
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
            System.out.println( "Resumed" );

        }
    }


    public void consume()
    {

        @SuppressWarnings( "resource" )
        Scanner scanner = new Scanner( System.in );
        try
        {
            Thread.sleep( 2000 );
            synchronized( this )
            {
                System.out.println( "Waiting for return key." );
                scanner.nextLine();
                System.out.println( "Return key pressed." );
                notify();
                Thread.sleep( 5000 );

            }
        }
        catch( InterruptedException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
