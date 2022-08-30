package ru.qaway.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

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
}
