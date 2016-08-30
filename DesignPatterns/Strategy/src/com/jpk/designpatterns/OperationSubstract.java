package com.jpk.designpatterns;

public class OperationSubstract implements Strategy{
    
    public int doOperation(int int1, int int2) {
       return int1 - int2;
    }
 }