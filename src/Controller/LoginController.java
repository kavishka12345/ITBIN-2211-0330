/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBSearch;
import java.sql.ResultSet;
import view.Mainframe;
import view.login;



public class LoginController {
    
    public static void login(String usName,String pW){
    
        try {
            
           String userName = null;
           String password = null;
           
           ResultSet rs = new DBSearch().searchLogin(usName);
           
            while(rs.next()){
            
            userName = rs.getString("user_name");
            password = rs.getString("password");
            
            
            }
            
            if(userName !=null && password !=null){
            
                
                if(userName.equals(usName) && password.equals(pW)){
                
                    System.out.println("Login Successfull");
                    
                    login.getFrames()[1].dispose();
                    new Mainframe().setVisible(true);
                
                }
            
            }
            
            
            
        } catch (Exception e) {
        }
    
    
    
    
    }
    
    
    
}
