package edu.berkeley.ischool.aep;

/**
 * Created by Ignacio on 2/7/14.
 */
public class Rectangle {

    public final double width;
    public final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

   //Factory method
    //static method that is creating a new instance of the class
    public static Rectangle createSquare(int side){
        return new Rectangle(side, side);
    }

    public double Area(){
        return this.width*this.height;
    }



}
