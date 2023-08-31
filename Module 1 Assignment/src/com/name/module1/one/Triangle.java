package com.name.module1.one;

class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3;

    // Constructs a Triangle object using the superclass constructor to set width and height
    public Triangle(double width, double height) {
        super(width, height);
    }

    // Constructs a Triangle object with three specified sides and sets the height of the triangle using the heronsHeight() method
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setHeight(heronsHeight());
    }

    // Calculate and return area of the triangle using herons formula
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Calculate the height of the triangle using herons formula from the getArea() method
    private double heronsHeight() {
        return (2 * getArea()) / side1;
    }

    // Getters and setters for sides1, side2 and side 3
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // IDE generated toString() returns side1, side2 and side3 in a readable format when called
    @Override
    public String toString() {
        return "Side 1: " + side1 + ", Side 2: " + side2 + ", Side 3: " + side3;
    }
}
