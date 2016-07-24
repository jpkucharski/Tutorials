package com.jpk.tests.JUnitsTest1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestedClassTests
{

    private TestedClass testedClass;
    private final static String NAME = "NAME";
    private final static int LIST_SIZE = 10;
    private final static int NAMBER1 = 1;
    private final static int VARIABLE_X = 2;
    private final static int VARIABLE_Y = 3;
    private final static boolean VARIABLE = false;
    private static ArrayList<Integer> LIST1;


    @Before
    public void setUpMyTest()
    {

        testedClass = new TestedClass( NAME, NAMBER1, LIST1, VARIABLE );

    }


    @Test
    public void testOfConstructor()
    {

        assertEquals( NAME, testedClass.getName() );
        assertEquals( NAMBER1, testedClass.getNamber() );
        assertEquals( LIST1, testedClass.getList1() );
        assertEquals( VARIABLE, testedClass.isVariable1() );
    }


    @Test
    public void testisListEmptyMethod_ListSizeIs_1_answerTrue()
    {

        LIST1 = new ArrayList<Integer>();
        LIST1.add( 1 );
        
        boolean condition = testedClass.isListEmpty( LIST1 );

        assertTrue( condition );
    }


    @Test
    public void testisListEmptyMethod_ListSizeIs_0_answerFalse()
    {

        LIST1 = new ArrayList<Integer>();

        boolean condition = testedClass.isListEmpty( LIST1 );

        assertFalse( condition );

    }


    @Test
    public void testOfCreateArrayListMethod_expectedNewArrayList()
    {

        ArrayList<Integer> expected = new ArrayList<Integer>();
        
        Object actual = testedClass.createArrayList();

        assertEquals( expected, actual );
    }


    @Test
    public void testOfAdditionMethod_RetyrningSumOfVariableXandVariableY()
    {

        int expected = VARIABLE_X + VARIABLE_Y;
        int actual = testedClass.addition( VARIABLE_X, VARIABLE_Y );

        assertEquals( expected, actual );
    }


    @Test
    public void nameGeterTestReturningNAME()
    {

        testedClass.setName( NAME );

        String expected = NAME;
        String actual = testedClass.getName();

        assertEquals( expected, actual );
    }

    
   @Test 
   public void testOfaddValueToArrayListMethod_expectedArrayListSize_1(){
       
       testedClass.setList1( new ArrayList<Integer>() );
       testedClass.addValueToArrayList( testedClass.getList1(), NAMBER1 );
       
       int expected =1;
       int actual = testedClass.getList1().size();
       
       assertEquals( expected, actual );
   }
   @Test 
   public void testSetGetVariable1_expectedTrue(){
   
       testedClass.setVariable1( true );
       
       boolean condition = testedClass.isVariable1();
       
       assertTrue( condition );
       
       
   }
   
   @Test 
   public void testSetGetNamber_expectedNAMBER1value(){
   
       testedClass.setNamber( NAMBER1 );
       
       int expected = NAMBER1;
       int actual = testedClass.getNamber();
       
       assertEquals( expected, actual );
      
   }
   @Test
   public void testOfaaddingLoopMethod_expectedSizeOfList_LIST_SIZEvalue(){
       
       ArrayList<Integer> list = new ArrayList<Integer>();
//       testedClass.aaddingLoop( list, LIST_SIZE );
       
       int expected = LIST_SIZE;
       int actual = testedClass.aaddingLoop( list, LIST_SIZE ).size();
       
       assertEquals( expected, actual );
      
       
   }
   
   
}
