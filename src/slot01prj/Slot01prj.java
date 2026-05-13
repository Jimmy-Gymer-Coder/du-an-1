/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slot01prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thanh_sann
 */
public class Slot01prj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String DB_URL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=SaleMNG;";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // connnect to database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, "sa", "12345");
            // create statement
            stmt = conn.createStatement();
            // get data from table tblUser'
            rs = stmt.executeQuery("select * from tblProducts where supcode='MN02'");
            // show data
            String proid, proname;
            while (rs.next()) {
                proid = rs.getString("ProID");
                proname = rs.getString("proName");
                
                System.out.println(proid + "-" + proname);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Connection");
        } finally {
            // close connection
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
