

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

/**
 * Created by diz on 04.06.2016.
 */
public class CalcMain {

    @Test(dataProvider="ExcelSmixel")

    @DataProvider

    public Object[][] Authentication() throws Exception{

        Object[][] testObjArray = ExcelOut.ExcelUtils.getTableArray("C:\\Users\\diz\\IdeaProjects\\Data.xls","Sheet1");

        return (testObjArray);

    }


}
