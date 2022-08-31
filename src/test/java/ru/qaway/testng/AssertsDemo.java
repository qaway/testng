package ru.qaway.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertsDemo {

    @Test(description = "assertEquals demo")
    public void testAssertEquals() {
        String sides = "4 5 6";
        String expected = Triangle.TRIANGLE;

        Assert.assertEquals(Triangle.isTriangle(sides), expected,
                String.format("'%s' are sides of %s", sides, expected));
    }

    @Test(description = "assertNotEquals demo")
    public void testAssertNotEquals() {
        String sides = "4 4 6";
        String expected = Triangle.TRIANGLE;

        Assert.assertNotEquals(Triangle.isTriangle(sides), expected,
                String.format("'%s' aren't sides of %s", sides, expected));
    }

    @Test(description = "assertTrue demo")
    public void testAssertTrue() {
        String sides = "4 4 4";

        Assert.assertTrue(Triangle.isEquilateralTriangle(sides),
                String.format("'%s' are sides of equilateral triangle", sides));
    }

    @Test(description = "assertFalse demo")
    public void testAssertFalse() {
        String sides = "4 4 6";

        Assert.assertFalse(Triangle.isEquilateralTriangle(sides),
                String.format("'%s' aren't sides of equilateral triangle", sides));
    }

    @Test(description = "assertNull demo")
    public void testAssertNull() {

        String sides = "a a a";
        String actual = null;

        try {
            actual = Triangle.isTriangle(sides);
        } catch (IllegalArgumentException e) {

        }

        Assert.assertNull(actual,
                String.format("Triangle with sides '%s' wasn't initialized, ", sides));
    }

    @Test(description = "assertNotNull demo")
    public void testAssertNotNull() {

        String sides = "4 4 4";
        String actual = null;

        try {
            actual = Triangle.isTriangle(sides);
        } catch (IllegalArgumentException e) {

        }

        Assert.assertNotNull(actual,
                String.format("Triangle with sides '%s' was initialized, ", sides));
    }

    @Test(description = "assertSame demo")
    public void testAssertSame() {
        String actual = new String("123");
        String expected = actual;

        Assert.assertSame(actual, expected, "Actual and expected is the same object");
    }

    @Test(description = "assertNotSame demo")
    public void testAssertNotSame() {
        String actual = new String("123");
        String expected = new String("123");

        Assert.assertNotSame(actual, expected, "Actual and expected is not the same object");
    }
}
