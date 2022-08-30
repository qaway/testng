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

                { "4 5 4", Triangle.ISOSCELES},

                { "4 5 6", Triangle.TRIANGLE},

                { "4 5 20", Triangle.NOT_TRIANGLE},
        };
    }
}
