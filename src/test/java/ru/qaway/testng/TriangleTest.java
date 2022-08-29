package ru.qaway.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {

    @Test(description = "Check input is triangle", groups = "triangle")
    public void testTriangle() {
        String result = Triangle.isTriangle("4 5 6");
        Assert.assertEquals(result, Triangle.TRIANGLE, "Input is triangle");
    }

    @Test(description = "Check input is equilateral triangle",
            groups = "triangle.spec")
    public void testEquilateralTriangle() {
        String result = Triangle.isTriangle("4 5 6");
        Assert.assertEquals(result, Triangle.EQUILATERAL, "Input is equilateral triangle");
    }

    @Test(description = "Check input is isosceles triangle",
            groups = "triangle.spec")
    public void testIsoscelesTriangle() {
        String result = Triangle.isTriangle("4 6 6");
        Assert.assertEquals(result, Triangle.ISOSCELES, "Input is isosceles triangle");
    }

    @Test(description = "Check input is not triangle",
            dependsOnGroups = "triangle.*", alwaysRun = true)
    public void testNotTriangle() {
        String result = Triangle.isTriangle("4 5 20");
        Assert.assertEquals(result, Triangle.NOT_TRIANGLE, "Input is not triangle");
    }
}
