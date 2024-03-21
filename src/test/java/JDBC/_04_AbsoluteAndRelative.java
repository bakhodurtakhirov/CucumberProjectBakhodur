package JDBC;

import org.testng.annotations.Test;
import utilities.DBUtilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_AbsoluteAndRelative extends DBUtilities {
    
    @Test
    void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");
        
        rs.absolute(20); // takes us to the 20th row right away
        
        String title = rs.getString("title");
        System.out.println("title = " + title);
        
        rs.absolute(924); // takes us to the 924th row
        
        title = rs.getString("title");
        System.out.println("title = " + title);
        
        rs.absolute(3); // takes us to the 3rd row
        
        title = rs.getString("title");
        System.out.println("title = " + title);
        
        rs.relative(20); // Jumps 20 rows at once and takes us to the 23rd row
        
        title = rs.getString("title");
        System.out.println("title = " + title);
        
        rs.relative(17); // Jumps 17 rows and takes us to the 40th row
        
        title = rs.getString("title");
        System.out.println("title = " + title);
        
        rs.relative(-30); // Jumps 30 rows backwards and takes us to the 10th row
        
        title = rs.getString("title");
        System.out.println("title = " + title);
    }
}
