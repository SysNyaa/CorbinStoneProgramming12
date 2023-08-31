package com.name.module1.two;

abstract class TwoDShape {
    private double width;
    private double height;

    // Default constructor
    public TwoDShape() {
        this.width = 0.0;
        this.height = 0.0;
    }

    // Constructor with width and height parameters
    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Abstract method for calculating area
    public abstract double getArea();

    // Setters and getters for width and height
    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    // Returns a description of the shape when called
    @Override
    public String toString() {
        return "Abstract two dimensional template shape";
    }
}
