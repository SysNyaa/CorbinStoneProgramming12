package com.name.module1.seven;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize ArrayList shapeList
        List<TwoDShape> shapesList = new ArrayList<>();

        // Make Circle instance, add it to the list
        Circle c0 = new Circle(2, Colour.RED);
        shapesList.add(c0);

        // Make Triangle instance, add it to the list
        Triangle t0 = new Triangle(5, 3, 6, Colour.BLUE);
        shapesList.add(t0);

        t0.rotate90();

        // Looping through list and testing getArea and toString methods
        for (TwoDShape shape : shapesList) {
            // Testing toString() (using shape not shape.toString() because it is redundant)
            System.out.println(shape);
            // Testing getArea()
            System.out.println("Area: " + shape.getArea() + "\n");
        }
    }
}
