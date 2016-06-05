package com.jpk.threads;

public class Main
{
    public static void main( String[] args )
    {
        for( int i = 0; i <= 3; i++ )
        {
            ThreadX t1 = new ThreadX( Integer.toString( i ) );
            t1.start();
        }
        new ThreadX( "ThreadID" ).start();
    }
}
