package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _04_GetSpecificData {
    public static void main(String[] args) throws IOException {
        /**
         * Check the value in the first cell of each row
         * If that value matches with the user's response
         * Print all values on that row
         **/
        System.out.println("What do you want to search for?");
        Scanner scanner = new Scanner(System.in);
        String userResponse = scanner.nextLine();
        System.out.println(getSpecificValue(userResponse));
    }
    
    public static String getSpecificValue(String userResponse) throws IOException {
        String path = "C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\LoginData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Login");
        
        StringBuilder returnValue = new StringBuilder(); //Much for memory efficient way compared to String.
        
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(0).toString().equalsIgnoreCase(userResponse)) {
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell cell = row.getCell(j);
                    returnValue.append(cell).append(" ");
                }
                break;
            }
        }
        return returnValue.toString();
    }
}
