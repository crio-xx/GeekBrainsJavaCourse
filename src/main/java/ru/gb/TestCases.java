package ru.gb;

import ru.gb.annotations.AfterSuite;
import ru.gb.annotations.BeforeSuite;
import ru.gb.annotations.Test;

public class TestCases {

    @BeforeSuite
    public void before() {
        System.out.println("Start tests...");
    }

    public void test1(){
        System.out.println("First test...");
    }

    @Test(priority = 3)
    public void test2(){
        System.out.println("Second test...");
    }

    @Test
    public void test3(){
        System.out.println("Third test...");
    }

    @Test(priority = 1)
    public void test4(){
        System.out.println("Fourth test...");
    }

    @Test(priority = 7)
    public void test5(){
        System.out.println("Fifth test...");
    }

    @AfterSuite
    public void after() {
        System.out.println("End tests...");
    }
}
