package com.module2.point1;

public class Main {
    public static void main(String[] args) {
        // Creating some Planet objects
        Planet earth = new Planet("Earth", 5.972e24, 1, PlanetType.EARTHY);
        Planet mars = new Planet("Mars", 6.39e23, 1.88, PlanetType.EARTHY);
        Planet jupiter = new Planet("Jupiter", 1.898e27, 11.86, PlanetType.GASSY);

        // Testing equals method
        System.out.println("Are Earth and Mars equal? " + earth.equals(mars));
        System.out.println("Are Earth and Earth equal? " + earth.equals(earth));

        // Testing hashcode method
        System.out.println("Earth hashcode: " + earth.hashCode());
        System.out.println("Mars hashcode: " + mars.hashCode());
        System.out.println("Jupiter hashcode: " + jupiter.hashCode());

        // Testing toString method
        System.out.println("Earth string: " + earth);
        System.out.println("Mars string: " + mars);
        System.out.println("Jupiter string: " + jupiter);
    }
}
