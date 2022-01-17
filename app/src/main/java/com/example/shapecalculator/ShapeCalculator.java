package com.example.shapecalculator;
import java.lang.Math;

public class ShapeCalculator {
    // Rectangle
    public double RectangleArea(double width, double height){
        return width*height;
    }

    public double RectanglePerimeter(double width, double height){
        return 2*(width+height);
    }

    // Triangle
    public double TriangleArea(double a, double b){
        return (a*b)/2;
    }

    public double TrianglePerimeter(double a, double b){
        return a+b+Math.sqrt((a*a)+(b*b));
    }

    // Rhombus
    public double RhombusArea(double w, double h){
        return (w*h)/2;
    }

    public double RhombusPerimeter(double w, double h){
        return 2*(Math.sqrt((h*h)+(w*w)));
    }

    // Circle

    public double CircleArea(double r){
        return Math.PI*r*r;
    }

    public double CirclePerimeter(double r){
        return 2*Math.PI*r;
    }
}
