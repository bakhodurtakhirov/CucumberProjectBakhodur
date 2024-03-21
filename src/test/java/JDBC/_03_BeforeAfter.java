package JDBC;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.*;

public class _03_BeforeAfter {
    Statement statement;
    Connection connection;
    @BeforeMethod
    public void DBConnection() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        
        connection = DriverManager.getConnection(url, username, password);
        
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    
    @AfterMethod
    public void DBConnectionClose() throws SQLException {
        connection.close();
    }
    
    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        
        rs.next();
        String language = rs.getString("name");
        System.out.println("language = " + language);
    }
    
    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");
        rs.next();
        
        String language = rs.getString("name");
        System.out.println("language = " + language);
        
        rs.next(); // moves one step forward
        
        language = rs.getString("name");
        System.out.println("language = " + language);
        
        rs.previous(); // moves one step backwards to the first row
        language = rs.getString("name");
        System.out.println("language = " + language);
    }
}