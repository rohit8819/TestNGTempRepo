package testNGConcepts.readingDataFromExcelApachePoi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadingDataIterator {

    @Test
    public void readingDataByIterator() throws IOException {
        String excelFilePath = System.getProperty("user.dir") + "\\TestFile.xlsx";

        File excelFile = new File(excelFilePath);

        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("one");

        Iterator<Row> rows = sheet.iterator();

        while(rows.hasNext()){

            Row row = rows.next();
            Iterator<Cell> cells = row.iterator();

            while(cells.hasNext()){
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();

                switch(cellType){
                    case STRING :
                        System.out.print(cell.getStringCellValue());
                    break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                    break;
                    case NUMERIC:
                        System.out.print((int)cell.getNumericCellValue());
                    break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

    }
}