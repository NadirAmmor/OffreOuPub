/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.applicationoffrepub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Admin {
            private long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    
      public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String nom, String prenom, String email , String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }
        public static boolean authentification(String email,String password){
    
        boolean res= false;

            String sql = "SELECT * FROM `admin` WHERE email = '" +email + "' " + "AND password = '" + password + "' ";
            
            System.out.println("req = " + sql);
            
            try {
                 System.out.println("req = " + sql);
                Connection cnx;
                cnx = Singleton.Singleton.getconn();
                PreparedStatement stmt = cnx.prepareStatement(sql);
                
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    res=true;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
            return res;
    }
            public static int authentification2(String email,String password){
    
        int res= -1;

            String sql = "SELECT * FROM `admin` WHERE email = '" +email + "' " + "AND password = '" + password + "' ";
            
            System.out.println("req = " + sql);
            
            try {
                 System.out.println("req = " + sql);
                Connection cnx;
                cnx = Singleton.Singleton.getconn();
                PreparedStatement stmt = cnx.prepareStatement(sql);
                
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    res= rs.getInt(1);
                    
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
            return res;
    }
}
