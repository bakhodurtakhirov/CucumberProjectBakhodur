package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _05_WriteIntoExistingFIle {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\WriteIntoExistingFile.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path); //creates a connection FROM file to our code
        Workbook workbook = WorkbookFactory.create(fileInputStream); //Open a copy of the file in the temp memory
        Sheet sheet = workbook.getSheet("Sheet1");
        
        Row row = sheet.createRow(sheet.getPhysicalNumberOfRows()); //Create a row
        
        for (int i = 0; i < 10; i++) {
            Cell cell = row.createCell(i); //Create a cell
            cell.setCellValue("Hello Batch 10"); //Sets value in the cell
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path); //creates a connection FROM our code To the file
        workbook.write(fileOutputStream); //write file
        workbook.close(); //For security reason, to prevent others to write to file we need always close the file.
        fileOutputStream.close(); //For security reason, need to close existing connection
    }
}
