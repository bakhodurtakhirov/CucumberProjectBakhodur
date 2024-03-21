package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _02_JDBCIntro {
    @Test
    public void test1() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        //library name://typeofDB:hostURL:portNumber/nameOfDB
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from actor"); // no need ; at the end of the query. Contains whole table
        rs.next();
        //In DB index starts with 1
        String firstName = rs.getString(2); //using column index
        System.out.println("firstName = " + firstName);
        
        String lastName = rs.getString("last_name"); //using column name
        System.out.println("lastName = " + lastName);
        rs.next(); //Now we're on the second row
        firstName = rs.getString(2); //using column index
        System.out.println("firstName = " + firstName);
        
        lastName = rs.getString("last_name"); //using column name
        System.out.println("lastName = " + lastName);
        
        connection.close(); //always close the connection for security reason
    }
}
