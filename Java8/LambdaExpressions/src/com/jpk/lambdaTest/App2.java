package com.jpk.lambdaTest;

interface Executable2
{
    int execute2( int a, int b );
}


interface Executable3
{
    int execute2( String a );

}


class Runner2
{

    public void run2( Executable2 e2 )
    {
        System.out.println( "Executable1 code block..." );
        int value = e2.execute2( 11, 22 );
        System.out.println( "Returned value is:" + value );

    }


    public void run2( Executable3 e3 )
    {
        System.out.println( "Executable1 code block..." );
        int value = e3.execute2( "Hello String" );
        System.out.println( "Returned value is:" + value );

    }

}

/*
 * () -> { System.out.println( "Value returned from Lambda" ); return 8; }
 */
// ()-> 9
// (int a) -> 9 if in method i a parameter
// (a) -> 9 if in method is a parameter


public class App2
{
    public static void main( String arg[] )
    {

        int c = 100; // Lambda is able to see it !!
        int d = 99;
        Runner2 runner2 = new Runner2();
        runner2.run2( new Executable2()
        {
            public int execute2( int a, int b )
            {
                System.out.println( "Hello there from Executable" );
                return a + b + c;
            }
        } );

        System.out.println( "---------------------------------------" );

        runner2.run2( ( String a ) -> 9 );

        runner2.run2( ( a, b ) -> {
            System.out.println( d );
            return a + b + c;
        } );

        Executable2 ex2 = ( a, b ) -> {
            return a + b + c;
        };
        runner2.run2( ex2 );

        Object codeblock = (Executable2)( a, b ) -> {
            return a + b + c;
        };
        
        
    }
}
