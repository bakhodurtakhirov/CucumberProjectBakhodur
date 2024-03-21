package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_GetAllDataFromASheet {
    
    public static void main(String[] args) throws IOException {
        
        String path = "C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\ApacheExcel2.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        
        Workbook workbook = WorkbookFactory.create(fileInputStream); //open the file in the memory
        Sheet sheet = workbook.getSheetAt(0);
        
        
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { //get all values from sheet not separated by Null cell.
            Row row = sheet.getRow(i); //For empty rows in between, we'll get "NullPointerException" and should handle with try catch.
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}