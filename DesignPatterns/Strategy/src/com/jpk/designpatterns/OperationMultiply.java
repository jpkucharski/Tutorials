package com.jpk.designpatterns;

public class OperationMultiply implements Strategy{
    
    public int doOperation(int int1, int int2) {
       return int1 * int2;
    }
 }