package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilities {
    protected static Statement statement;
    private static Connection connection;
    
    @BeforeMethod
    public static void DBConnection() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        try {
            connection = DriverManager.getConnection(url, username, password);
            
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @AfterMethod
    public static void DBConnectionClose() throws SQLException {
        connection.close();
    }
    
    public static List<List<String>> getData(String query) {
        List<List<String>> returnList = new ArrayList<>();//Result set is not very suitable to manipulate with data so we use 2D array list
        DBConnection(); //Open the connection
        
        try {
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) { // next() moves to next row and returns false if there is no next row, so we don't need to get number of rows of our result
                List<String> row = new ArrayList<>(); //Each iteration add empty 1D row which will be added to 2D row
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) { //loop through columns
                    String value = rs.getString(i);
                    row.add(value); //add column values to 1D row
                }
                returnList.add(row);
            }
            DBConnectionClose(); //Close the connection
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return returnList;
    }
}
