

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
        Assert.assertEquals(actualResult, expectedResult, "Addition method failed");
        Thread.sleep(1000);
    }
}
