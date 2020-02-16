/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrestauoragnisation.service;

import Iservice.IService;
import gestionrestauoragnisation.entities.AppelAuDon;
import gestionrestauoragnisation.entities.OffreDon;
import gestionrestauoragnisation.entities.Publicité;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilis.DataSource;

/**
 *
 * @author Ahmed Fourati
 */
public class PubliciteService implements IService<Publicité> {
    
    Connection cn = DataSource.getInstance().getConnexion(); 
 
    
    
    public void ajouter(Publicité p ){
        
    String requette = "INSERT INTO `publicite`( `titre`, `description`, `dateAjout`,`marque`) VALUES (?,?,?,?);" ; 
       
            PreparedStatement pst;
            try {
                pst = cn.prepareStatement(requette);
                pst.setString(1, p.getTitre());
                pst.setString(2, p.getDescription());
                pst.setString(3, p.getDateAjout());
                pst.setString(4, p.getMarque());
                pst.executeUpdate() ; 
            } catch (SQLException ex) {
                Logger.getLogger(OffreDonService.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
        
    }
   public void modifier(Publicité p, int id) {
        String qSql = "UPDATE publicite SET titre=?,marque=?,description=? WHERE id=?";
        PreparedStatement pst = null;
        
        try {
            pst = cn.prepareStatement(qSql);
            pst.setString(1, p.getTitre());
            pst.setString(2, p.getMarque());
            pst.setString(3, p.getDescription());
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteService.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
   public List<Publicité> afficher(){
    String sql = "SELECT `id`, `titre`, `marque`, `description`, `dateAjout` FROM `publicite`" ;
    List<Publicité> list = new ArrayList<>() ;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next())
            {
              Publicité p = new Publicité();
              p.setId(rs.getInt(1));
              p.setTitre(rs.getString(2));
              p.setMarque(rs.getString(3));
              p.setDescription(rs.getString(4));
              p.setDateAjout(rs.getString(5));
              list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
   public void supprimer(Publicité o) {

        try {
            String requete = "DELETE FROM `publicite` WHERE `id`=? ";
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1, o.getId());
            pst.executeUpdate();
            System.out.println("publicite supprimé avec succées");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
