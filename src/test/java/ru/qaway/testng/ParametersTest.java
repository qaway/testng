package ru.qaway.testng;

import org.testng.annotations.*;

public class ParametersTest {

    @BeforeClass
    @Parameters({"browser", "users"})
    public void beforeClass(@Optional("ie") String browser, @Optional("10") Integer users) {
        System.out.printf("Next tests will run with params " +
                "(browser=%s, users=%s)\n\n", browser, users);
    }

    @Test
    @Parameters("browser")
    public void testLogin(@Optional("ie") String browser) {
        System.out.printf("Check login with browser=%s\n", browser);
    }

    @Test
    @Parameters({"browser", "users"})
    public void testConcurrentLogin(@Optional("ie") String browser, @Optional("10") Integer users) {
        System.out.printf("Check concurrent login with params" +
                "(browser=%s, users=%s)\n", browser, users);
    }

    @AfterClass
    @Parameters({"browser", "users"})
    public void afterClass(@Optional("ie") String browser, @Optional("10") Integer users) {
        System.out.printf("\nPrevious tests have run with params" +
                "(browser=%s, users=%s)\n\n", browser, users);
    }
}
