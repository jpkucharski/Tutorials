package com.jpk.designpatterns;

public class ColorMaker {
    private Color blue;
    private Color yellow;
    private Color grean;

    public ColorMaker() {
       blue = new Blue();
       yellow = new Yellow();
       grean = new Grean();
    }

    public void drawBlue(){
       blue.draw();
    }
    public void drawYellow(){
       yellow.draw();
    }
    public void drawGrean(){
       grean.draw();
    }
 }