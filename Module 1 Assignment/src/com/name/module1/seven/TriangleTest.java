package com.name.module1.seven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testGetArea() {
        // Create triangle with 3 sides of length 6, 12 and 13
        Triangle triangle = new Triangle(6, 12, 13, Colour.RED); //

        // Manually calculate the area using herons's formula for comparison.
        double expectedArea = 35.895;

        // Compare the calculated area with the expected area, allowing a small delta for floating-point precision
        assertEquals(expectedArea, triangle.getArea(), 0.001);
    }

    @Test
    void testHeronsHeight() {
        // Create triangle with 3 sides of length 6, 12 and 13
        Triangle triangle = new Triangle(6, 12, 13, Colour.BLUE);

        // Manually calculate the height using heron's formula for comparison.
        double expectedHeight = 11.965;

        // Compare the calculated area with the expected area, allowing a small delta for floating-point precision
        assertEquals(expectedHeight, triangle.heronsHeight(), 0.001);
    }
}
