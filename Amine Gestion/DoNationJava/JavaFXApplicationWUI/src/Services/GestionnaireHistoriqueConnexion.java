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

import Entities.Utilisateur;

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

            pst.setInt(1, hc.getUser().getId());
            pst.setString(2, hc.getIpAdresse());

            System.out.println(pst.toString());

            pst.executeUpdate();
            System.out.println("HC ADD Bravo ");
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("HC Add Erreur !!!");
        }
    }

    public List<HistoriqueConnexion> fetchHC() {
        List<HistoriqueConnexion> listHC = new ArrayList<>();
        //SELECT utilisateurs.id , utilisateurs.nom , utilisateurs.mail , historiqueconnexionuser.ipAdresse , historiqueconnexionuser.date FROM `historiqueconnexionuser` INNER join utilisateurs ON historiqueconnexionuser.idUtilisateur=utilisateurs.id 
        //String qSql="select * from historiqueconnexionuser ";
        String qSql = "SELECT utilisateurs.id , utilisateurs.nom , utilisateurs.mail , historiqueconnexionuser.id , historiqueconnexionuser.ipAdresse , historiqueconnexionuser.date FROM `historiqueconnexionuser` INNER join utilisateurs ON historiqueconnexionuser.idUtilisateur=utilisateurs.id ";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while (rs.next()) {
                HistoriqueConnexion hc = new HistoriqueConnexion();

                Utilisateur usTmp = new Utilisateur();

                usTmp.setId(rs.getInt(1));
                usTmp.setNom(rs.getString(2));
                usTmp.setMail(rs.getString(3));

                hc.setUser(usTmp);
                hc.setId(rs.getInt(4));
                hc.setIpAdresse(rs.getString(5));
                hc.setDateCnx(rs.getTimestamp(6));

                listHC.add(hc);
            }
            System.out.println("HC Select Bravo ");
        } catch (SQLException ex) {
            System.out.println("HC Select Erreur !!!");
        }
        return listHC;
    }

    public HistoriqueConnexion fetchOneUsHC(Utilisateur us) {
        HistoriqueConnexion hc = new HistoriqueConnexion();
        int id = us.getId();
    //String qSql = "select * from historiqueconnexionuser where id='" + id + "'";
        String qSql = "SELECT utilisateurs.id , utilisateurs.nom , utilisateurs.mail , historiqueconnexionuser.id , historiqueconnexionuser.ipAdresse , historiqueconnexionuser.date FROM `historiqueconnexionuser` INNER join utilisateurs ON historiqueconnexionuser.idUtilisateur=utilisateurs.id where idUtilisateur='"+id+"' ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while (rs.next()) {
                Utilisateur usTmp = new Utilisateur();

                usTmp.setId(rs.getInt(1));
                usTmp.setNom(rs.getString(2));
                usTmp.setMail(rs.getString(3));

                hc.setUser(usTmp);
                hc.setId(rs.getInt(4));
                hc.setIpAdresse(rs.getString(5));
                hc.setDateCnx(rs.getTimestamp(6));

            }
            System.out.println("Hc one Select Bravo ");
        } catch (SQLException ex) {
            System.out.println("Hc one Select Erreur !!!");
        }
        return hc;
    }
}
