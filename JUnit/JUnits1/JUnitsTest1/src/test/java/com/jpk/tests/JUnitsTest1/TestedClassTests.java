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
    public void constructorMethod_SetPar1AsStringNAMEPar2ASIntegerNAMBER1Par3AsArrayListLIST1Par4AsBooleanVARIABLE_ExpectedInstanceWithSameParameters()
    {
        assertEquals( NAME, testedClass.getName() );
        assertEquals( NAMBER1, testedClass.getNamber() );
        assertEquals( LIST1, testedClass.getList1() );
        assertEquals( VARIABLE, testedClass.isVariable1() );
    }


    @Test
    public void isListEmptyMethod_IntegerAsPar1_ExpectedTrue()
    {

        LIST1 = new ArrayList<Integer>();
        LIST1.add( NAMBER1 );
        
        boolean condition = testedClass.isListEmpty( LIST1 );

        assertTrue( condition );
    }


    @Test
    public void isListEmptyMethod_ListSizeSetAs0_ExpectedFalse()
    {

        LIST1 = new ArrayList<Integer>();

        boolean condition = testedClass.isListEmpty( LIST1 );

        assertFalse( condition );

    }


    @Test
    public void createArrayListMethod_ExpectedArrayListObject()
    {

        ArrayList<Integer> expected = new ArrayList<Integer>();
        
        Object actual = testedClass.createArrayList();

        assertEquals( expected, actual );
    }


    @Test
    public void AdditionMethod_Param1AndParam2SetAsIntegers_ExpectedSumOfPar1AndPar2()
    {

        int expected = VARIABLE_X + VARIABLE_Y;
        int actual = testedClass.addition( VARIABLE_X, VARIABLE_Y );

        assertEquals( expected, actual );
    }


    @Test
    public void nameGeter_StringSetAsPar1_ExpectedPar1()
    {

        testedClass.setName( NAME );

        String expected = NAME;
        String actual = testedClass.getName();

        assertEquals( expected, actual );
    }

    
   @Test 
   public void addValueToArrayListMethod_Par1AsTargetListPar2AsInteger_ExpectedArrayListSize1(){
       
       testedClass.setList1( new ArrayList<Integer>() );
       testedClass.addValueToArrayList( testedClass.getList1(), NAMBER1 );
       
       int expected =1;
       int actual = testedClass.getList1().size();
       
       assertEquals( expected, actual );
   }
   @Test 
   public void setGetVariable1Method_VariableSetAsTrue_expectedTrue(){
   
       testedClass.setVariable1( true );
       
       boolean condition = testedClass.isVariable1();
       
       assertTrue( condition );
       
       
   }
   
   @Test 
   public void setGetNamberMethod_SetAsIntegerPar1_ExpectedIntegerPar1(){
   
       testedClass.setNamber( NAMBER1 );
       
       int expected = NAMBER1;
       int actual = testedClass.getNamber();
       
       assertEquals( expected, actual );
      
   }
   @Test
   public void aaddingLoopMethod_SetPar1AsNewArrayListSetPar2AsLIST_SIZE_ExpectedListSizeAsLIST_SIZE(){
       
       ArrayList<Integer> list = new ArrayList<Integer>(); 
       
       int expected = LIST_SIZE;
       int actual = testedClass.aaddingLoop( list, LIST_SIZE ).size();
       
       assertEquals( expected, actual );
      
       
   }
   
   
}
