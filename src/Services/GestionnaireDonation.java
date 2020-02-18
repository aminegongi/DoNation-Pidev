/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.donation;
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
public class GestionnaireDonation {
    Connection cn = DataSource.getInstance().getConnexion();

    public void ajouterDonation(donation d){
        String requete = "INSERT INTO donations (id, id_cagnotte, id_utilisateur, date_don, methode) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, d.getId());
            pst.setInt(2, d.getId_cagnotte());
            pst.setInt(3, d.getId_utilisateur());
            pst.setDate(4, d.getDate());
            pst.setString(5, d.getMethode());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Donation ajoutée!");
    }
    
    public void modifierDonation(donation d){
        String requete = "UPDATE donations SET id = ?, id_cagnotte = ?, id_utilisateur = ?, date_don = ?, methode = ? WHERE id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, d.getId());
            pst.setInt(2, d.getId_cagnotte());
            pst.setInt(3, d.getId_utilisateur());
            pst.setDate(4, d.getDate());
            pst.setString(5, d.getMethode());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Donation modifé!");
    }
    
    public void supprimerDonation(int id){
        String requete = "DELETE FROM donations WHERE id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Donation supprimée!");
    }
    
    public List<donation> getDonations(){
        List<donation> list = new ArrayList<>();
        String requete = "SELECT * FROM donations";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                donation d = new donation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5));                
                list.add(d);
            }
            System.out.println("List des dons à été crée!");
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public donation getDonation(int id){
        String requete = "SELECT * FROM donation WHERE id = ?";
        donation d = null;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            d = new donation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5));
            System.out.println("Donation à été trouvé!");
        } catch (SQLException ex) {
        }
        return d;
    }
}
