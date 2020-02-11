/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.Adresse;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entities.Utilisateur;
import java.util.HashMap;

/**
 *
 * @author Amine Gongi
 */
public class GestionnaireUtilisateur {
    Connection cnx = DataSource.getInstance().getConnection();
    
    
    public int loginU(String mail,String mdp){
        String qSql="select id,mail from utilisateurs where mail='"+mail+"' AND mdp='"+mdp+"' Limit 1 ";
        try {
            Statement st = cnx.createStatement();
            //pst.setString(1, mail);
            st.executeQuery(qSql);
            ResultSet rs = st.executeQuery(qSql);
            while(rs.next())
            {
                
                return rs.getInt(1);
            }
            System.out.println("U login Bravo ");
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("U login Erreur !!!");
        }
        return -1;
    }
    
    public boolean checkMail(String mail){
        String qSql="select mail from utilisateurs where mail='"+mail+"' Limit 1 ";
        try {
            Statement st = cnx.createStatement();
            //pst.setString(1, mail);
            st.executeQuery(qSql);
            ResultSet rs = st.executeQuery(qSql);
            while(rs.next())
            {
                return true;
            }
            System.out.println("U checkMail Bravo ");
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("U checkMail Erreur !!!");
        }
        return false;
    }
    
    public boolean desactiverCompte(int id){
        String qSql = "UPDATE utilisateurs SET enabled=0  WHERE id=?";
        PreparedStatement pst = null;
            try {
                pst = cnx.prepareStatement(qSql);

                pst.setInt(1, id);
                pst.executeUpdate();
                
                System.out.println("Utilisateur desactiver Bravo ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
                System.out.println("Utilisateur desactiver Erreur !!!");
            }

        return false;
    }
    
    public boolean activerCompte(int id){
        String qSql = "UPDATE utilisateurs SET enabled=1  WHERE id=?";
        PreparedStatement pst = null;
            try {
                pst = cnx.prepareStatement(qSql);

                pst.setInt(1, id);
                pst.executeUpdate();
                
                System.out.println("Utilisateur activer Bravo ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
                System.out.println("Utilisateur activer Erreur !!!");
            }

        return false;
    }
    public float checkXP (int id)
    {
        float x=-1;
        String qSql="select pointXP from utilisateurs where id='"+id+"' ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while(rs.next())
            {
                x=rs.getFloat(1);
            }
        } catch (SQLException ex) {
        }  
        return x;
    }
    
    public boolean pointXp(int id,float montant){
        String qSql ;
        if(checkXP(id)+montant > 0)
            qSql = "UPDATE utilisateurs SET pointXp=pointXp+"+montant+"  WHERE id=?";
        else
            qSql = "UPDATE utilisateurs SET pointXp=0  WHERE id=?";
        
        PreparedStatement pst = null;
            try {
                pst = cnx.prepareStatement(qSql);

                pst.setInt(1, id);
                pst.executeUpdate();
                
                System.out.println("Utilisateur XP ++ Bravo ");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
                System.out.println("Utilisateur XP ++ Erreur !!!");
            }

        return false;
    }
    
    //SELECT count(*) FROM `utilisateurs` GROUP BY role
    public HashMap<String,Integer> nbCompteRole ()
    {
        HashMap<String,Integer> hm = new HashMap<>();
        String qSql="SELECT role,count(*) FROM `utilisateurs` GROUP BY role";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while(rs.next())
            {
                hm.put(rs.getString(1), rs.getInt(2));
            }
        } catch (SQLException ex) {
        }  
        return hm;
    }
    
    
}
