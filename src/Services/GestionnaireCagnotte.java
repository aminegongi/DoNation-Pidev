/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.cagnotte;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class GestionnaireCagnotte {
    Connection cn = DataSource.getInstance().getConnexion();
    
    public void ajouterDemande(cagnotte c){
        c.setDate_de_creation(Date.valueOf(LocalDate.now()));
        c.setEtat(0);
        c.setId_organisation(0);
        String requete = "INSERT INTO cagnotte (nom, date_de_creation, date_de_debut, date_de_fin, montant_demande, montant_actuel, id_proprietaire, id_organisation, etat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Statement st;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setDate(2, c.getDate_de_creation());
            pst.setDate(3, c.getDate_de_debut());
            pst.setDate(4, c.getDate_de_fin());
            pst.setFloat(5, c.getMontant_demande());
            pst.setFloat(6, c.getMontant_actuel());
            pst.setInt(7, c.getId_proprietaire());
            pst.setInt(8, c.getId_organisation());
            pst.setInt(9, c.getEtat());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCagnotte.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Demande ajoutée!");
    }
    
    public void modifierDemande(cagnotte c){
        String requete = "UPDATE cagnotte SET nom = ?, date_de_debut = ?, date_de_fin = ?, montant_demande = ?, montant_actuel = ? WHERE id = ?";
        Statement st;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setDate(2, c.getDate_de_debut());
            pst.setDate(3, c.getDate_de_fin());
            pst.setFloat(4, c.getMontant_demande());
            pst.setFloat(5, c.getMontant_actuel());
            pst.setInt(6, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCagnotte.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Demande modifiée!");
    }
    
    public void supprimerCagnotte(int id){
        String requete = "DELETE FROM cagnotte WHERE id = ?";
        Statement st;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCagnotte.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Demande supprimée!");
    }
    
    public void validerCagnotte(cagnotte c){
        c.setEtat(1);
        c.setId_organisation(12); //Tempo
        String requete = "UPDATE cagnotte SET etat = ?, id_organisation = ? WHERE id = ?";
        Statement st;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, c.getEtat());
            pst.setInt(2, c.getId_organisation());
            pst.setInt(3, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCagnotte.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Demande validée!");
    }
    
    public void ajouterDon(cagnotte c, float x){
        c.setMontant_actuel(c.getMontant_actuel() + x);
        String requete = "UPDATE cagnotte SET montant_actuel = ? WHERE id = ?";
        Statement st;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setFloat(1, c.getMontant_actuel());
            pst.setInt(2, c.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionnaireCagnotte.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(x + " DT on été ajouté!");
    }
}
