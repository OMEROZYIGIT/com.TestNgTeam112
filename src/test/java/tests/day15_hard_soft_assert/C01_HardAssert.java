package tests.day15_hard_soft_assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_HardAssert {

    @Test (groups = {"reg2","smoke1","reg4"})
    public void test01() {

        Assert.assertTrue(6>3);
        System.out.println("after 1. assertion");

        Assert.assertTrue(6>1);
        System.out.println("after 2. assertion");

        Assert.assertEquals(6,6);
        System.out.println("After 3. assertion");



    }
}
