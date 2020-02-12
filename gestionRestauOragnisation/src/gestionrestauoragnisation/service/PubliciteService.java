/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrestauoragnisation.service;

import gestionrestauoragnisation.entities.Publicité;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilis.DataSource;

/**
 *
 * @author Ahmed Fourati
 */
public class PubliciteService {
    
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
    
    
}
