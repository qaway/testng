package ru.qaway.testng.lifecycle;

import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LifeCycleFirst extends LifeCycleTestBase{

    @Test
    public void LifeCycleTest1(Method method) {
        System.out.printf("\t\t\t\tTest : %s.%s\n", getClass().getSimpleName(), method.getName());
    }

    @Test
    public void LifeCycleTest2(Method method) {
        System.out.printf("\t\t\t\tTest : %s.%s\n", getClass().getSimpleName(), method.getName());
    }
}
