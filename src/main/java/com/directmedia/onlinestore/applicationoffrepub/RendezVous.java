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
public class RendezVous {
    private int id;
    private String nom,prenom,date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RendezVous(String nom, String prenom, String date) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
    }
    
      public boolean addRendezVous()throws SQLException,IndexOutOfBoundsException{
    boolean res= false;
    
    String sql = "INSERT INTO `rendezvous`(`nom` , `prenom`, `date`) VALUES (?,?,?)";
        try {
            Connection cnx = Singleton.Singleton.getconn();
            
            PreparedStatement stmt =cnx.prepareStatement(sql);
          
            stmt.setString(1,nom);
            stmt.setString(2,prenom);
            stmt.setString(3,date);


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
