/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.applicationoffrepub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Reclamation {
    private int id;
    private String motif,date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Reclamation( String motif, String date) {
       
        this.motif = motif;
        this.date = date;
    }

    
      public boolean addReclamation()throws SQLException,IndexOutOfBoundsException{
    boolean res= false;
    
    String sql = "INSERT INTO `reclamation`(`motif` , `date`, `etat`) VALUES (?,?,false)";
        try {
            Connection cnx = Singleton.Singleton.getconn();
            
            PreparedStatement stmt =cnx.prepareStatement(sql);
          
            stmt.setString(1,motif);
            stmt.setString(2,date);
           


            int rs =stmt.executeUpdate();
            
            if (rs==1){
            res=true;
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
        }
    return res;
    }
}
