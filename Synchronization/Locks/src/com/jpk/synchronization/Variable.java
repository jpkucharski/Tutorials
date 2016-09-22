package com.jpk.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Variable
{

    Object lock1 = new Object();
    Object lock2 = new Object();

    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();


    public void main()
    {
        System.out.println( "Program started: " );
        long start = System.currentTimeMillis();

        ArrayList<Thread> listOfThreads = new ArrayList<>();
        for( int i = 0; i < 4; i++ )
        {
            Thread thread = new Thread( new ThreadX( this ) );
            listOfThreads.add( thread );
        }

        for( Thread t : listOfThreads )
        {
            t.start();
        }
        for( Thread t : listOfThreads )
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

        long stop = System.currentTimeMillis();
        System.out.println( "Program time: " + (stop - start) );
        System.out.println( "Size of list1: " + list1.size() + " Size of list 2: " + list2.size() );
    }


    public void stageOne()
    {
        synchronized( lock1 )
        {
            list1.add( random.nextInt( 100 ) );
            System.out.println( "Method1: " +Thread.currentThread().getName() );
            try
            {
                Thread.sleep( 1 );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }


    public void stageTwo()
    {
        synchronized( lock2 )
        {
            list2.add( random.nextInt( 100 ) );
            System.out.println( "Method2: " +Thread.currentThread().getName() );
            try
            {
                Thread.sleep( 1 );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }


    public void process()
    {
        for( int i = 0; i < 1000; i++ )
        {
            stageOne();
            stageTwo();
        }
    }
}
