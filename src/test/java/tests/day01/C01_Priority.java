package tests.day01;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test(priority = 7)
    public void test01() {

        System.out.println("First test is executed");
    }

    @Test(priority = 10)
    public void test02() {

        System.out.println("Second test is executed");
    }

    @Test(priority = -99)
    public void test03() {

        System.out.println("Third test is executed");
    }
}
