package com.jpk.designpatterns;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
       this.strategy = strategy;
    }

    public int executeStrategy(int int1, int int2){
       return strategy.doOperation(int1, int2);
    }
 }
