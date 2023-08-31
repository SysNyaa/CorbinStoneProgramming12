package com.name.module1.four;

abstract class TwoDShape {
    private double width;
    private double height;
    private Colour colour;

    // Default constructor
    public TwoDShape(Colour colour) {
        this.width = 0.0;
        this.height = 0.0;
        this.colour = colour;
    }

    // Constructor with the shapes width and height parameters as well as one for the shapes colour
    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public abstract double getArea();

    // Setters and getters for width, height and colour
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

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    // Returns a description of the shape when called
    @Override
    public String toString() {
        return "Abstract two dimensional template shape";
    }
}
