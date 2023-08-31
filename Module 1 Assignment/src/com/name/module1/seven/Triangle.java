package com.name.module1.seven;

class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;
    private double rotation; // Rotation angle field

    // Constructs a Triangle object using the superclass constructor to set width and height
    public Triangle(double width, double height) {
        super(width, height);
    }

    // Constructs a Triangle object with three specified sides and sets the height of the triangle using the heronsHeight() method
    public Triangle(double side1, double side2, double side3, Colour colour) {
        super(colour);
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
    // Made herons height package-private so TriangleTest can see it
    double heronsHeight() {
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

    // Returns a description of a triangle when called
    @Override
    public String toString() {
        return "Shape: Triangle\nColour: " + getColour() + "\nRotation: " + rotation + "\nDescription: Has three distinct sides";
    }

    // Implementations from the Rotate interface
    @Override
    public void rotate90() {
        System.out.println("Triangle rotated 90 degrees.");
        rotation += 90;
    }

    @Override
    public void rotate180() {
        System.out.println("Triangle rotated 180 degrees.");
        rotation += 180;
    }

    @Override
    public void rotate(double degree) {
        System.out.println("Triangle rotated by " + degree + " degrees.");
        rotation += 90;
    }
}
