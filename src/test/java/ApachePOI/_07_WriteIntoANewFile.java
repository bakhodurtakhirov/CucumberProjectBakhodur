package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _07_WriteIntoANewFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\WriteIntoANewFile.xlsx"; //Non-existing file
        
        XSSFWorkbook workbook = new XSSFWorkbook(); //Creates a temp file in the memory. This also works for existing files
        XSSFSheet sheet = workbook.createSheet("My Sheet"); //Creates a sheet in a temp file. This also works for existing files
        
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello Batch 10");

        FileOutputStream fileOutputStream = new FileOutputStream(path); //creates a connection FROM our code To the file
        workbook.write(fileOutputStream); //write file
        workbook.close(); //For security reason, to prevent others to write to file we need always close the file.
        fileOutputStream.close(); //For security reason, need to close existing connection
    }
}
