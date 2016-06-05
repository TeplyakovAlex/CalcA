import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * Created by diz on 04.06.2016.
 */
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelOut {

    private static HSSFSheet ExcelWSheet;
    private static HSSFWorkbook ExcelWBook;
    private static HSSFCell Cell;

    public static Object[][] getTableArray(String FilePath, int SheetIndex) throws Exception {

        String[][] tabArray = null;

        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new HSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheetAt(SheetIndex);

            int startRow = 0;
            int totalRows = ExcelWSheet.getLastRowNum();
            // you can write a function as well to get Column count
            tabArray = new String[totalRows + 1][1];

            for (int i = startRow; i <= totalRows; i++) {
                tabArray[i] = new String[]{
                        getCellData(i,0),
                        getCellData(i,1),
                        getCellData(i,2)};
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }

        return tabArray;
    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            int dataType = Cell.getCellType();
            if (dataType == 3) {
                return "";
            } else {
                String CellData = "" + Cell.getNumericCellValue();
                return CellData;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}
