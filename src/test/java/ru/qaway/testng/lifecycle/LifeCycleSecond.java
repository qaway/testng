package ru.qaway.testng.lifecycle;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LifeCycleSecond extends LifeCycleTestBase {

    @Test
    public void LifeCycleTest1(Method method) {
        System.out.printf("\t\t\t\tTest : %s.%s\n", getClass().getSimpleName(), method.getName());
    }
}
