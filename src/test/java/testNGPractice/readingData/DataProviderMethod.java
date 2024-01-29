package testNGPractice.readingData;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderMethod {

    @DataProvider(name = "getData")
    public Object[][] dataSupplierMethod() throws IOException {

        String excelFilePath = System.getProperty("user.dir")+"\\TestFile.xlsx";
        File excelFile = new File(excelFilePath);

        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("two");

       int rowsCount = sheet.getPhysicalNumberOfRows();
       int colsCount = sheet.getRow(1).getLastCellNum();

        System.out.println(rowsCount + " " + colsCount);

        Object[][] data = new Object[rowsCount-1][colsCount];

        for(int r =0; r<rowsCount-1;r++){

            XSSFRow row = sheet.getRow(r+1);

            for(int c =0; c<colsCount;c++){

                XSSFCell cell = row.getCell(c);

                CellType cellType = cell.getCellType();

                switch(cellType){
                    case STRING :
                        data[r][c] = cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                        data[r][c] = cell.getBooleanCellValue();
                        break;
                    case NUMERIC:
                        data[r][c] = (int)cell.getNumericCellValue();
                        break;
                }
            }
        }
        return data;
    }


}
