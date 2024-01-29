package testNGConcepts.readingDataFromExcelApachePoi;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.Switch;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingData {

   @Test
    public void excelDataReading() throws IOException {

       String excelFilePath = System.getProperty("user.dir")+"\\TestFile.xlsx";
       System.out.println(excelFilePath);

       File excelfile = new File(excelFilePath);
       FileInputStream fis = new FileInputStream(excelfile);

       XSSFWorkbook workbook = new XSSFWorkbook(fis);

      XSSFSheet sheet = workbook.getSheet("one");

      int rows = sheet.getPhysicalNumberOfRows();
      System.out.println(rows);

      int cells = sheet.getRow(0).getLastCellNum();
      System.out.println(cells);

      for(int r=0; r<rows; r++){

         XSSFRow row = sheet.getRow(r);

         for(int c=0; c<cells; c++){

            XSSFCell cell = row.getCell(c);

            CellType cellType = cell.getCellType();

            switch(cellType){
               case STRING :
                  System.out.print(cell.getStringCellValue());
                  break;
               case NUMERIC:
                  System.out.print((int)cell.getNumericCellValue());
                  break;
               case BOOLEAN:
                  System.out.print(cell.getBooleanCellValue());
                  break;
            }
            System.out.print(" | ");
         }
         System.out.println(" ");
      }


   }


}
