/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DBConnection {
    
    
    static Connection conn;
    static Statement stat = null;
    
    
    public static Statement getSatementConnection(){
    
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/o\"oop project","root","");
            
            
            stat = conn.createStatement();
            
        } catch (Exception e) {
        }
    
    return stat;
    }
    
    
    public static void closeCon() throws SQLException{
    
    conn.close();
    
    }
    
    
}
