/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Singleton {
       private static Connection connection; 
    
    static{
        try{
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/offrepub", "root", "");
 
        }
        catch(SQLException e ){
            e.printStackTrace(); 
        }
    }
    public static Connection getconn(){
        
   return connection ; 
    }
}
