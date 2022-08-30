package ru.qaway.testng.lifecycle;

import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LifeCycleThird extends LifeCycleTestBase {

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeGroups(groups = {"first-group", "second-group"})
    public void beforeGroups(ITestContext testContext) {
        System.out.println("\tBeforeGroup");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.printf("\t\tBeforeMethod : %s.%s\n", getClass().getSimpleName(), method.getName());
    }

    @Test(groups = {"first-group"})
    public void lifeCycleTest1(Method method) {
        printTestInfo(method);
    }

    @Test(groups = {"first-group", "second-group"})
    public void lifeCycleTest2(Method method) {
        printTestInfo(method);
    }

    @Test(groups = {"second-group"})
    public void lifeCycleTest3(Method method) {
        printTestInfo(method);
    }

    @AfterMethod
    public void afterMethod(Method method) {
        System.out.printf("\t\tAfterMethod : %s.%s\n", getClass().getSimpleName(), method.getName());
    }

    @AfterGroups(groups = {"first-group", "second-group"})
    public void afterGroups() {
        System.out.println("\tAfterGroup");
    }

    @AfterClass
    public void afterClass(XmlTest xmlTest) {
        System.out.println("AfterClass");
    }

    private void printTestInfo(Method method) {
        Arrays.stream(method.getAnnotation(Test.class).groups()).
                map(s -> "\t\t\tGroup name is: " + s).
                forEach(System.out::println);
        System.out.printf("\t\t\tTest : %s\n", method.getName());
    }
}
