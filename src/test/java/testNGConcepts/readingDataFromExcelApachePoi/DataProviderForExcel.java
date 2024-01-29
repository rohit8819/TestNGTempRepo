package testNGConcepts.readingDataFromExcelApachePoi;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviderForExcel {

    @DataProvider(name ="getTestdata")
    public Object[][] dataSupplier() throws IOException {

        String excelFilePath =  System.getProperty("user.dir")+"\\TestFile.xlsx";

        File file = new File(excelFilePath);

        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("one");

        int rowsCount = sheet.getPhysicalNumberOfRows();
        int colsCount = sheet.getRow(0).getLastCellNum();

        System.out.println(rowsCount + " " + colsCount);
        Object[][] data = new Object[rowsCount-1][colsCount];

        for(int r=0; r<rowsCount-1;r++){

            XSSFRow row = sheet.getRow(r+1);

            for(int c=0; c<colsCount;c++){

                XSSFCell cell = row.getCell(c);

                CellType cellType = cell.getCellType();

                switch(cellType) {
                    case STRING:
                        data[r][c] = cell.getStringCellValue();
                        break;
                    case BOOLEAN:
                        data[r][c] = cell.getBooleanCellValue();
                        break;
                    case NUMERIC:
                        data[r][c] = (int)cell.getNumericCellValue();
                        break;
                }
//                System.out.print(data[r][c]);
            }
        }
        return data;
    }



}
