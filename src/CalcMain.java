

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

/**
 * Created by diz on 04.06.2016.
 */
public class CalcMain {

    @DataProvider(name = "Addition", parallel = true)
    public static Object[][] Authentication() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 0);
        return testObjArray;
    }

    @Test(dataProvider = "Addition")
    public void test(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) + Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.02, "Addition method failed");
        Thread.sleep(1000);
    }
    @DataProvider(name = "Sub", parallel = true)
    public static Object[][] Authentication1() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 1);
        return testObjArray;
    }

    @Test(dataProvider = "Sub")
    public void test1(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) - Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.2, "Sub method failed");
        Thread.sleep(1000);
    }

    @DataProvider(name = "Mult", parallel = true)
    public static Object[][] Authentication2() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 2);
        return testObjArray;
    }

    @Test(dataProvider = "Mult")
    public void test2(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) * Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.2, "Mult method failed");
        Thread.sleep(1000);
    }

    @DataProvider(name = "Div", parallel = true)
    public static Object[][] Authentication3() throws Exception {
        Object[][] testObjArray = ExcelOut.getTableArray("..\\CalcA\\src\\Data.xls", 3);
        return testObjArray;
    }

    @Test(dataProvider = "Div")
    public void test3(String a, String b, String c) throws InterruptedException {
        double actualResult = Double.parseDouble(a) / Double.parseDouble(b);
        double expectedResult = Double.parseDouble(c);
        Assert.assertEquals(actualResult, expectedResult,0.2, "Mult method failed");
        Thread.sleep(1000);
    }


}
