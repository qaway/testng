package ru.qaway.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {

    @Test(description = "Check input is triangle", dataProvider = "triangle")
    public void testTriangle(String input, String expected) {
        String result = Triangle.isTriangle(input);
        Assert.assertEquals(result, expected, "Input is " + expected);
    }

    @DataProvider
    public Object[][] triangle() {
        return new Object[][] {
                { "4 4 4", Triangle.EQUILATERAL},
                { "2147483647 2147483647 2147483647", Triangle.EQUILATERAL},
                { "1 1 1", Triangle.EQUILATERAL},

                { "5 4 4", Triangle.ISOSCELES},
                { "4 5 4", Triangle.ISOSCELES},
                { "4 4 5", Triangle.ISOSCELES},
                { "5 2147483647 2147483647", Triangle.ISOSCELES},
                { "2147483647 5 2147483647", Triangle.ISOSCELES},
                { "2147483647 2147483647 5", Triangle.ISOSCELES},

                { "4 5 20", Triangle.NOT_TRIANGLE},
                { "2 1 1", Triangle.NOT_TRIANGLE},
                { "1 2 1", Triangle.NOT_TRIANGLE},
                { "1 1 2", Triangle.NOT_TRIANGLE},
        };
    }
}
