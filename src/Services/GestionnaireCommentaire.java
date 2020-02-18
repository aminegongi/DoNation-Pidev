/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.commentaire;
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
public class GestionnaireCommentaire {
    Connection cn = DataSource.getInstance().getConnexion();

    public void ajouterCommentaire(commentaire cm){
        String requete = "INSERT INTO commentaire (id_cagnotte, id_utilisateur, body) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, cm.getId_cagnotte());
            pst.setInt(2, cm.getId_utilisateur());
            pst.setString(3, cm.getBody());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Commentaire ajouté!");
    }
    
    public void modifierCommentaire(commentaire cm){
        String requete = "UPDATE commentaire = ? WHERE id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, cm.getBody());
            pst.setInt(2, cm.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Commentaire modifé!");
    }
    
    public void supprimerCommentaire(int id){
        String requete = "DELETE FROM commentaire WHERE id = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println("Commentaire supprimé!");
    }
    
    public List<commentaire> getCommentaires(){
        List<commentaire> list = new ArrayList<>();
        String requete = "SELECT * FROM commentaire";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                commentaire cm = new commentaire(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));                
                list.add(cm);
            }
            System.out.println("List des commentaires à été crée!");
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public List<commentaire> getCommentairesCagnotte(int id_cagnotte){
        List<commentaire> list = new ArrayList<>();
        String requete = "SELECT * FROM commentaire WHERE id_cagnotte = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id_cagnotte);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                commentaire cm = new commentaire(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));                
                list.add(cm);
            }
            System.out.println("List des commentaires de cagnotte menionnée à été crée!");
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public List<commentaire> getCommentairesUtilisateur(int id_utilisateur){
        List<commentaire> list = new ArrayList<>();
        String requete = "SELECT * FROM commentaire WHERE id_utilisateur = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id_utilisateur);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                commentaire cm = new commentaire(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));                
                list.add(cm);
            }
            System.out.println("List des commentaires de'utilisateur menionnée à été crée!");
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public commentaire getCommentaire(int id){
        String requete = "SELECT * FROM commentaire WHERE id = ?";
        commentaire cm = null;
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            cm = new commentaire(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));                
            System.out.println("Commentaire à été trouvé!");
        } catch (SQLException ex) {
        }
        return cm;
    }
}