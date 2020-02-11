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

    // JAVA return -1= login Mail MDP incorrect / -2=compte disabled /-3=compte non encore activer / else ID user
    // Mysql champ val 0= disabled par admin / 1=activer /-1=non encore activer 
    public int loginU(String mail, String mdp) {
        String qSql = "select id,mail,enabled from utilisateurs where mail='" + mail + "' AND mdp='" + mdp + "' Limit 1 ";
        try {
            Statement st = cnx.createStatement();
            //pst.setString(1, mail);
            st.executeQuery(qSql);
            ResultSet rs = st.executeQuery(qSql);
            while (rs.next()) {
                if (rs.getInt(3) == 0) {
                    return -2;
                } else if (rs.getInt(3) == -1) {
                    return -3;
                } else {
                    return rs.getInt(1);
                }
            }
            System.out.println("U login Bravo ");
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("U login Erreur !!!");
        }
        return -1;
    }

    public boolean checkMail(String mail) {
        String qSql = "select mail from utilisateurs where mail='" + mail + "' Limit 1 ";
        try {
            Statement st = cnx.createStatement();
            //pst.setString(1, mail);
            st.executeQuery(qSql);
            ResultSet rs = st.executeQuery(qSql);
            while (rs.next()) {
                return true;
            }
            System.out.println("U checkMail Bravo ");
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("U checkMail Erreur !!!");
        }
        return false;
    }

    public boolean desactiverCompte(int id) {
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

    public boolean activerCompte(int id) {
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

    public boolean activerCompteKeyMail(String mail, String key) {
        String qSql = "UPDATE utilisateurs SET enabled=1  WHERE mail=? AND confirm_token=?";
        PreparedStatement pst = null;
        try {
            pst = cnx.prepareStatement(qSql);

            pst.setString(1, mail);
            pst.setString(2, key);
            pst.executeUpdate();
            int x = pst.getUpdateCount();
            System.out.println(x);
            if(x>0)
                return true;
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println("Utilisateur activer Erreur !!!");
        }

        return false;
    }

    public float checkXP(int id) {
        float x = -1;
        String qSql = "select pointXP from utilisateurs where id='" + id + "' ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while (rs.next()) {
                x = rs.getFloat(1);
            }
        } catch (SQLException ex) {
        }
        return x;
    }

    public boolean pointXp(int id, float montant) {
        String qSql;
        if (checkXP(id) + montant > 0) {
            qSql = "UPDATE utilisateurs SET pointXp=pointXp+" + montant + "  WHERE id=?";
        } else {
            qSql = "UPDATE utilisateurs SET pointXp=0  WHERE id=?";
        }

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
    public HashMap<String, Integer> nbCompteRole() {
        HashMap<String, Integer> hm = new HashMap<>();
        String qSql = "SELECT role,count(*) FROM `utilisateurs` GROUP BY role";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(qSql);
            while (rs.next()) {
                hm.put(rs.getString(1), rs.getInt(2));
            }
        } catch (SQLException ex) {
        }
        return hm;
    }

}
