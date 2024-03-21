package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ApachePOIntro {
    
    public static void main(String[] args) throws IOException {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add((int) (Math.random() * 101));
//        }
        /*
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                list.get(i).add((int) (Math.random() * 101));
            }
        }
        System.out.println(list);*/
        
        String path = "C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\ApacheExcel2.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path); //Creates one way read connection from Excel file to code
        
        Workbook workbook = WorkbookFactory.create(fileInputStream); //open the file in the memory
        Sheet sheet = workbook.getSheet("Sheet1"); //Can use index or sheet name which is more preferable because changing order of the sheets will not cause any issue
        
        Row row1 = sheet.getRow(0); // Row of the sheet starts from 0. Make sure to select Apache POI for all objects.
        Cell cell = row1.getCell(0);// Cell of the row starts from 0. Integers are showing as double with decimal point. If there will be only space, then result will look empty. If the cell is really empty, then "null" will be returned.
        
        System.out.println("cell = " + cell); //will return text of the cell but actually it's Cell type which contains all properties of the cell.
        
        Row row2 = sheet.getRow(1); // Row of the sheet
        Cell cell3 = row2.getCell(2);// Cell of the row.
        
        System.out.println("cell3 = " + cell3);
    }
}
