package com.jpk.designepatterns;

public class Start
{
    public static void main(String[] args) {
        ColorFactory colorFactory = new ColorFactory();
        Color color1 = colorFactory.getColor("YELLOW");
        color1.draw();
        Color color2 = colorFactory.getColor("BLACK");
        color2.draw();
        Color color3 = colorFactory.getColor("WHITE");
        color3.draw();

     }
}
