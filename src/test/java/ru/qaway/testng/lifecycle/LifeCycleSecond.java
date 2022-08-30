package ru.qaway.testng.lifecycle;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class LifeCycleSecond extends LifeCycleTestBase {

    @BeforeTest
    public void beforeTest(XmlTest xmlTest) {
        System.out.printf("\tBeforeTest (from child) : %s <%s>\n", getClass().getSimpleName(), xmlTest.getName());
    }

    @Test
    public void LifeCycleTest1(Method method) {
        System.out.printf("\t\t\t\tTest : %s.%s\n", getClass().getSimpleName(), method.getName());
    }
}
