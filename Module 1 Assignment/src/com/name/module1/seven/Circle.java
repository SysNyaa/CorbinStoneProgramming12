package com.name.module1.seven;

class Circle extends TwoDShape {
    public static final double PI = Math.PI;
    private double radius;

    // Constructor with a parameter for the circles radius
    public Circle(double radius, Colour colour) {
        super(colour);
        this.radius = radius;
    }

    // Calculate and return the area of the circle
    public double getArea() {
        return PI * radius * radius;
    }

    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Returns a description of a circle when called
    @Override
    public String toString() {
        return "Shape: Circle\nColour: " + getColour() + "\nDescription: The edge is always the same distance from the center at anypoint";
    }
}
