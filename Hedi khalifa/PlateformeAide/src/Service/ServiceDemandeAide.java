/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Categorie;
import Entite.DemandeAide;
import Utils.DataBase;
import Utils.Etat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hedi
 */

public class ServiceDemandeAide {
    
    private Connection con;
    private Statement ste;
    private PreparedStatement pre;

    public ServiceDemandeAide() {
        
    con=DataBase.getInstance().getConnection();

    }
    
    public void ajouter(DemandeAide d) throws SQLException {
        
    String sql = "INSERT INTO `aide`.`demande` ( `titre`, `description`, `etat`, `nb_participants`, `nb_reactions`, `nb_commentaires` ) VALUES ( ?, ?, ?, ?, ?, ? );";
    PreparedStatement pre = con.prepareStatement(sql);
    pre.setString(1, d.getTitre());
    pre.setString(2, d.getDescription());
    pre.setString(3, d.getEtatAsString());
    pre.setInt(4, d.getNbParticipants());
    pre.setInt(5, d.getNbReactions());
    pre.setInt(6, d.getNbCommentaires());
    pre.executeUpdate();
    }
        
    //id = id de  demande à modifier, dN = nouvelle demande
    public boolean update(int id, DemandeAide dN) throws SQLException {
    
    //String sql ="UPDATE categorie SET nom=? WHERE id=?";
    String sql ="UPDATE demande SET titre=?, description=?, etat=?, nb_participants=?, nb_reactions=?, nb_commentaires=? WHERE id=?";
    pre= con.prepareStatement(sql);
    pre.setString(1, dN.getTitre());
    pre.setString(2, dN.getDescription());
    pre.setString(3, dN.getEtatAsString());
    pre.setInt(4, dN.getNbParticipants());
    pre.setInt(5, dN.getNbReactions());
    pre.setInt(6, dN.getNbCommentaires());
    pre.setInt(7, id);
    
    int rowsUpdated = pre.executeUpdate();
    if (rowsUpdated > 0) {
    System.out.println("An existing user was updated successfully!");
    return true;
    }
    return false;
    }
    
    
    public boolean delete(int id) throws SQLException {
    
    String sql = "DELETE FROM demande WHERE id=?";
    pre = con.prepareStatement(sql);
    pre.setInt(1, id);
    //pre.setInt(1, 6);
    int rowsDeleted = pre.executeUpdate();
    if (rowsDeleted > 0) {
    System.out.println("A categorie was deleted successfully!");
    return true;
}
    return false;
    }
    
    
    public List<DemandeAide> readAll() throws SQLException {
    List<DemandeAide> arr = new ArrayList<>();
    String sql = "SELECT * FROM demande";
    ste = con.createStatement();
    ResultSet rs = ste.executeQuery(sql);
    
    while(rs.next()){
            int id=rs.getInt(1);
            String titre=rs.getString("titre");
            String description=rs.getString(3);
            Etat etat=Etat.valueOf(rs.getString("etat"));
            int nbParticipants=rs.getInt(5);
            int nbReactions=rs.getInt(6);
            int nbCommentaires=rs.getInt(7);
            //probleme
            DemandeAide d =new DemandeAide(id,  titre,  description, etat,  nbParticipants,  nbReactions,  nbCommentaires);
            arr.add(d);
    }
    
    return arr;
    
}
   
}

//1- make Enum Etat as a seperated file to enable the public access from other classes

//3-complete the update methode