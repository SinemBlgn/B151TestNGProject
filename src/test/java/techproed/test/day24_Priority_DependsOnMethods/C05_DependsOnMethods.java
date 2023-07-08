package techproed.test.day24_Priority_DependsOnMethods;

import org.testng.annotations.Test;

public class C05_DependsOnMethods {
    @Test
    public void test01() {
        System.out.println("Erol");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        System.out.println("Evren");
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        System.out.println("Esen");
    }

    @Test(dependsOnMethods = "test03")
    public void test04() {
        System.out.println("Mehmet");
    }
}
