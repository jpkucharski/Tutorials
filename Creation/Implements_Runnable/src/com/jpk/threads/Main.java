package com.jpk.threads;

public class Main
{
    public static void main( String[] args )
    {
        for( int i = 0; i <= 3; i++ )
        {
            ThreadX objectOfThreadXClass = new ThreadX( Integer.toString( i ) );
            Thread t1 = new Thread( objectOfThreadXClass );
            t1.start();
        }
        new Thread( new ThreadX( "TthreadID" ) ).start();
    }
}
