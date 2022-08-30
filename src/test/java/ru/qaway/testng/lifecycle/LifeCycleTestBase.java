package ru.qaway.testng.lifecycle;

import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class LifeCycleTestBase {

    @BeforeSuite
    public void beforeSuite() {
        System.out.printf("BeforeSuite: %s\n", getClass().getSimpleName());
    }

    @BeforeTest
    public void beforeTest(XmlTest xmlTest) {
        System.out.printf("\tBeforeTest : %s <%s>\n", getClass().getSimpleName(), xmlTest.getName());
    }

    @BeforeClass
    public void beforeClass(XmlTest xmlTest) {
        System.out.printf("\t\tBeforeClass : %s <%s>\n", getClass().getSimpleName(), xmlTest.getName());
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.printf("\t\t\tBeforeMethod : %s.%s\n", getClass().getSimpleName(), method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method) {
        System.out.printf("\t\t\tAfterMethod : %s.%s\n", getClass().getSimpleName(), method.getName());
    }

    @AfterClass
    public void afterClass(XmlTest xmlTest) {
        System.out.printf("\t\tAfterClass : %s <%s>\n", getClass().getSimpleName(), xmlTest.getName());
    }

    @AfterTest
    public void afterTest(XmlTest xmlTest) {
        System.out.printf("\tAfterTest : %s <%s>\n", getClass().getSimpleName(), xmlTest.getName());
    }

    @AfterSuite
    public void afterSuite() {
        System.out.printf("AfterSuite: %s\n", getClass().getSimpleName());
    }
}
