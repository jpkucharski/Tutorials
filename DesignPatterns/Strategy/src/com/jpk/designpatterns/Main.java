package com.jpk.designpatterns;

public class Main
{

    private static final int VALUE_X = 1;
    private static final int VALUE_Y = 2;


    public static void main( String[] args ) 
    {
        Context context = new Context( null );

        context = new Context( new OperationAdd() );
        System.out.println( "1 + 2 = " + context.executeStrategy( VALUE_X, VALUE_Y ) );
        
        context = new Context( new OperationSubstract() );
        System.out.println( "1 - 2 = " + context.executeStrategy( VALUE_X, VALUE_Y ) );

        context = new Context( new OperationMultiply() );
        System.out.println( "1 * 2 = " + context.executeStrategy( VALUE_X, VALUE_Y ) );
    }
}
