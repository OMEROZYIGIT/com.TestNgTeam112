package tests.day15_hard_soft_assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_SoftAssertion {

    @Test (groups = {"reg1","reg2"})
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(6>1,"6 is not bigger than other one");
        System.out.println("after 1. assertion");

        softAssert.assertEquals(6,6,"they are not equal");
        System.out.println("after 2. assertion");

        softAssert.assertTrue(6>1,"6 is not bigger tha other one");
        System.out.println("after 3. assertion");

        softAssert.assertAll();
        System.out.println("after assertAll method");
    }
}
