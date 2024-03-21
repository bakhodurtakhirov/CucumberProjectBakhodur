package JDBC;

import org.testng.annotations.Test;
import utilities.DBUtilities;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _06_GetAllDataFromARow extends DBUtilities {
    @Test
    void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData(); //Retrieves the number, types and properties of this ResultSet object's columns.
        
        int columnCount = rsmd.getColumnCount(); //Returns total number of columns
        System.out.println("columnCount = " + columnCount);
        
        rs.last(); // to get quantity of row
        int numberOfRows = rs.getRow();
        rs.first(); //return back to first row to start loop from there
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= columnCount; j++) {
                
                String columnType = rsmd.getColumnTypeName(j); // gives the data type of the column
                System.out.print("columnType = " + columnType);
                
                String columnName = rsmd.getColumnName(j); // gives the title of the column
                System.out.print(" columnName = " + columnName);
                
                String value = rs.getString(j);
                System.out.print(" value = " + value);
                System.out.println();
            }
            rs.next();//must move to new row
        }
    }
}
