package JDBC;

import org.testng.annotations.Test;
import utilities.DBUtilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstAndLastGetRow extends DBUtilities {
    @Test
    void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city_id, city, country_id from city");
        rs.last(); //move to the last row
        String cityName = rs.getString("city");
        System.out.println("cityName = " + cityName);
        
        int nuberOfLastRow = rs.getRow(); //returns current row number(not ID of the row). Because rows with their IDs can be deleted, so row number and row ID may not match.
        System.out.println("nuberOfLastRow = " + nuberOfLastRow);
        
        int cityID = rs.getInt("city_id"); //will get integer of the current row for math operations. Can't use for String column type. getString is universal if no need to do math operations
        System.out.println("cityID = " + cityID);
        
        rs.first(); //move to the first row
        cityName = rs.getString("city");
        System.out.println("cityName = " + cityName);
    }
}
