

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

/**
 * Created by diz on 04.06.2016.
 */
public class CalcMain {
    @DataProvider(name = "Addition")
    //@DataProvider(name = "Addition", parallel = true)
    public static Object[][] Authentication() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 0);
        return testObjArray;
    }

    @Test(dataProvider = "Addition",groups = "smoke test" )
    //@Test(dataProvider = "Addition",dependsOnMethods={"test1"},dependsOnGroups ={"smoke test"} )
    public void test(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) + Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.02, "Addition method failed");
        Thread.sleep(1000);
    }
    @DataProvider(name = "Sub")
    public static Object[][] Authentication1() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 1);
        return testObjArray;
    }

    @Test(dataProvider = "Sub",groups = "smoke test")
   // @Test(dataProvider = "Sub",dependsOnMethods={"test2"})
    public void test1(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) - Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.2, "Sub method failed");
        Thread.sleep(1000);
    }

    @DataProvider(name = "Mult")
    public static Object[][] Authentication2() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 2);
        return testObjArray;
    }

    @Test(dataProvider = "Mult",groups = "smoke")
    public void test2(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) * Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.2, "Mult method failed");
        Thread.sleep(1000);
    }

    @DataProvider(name = "Div")
    public static Object[][] Authentication3() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 3);
        return testObjArray;
    }

    @Test(dataProvider = "Div",groups = "test")
    //@Test(dataProvider = "Div",groups = "smoke test")
    public void test3(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) / Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.2, "Mult method failed");
        Thread.sleep(1000);
    }


}
