package ru.qaway.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class TriangleNegativeTest {

    @Test(description = "Check zero input values", dataProvider = "triangleZero",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "0 - side of the triangle must be positive.")
    public void testTriangleZero(String input) {
        Triangle.isTriangle(input);
    }

    @DataProvider
    public Object[][] triangleZero() {
        return new Object[][] {
                {"0 5 6"},
                {"5 0 6"},
                {"5 6 0"},
                {"0 0 0"},
        };
    }

    @Test(description = "Check negative input values", dataProvider = "triangleNegative",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "-\\d+ - side of the triangle must be positive.")
    public void testTriangleNegative(String input) {
        Triangle.isTriangle(input);
    }

    @DataProvider
    public Object[][] triangleNegative() {
        return new Object[][] {
                {"-1 5 6"},
                {"5 -1 6"},
                {"5 6 -1"},
                {"-1 -1 -1"},

                {"-1 -2147483648 -2147483648"},
                {"-2147483648 -1 -2147483648"},
                {"-2147483648 -2147483648 -1"},
                {"-2147483648 -2147483648 -2147483648"}
        };
    }

    @Test(description = "Check arguments wrong count", dataProvider = "triangleArgsCount",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Wrong arguments count. 3 arguments are expected.")
    public void testTriangleArgsCount(String input) {
        Triangle.isTriangle(input);
    }

    @DataProvider
    public Object[][] triangleArgsCount() {
        return new Object[][] {
                {"4 5"},
                {"4 5 6 7"},
                {""},
        };
    }

    @Test(description = "Check char arguments", dataProvider = "triangleNotDigits",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "a is not a digit.")
    public void testTriangleNotDigits(String input) {
        Triangle.isTriangle(input);
    }

    @DataProvider
    public Object[][] triangleNotDigits() {
        return new Object[][] {
                {"a 5 6"},
                {"4 a 6"},
                {"4 5 a"},

                {"4 a a"},
                {"a 5 a"},
                {"a a 6"},

                {"a a a"},
        };
    }

    @Test(description = "Check input is wrong", dataProvider = "triangleNegativeAll")
    public void testTriangle(String input) {
        Assert.assertThrows(() -> Triangle.isTriangle(input));
        Assert.assertThrows(IllegalArgumentException.class, () -> Triangle.isTriangle(input));
    }

    @DataProvider
    public Object[][] triangleNegativeAll() {
        return Stream.of(triangleZero(), triangleNegative(), triangleArgsCount(), triangleNotDigits())
                .flatMap(Arrays::stream)
                .toArray(Object[][]::new);
    }
}
