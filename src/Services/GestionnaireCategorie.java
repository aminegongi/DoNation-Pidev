/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.categorie;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public class GestionnaireCategorie {
    Connection cn = DataSource.getInstance().getConnexion();

    public void ajouterCategorie(categorie c){
        String requete = "INSERT INTO categorie (nom, description) VALUES (?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Categorie ajoutée!");
    }
    
    public void modifierCategorie(categorie c){
        String requete = "UPDATE categorie SET nom = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getDescription());
            pst.setInt(3, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Categorie modifée!");
    }
    
    public void supprimerCategorie(int id){
        String requete = "DELETE FROM categorie WHERE id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Categorie supprimée!");
    }
    
    public List<categorie> getCategories(){
        List<categorie> list = new ArrayList<>();
        String requete = "SELECT * FROM categorie";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                categorie c = new categorie(rs.getInt(1), rs.getString(2), rs.getString(3));                
                list.add(c);
            }
            System.out.println("List des categories à été crée!");
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public categorie getCategorie(int id){
        String requete = "SELECT * FROM categorie WHERE id = ?";
        categorie c = null;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            c = new categorie(rs.getInt(1), rs.getString(2), rs.getString(3));
            System.out.println("Categorie à été trouvé!");
        } catch (SQLException ex) {
        }
        return c;
    }
}
