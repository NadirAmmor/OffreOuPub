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
public class Clientel {
    private int id;
private String nom,prenom,email,date,typeAssurance;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeAssurance() {
        return typeAssurance;
    }

    public void setTypeAssurance(String typeAssurance) {
        this.typeAssurance = typeAssurance;
    }

    public Clientel(String nom, String prenom, String email, String date, String typeAssurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date = date;
        this.typeAssurance = typeAssurance;
    }

  public boolean addUser()throws SQLException,IndexOutOfBoundsException{
    boolean res= false;
    
    String sql = "INSERT INTO `clientel`(`nom` , `prenom`, `email`, `date`, `typeAssurance` ) VALUES (?,?,?,?,?)";
        try {
            Connection cnx = Singleton.Singleton.getconn();
            
            PreparedStatement stmt =cnx.prepareStatement(sql);
          
            stmt.setString(1,nom);
            stmt.setString(2,prenom);
            stmt.setString(3,email);
            stmt.setString(4,date);
            stmt.setString(5, typeAssurance);

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
