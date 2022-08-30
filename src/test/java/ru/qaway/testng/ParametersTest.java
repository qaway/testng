package ru.qaway.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

    @BeforeClass
    @Parameters({"browser", "users"})
    public void beforeClass(String browser, Integer users) {
        System.out.printf("Next tests will run with params " +
                "(browser=%s, users=%s)\n\n", browser, users);
    }

    @Test
    @Parameters("browser")
    public void testLogin(String browser) {
        System.out.printf("Check login with browser=%s\n", browser);
    }

    @Test
    @Parameters({"browser", "users"})
    public void testConcurrentLogin(String browser, Integer users) {
        System.out.printf("Check concurrent login with params" +
                "(browser=%s, users=%s)\n", browser, users);
    }

    @AfterClass
    @Parameters({"browser", "users"})
    public void afterClass(String browser, Integer users) {
        System.out.printf("\nPrevious tests have run with params" +
                "(browser=%s, users=%s)\n\n", browser, users);
    }
}
