package com.jpk.main;

import java.util.LinkedList;

import com.jpk.exceptions.InvalidMessageException;


public class Start
{

    static String str1 = "D MZ89 5678 50 20150305T10:04:56.012Z";
    static String str2 = "A MZ89 5678 50 20150305T10:04:56.012Z";
    static String str3 = "B MZ89 5678 50 20150305T10:04:56.012Z";
    static String str4 = "A MZ89 5678 50 20150305T10:04:56.012Z";


    public static void main( String[] args )
    {

        Main m = new Main();

        LinkedList<String> messagesList = new LinkedList<String>();
        messagesList.add( str1 );
        messagesList.add( str2 );
        messagesList.add( str3 );
        messagesList.add( str4 );

        for( String s : messagesList )
        {
            try
            {
                m.receive( s );
            }
            catch( InvalidMessageException e )
            {
                e.printStackTrace();
            }
        }
    }
}
