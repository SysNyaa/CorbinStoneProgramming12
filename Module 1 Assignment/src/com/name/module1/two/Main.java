package com.name.module1.two;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize ArrayList shapeList
        List<TwoDShape> shapesList = new ArrayList<>();

        // Make Circle instance, add it to the list
        Circle c0 = new Circle(2);
        shapesList.add(c0);

        // Make Triangle instance, add it to the list
        Triangle t0 = new Triangle(5, 3, 6);
        shapesList.add(t0);

        // Looping through list and testing getArea and toString methods
        for (TwoDShape shape : shapesList) {
            // Testing getArea()
            System.out.println("GetArea: " + shape.getArea());
            // Testing toString() (not using shape.toString() as it would be redundant)
            System.out.println("ToString: " + shape);
        }
    }
}
