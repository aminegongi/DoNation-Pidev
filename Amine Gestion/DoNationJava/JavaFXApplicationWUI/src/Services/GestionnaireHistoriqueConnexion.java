/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataSource;
import java.sql.Connection;
import Entities.HistoriqueConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Amine Gongi
 */
public class GestionnaireHistoriqueConnexion {
    Connection cnx = DataSource.getInstance().getConnection();
    
    public void AjouterHC(HistoriqueConnexion hc) {
        String qSql = "INSERT INTO historiqueconnexionuser (idUtilisateur, ipAdresse) VALUES (?,?)";
        PreparedStatement pst = null;
        try {
            pst = cnx.prepareStatement(qSql);

            pst.setInt(1, hc.getIdUtilisateur());
            pst.setString(2, hc.getIpAdresse());

            System.out.println(pst.toString());
            
            pst.executeUpdate();
            System.out.println("HC ADD Bravo ");
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("HC Add Erreur !!!");
        }
    }

    
    public List<HistoriqueConnexion> fetchHC (){
        List<HistoriqueConnexion> listHC = new ArrayList<>();
        //SELECT utilisateurs.nom , utilisateurs.prenom , utilisateurs.mail , historiqueconnexionuser.ipAdresse , historiqueconnexionuser.date FROM `historiqueconnexionuser` INNER join utilisateurs ON historiqueconnexionuser.idUtilisateur=utilisateurs.id 
        String qSql="select * from historiqueconnexionuser ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while(rs.next())
            {
                HistoriqueConnexion hc=new HistoriqueConnexion();
                hc.setId(rs.getInt(1));
                hc.setIdUtilisateur(rs.getInt(2));
                hc.setIpAdresse(rs.getString(3));
                hc.setDateCnx(rs.getTimestamp(4).toString());

                listHC.add(hc);
            }
            System.out.println("HC Select Bravo ");
        } catch (SQLException ex) {
            System.out.println("HC Select Erreur !!!");
        }   
        return listHC;
    }
    
    public HistoriqueConnexion fetchOneHC (int id){
        HistoriqueConnexion hc = new HistoriqueConnexion();
        String qSql="select * from historiqueconnexionuser where id='"+id+"'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while(rs.next())
            {
                hc.setId(rs.getInt(1));
                hc.setIdUtilisateur(rs.getInt(2));
                hc.setIpAdresse(rs.getString(3));
                hc.setDateCnx(rs.getTimestamp(4).toString());
            }
            System.out.println("Hc one Select Bravo ");
        } catch (SQLException ex) {
            System.out.println("Hc one Select Erreur !!!");
        }   
        return hc;
    }
}
