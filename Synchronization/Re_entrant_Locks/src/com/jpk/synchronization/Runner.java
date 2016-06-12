package com.jpk.synchronization;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner
{

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();


    private void inclement()
    {
        for( int i = 0; i < 10000; i++ )
        {
            count++;
        }

    }


    public void firstThread() throws InterruptedException
    {
        lock.lock();
        
        System.out.println( "Waiting!" );
        cond.await();
        
        System.out.println( "Woken up!" );
        

        try
        {
            inclement();
        }
        finally
        {
            lock.unlock();
        }

    }


    public void secoundThread() throws InterruptedException
    {

        Thread.sleep( 1000 );
        lock.lock();

        System.out.println( "pres the return key." );
        new Scanner( System.in ).nextLine();
        System.out.println( "Got return key!" );

        cond.signal();
        
        
        
        try
        {
            inclement();
        }
        finally
        {
            lock.unlock();
        }
    }


    public void finished()
    {
        System.out.println( "Count is: " + count );
    }

}
