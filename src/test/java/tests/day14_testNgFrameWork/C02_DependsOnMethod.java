package tests.day14_testNgFrameWork;

import org.testng.annotations.Test;

public class C02_DependsOnMethod {

    @Test(groups = "reg1")
    public void test01() {

        System.out.println("First test is executed");  // https://www.amazon.com
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {

        System.out.println("Second test is executed"); // search for nutella
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {

        System.out.println("Third test is executed"); // testing the result
    }
}
