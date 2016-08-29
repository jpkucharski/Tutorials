package com.jpk.designepatterns;

public class ColorFactory {
    
    public Color getColor(String colorType){
       if(colorType == null){
          return null;
       }     
       if(colorType.equalsIgnoreCase("WHITE")){
          return new White();
          
       } else if(colorType.equalsIgnoreCase("BLACK")){
          return new Black();
          
       } else if(colorType.equalsIgnoreCase("YELLOW")){
          return new Yellow();
       }
       return null;
    }
 }