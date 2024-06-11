/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DBconnect;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DBSearch {
    
    Statement stmt;
    ResultSet rs;
    
    public ResultSet searchLogin(String usName){
    
        try {
            
          Class.forName("com.mysql.cj.jdbc.Driver");         
          stmt = DBConnection.getSatementConnection();
          
          rs = stmt.executeQuery("SELECT * FROM login where user_name='"+usName+"'");
          
        } catch (Exception e) {
        }
    
    
    return rs;
    
    
    }
    
    
    
    
    
}
