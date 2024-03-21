package utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilities {
    public static List<List<String>> getDataFromExcel(String path, String sheetName) {
        
        List<List<String>> returnList = new ArrayList<>();
        
        FileInputStream fileInputStream;
        Workbook workbook;
        Sheet sheet = null;
        try {
            fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> innerList = new ArrayList<>(); // represents our rows
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                innerList.add(cell.toString()); // adding our cells to our row
            }
            returnList.add(innerList); // adding the rows to the return list
        }
        return returnList;
    }
    
    /*public static void writeScenarioInfoToExcel(Scenario scenario, LocalDateTime startTime, LocalDateTime endTime, Duration duration) {
        String path = "src/test/java/ApachePOI/resources/scenarioInfo.xlsx";
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fileInputStream;
            Workbook workbook = null;
            Sheet sheet = null;
            try {
                fileInputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(fileInputStream);
                sheet = workbook.getSheet("CampusTestResults");
            } catch (IOException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
            
            int numberOfRows = sheet.getPhysicalNumberOfRows(); //all current rows count
            Row row = sheet.createRow(numberOfRows); //continue from new row without overwriting existing ones
            row.createCell(0).setCellValue(scenario.getId());
            row.createCell(1).setCellValue(scenario.getName());
            row.createCell(2).setCellValue(scenario.getStatus().toString());
            row.createCell(3).setCellValue(startTime.toString());
            row.createCell(4).setCellValue(endTime.toString());
            row.createCell(5).setCellValue(duration.toString());
            
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("CampusTestResults");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue(scenario.getId());
            row.createCell(1).setCellValue(scenario.getName());
            row.createCell(2).setCellValue(scenario.getStatus().toString());
            row.createCell(3).setCellValue(startTime.toString());
            row.createCell(4).setCellValue(endTime.toString());
            row.createCell(5).setCellValue(duration.toString());
            
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }*/
    
    //A shorter version of above
    public static void writeScenarioInfoToExcel(Scenario scenario, LocalDateTime startTime, LocalDateTime endTime, Duration duration) {
        String path = "src/test/java/ApachePOI/resources/scenarioInfo.xlsx";
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(path));
             FileOutputStream outputStream = new FileOutputStream(path)) {
            
            Sheet sheet = workbook.getSheet("CampusTestResults");
            int rowCount = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowCount);
            row.createCell(0).setCellValue(scenario.getId());
            row.createCell(1).setCellValue(scenario.getName());
            row.createCell(2).setCellValue(scenario.getStatus().toString());
            
            workbook.write(outputStream);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
