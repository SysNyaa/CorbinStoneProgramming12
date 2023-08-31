package com.name.module1.one;

class TwoDShape {
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

    // return the area of the shape
    public double getArea() {
        return 0.0;
    }

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

    // IDE generated toString() returns width and height in a readable format when called
    @Override
    public String toString() {
        return "Width: " + width + ", Height: " + height;
    }
}
