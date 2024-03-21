package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _02_GetAllDataFromOneRow {
    
    public static void main(String[] args) throws IOException {
        
        String path = "C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\ApacheExcel2.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        
        Workbook workbook = WorkbookFactory.create(fileInputStream); //open the file in the memory
        Sheet sheet = workbook.getSheetAt(0);
        
        Row row = sheet.getRow(1); // Row2 of the sheet
        int numberOfCells = row.getPhysicalNumberOfCells(); //counts all not Null cells. The first null cell will be included if there is a not-Null value after it, but that not-Null cell will not be counted.
        //if all rows contain null cells then exception will be thrown
        System.out.println(numberOfCells);
        for (int i = 0; i < numberOfCells; i++) {
            Cell cell = row.getCell(i);// Cell of the row
            System.out.print(cell + " ");
        }
    }
}