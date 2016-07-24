package com.jpk.tests.JUnitsTest1;

import java.util.ArrayList;


public class TestedClass
{

    private int namber;
    private String name;
    private ArrayList<Integer> list1;
    private boolean variable1 = false;
    
    
    
    
    public TestedClass(String name, int namber, ArrayList<Integer> list1, boolean variable1){
        this.name=name;
        this.namber = namber;
        this.list1 = list1;
        this.variable1 = variable1;
    }

    public ArrayList<Integer> createArrayList()
    {
        return new ArrayList<Integer>();
    }


    public ArrayList<Integer> addValueToArrayList( ArrayList<Integer> list, int valueToAdd )
    {
        list.add( valueToAdd );
        return list;
    }


    public ArrayList<Integer> aaddingLoop( ArrayList<Integer> list1, int size)
    {
        for( int i = 0; i < size; i++ )
        {
            addValueToArrayList( list1, i );
        }
        return list1;
    }


    public boolean isListEmpty( ArrayList<?> list )
    {
        boolean statement = false;

        if( list.size() != 0 )
        {
            statement = true;
        }
        return statement;

    }


    public int getNamber()
    {
        return namber;
    }


    public void setNamber( int namber )
    {
        this.namber = namber;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public ArrayList<Integer> getList1()
    {
        return list1;
    }


    public void setList1( ArrayList<Integer> list1 )
    {
        this.list1 = list1;
    }


    public boolean isVariable1()
    {
        return variable1;
    }


    public void setVariable1( boolean variable1 )
    {
        this.variable1 = variable1;
    }


    public int addition( int x, int y )
    {
        int suma = x + y;
        return suma;
    }

}
