/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Categorie;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Hedi
 */
public class ServiceCategorie {
    
    private Connection con;
    private Statement ste;
    private PreparedStatement pre;

    public ServiceCategorie() {
        
    con=DataBase.getInstance().getConnection();

    }
    
    public void ajouter(Categorie c) throws SQLException {
        
        String sql = "INSERT INTO `aide`.`categorie` ( `nom` ) VALUES ( ? );";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, c.getNom());
        pre.executeUpdate();
    }
    
    
    public boolean delete(int id) throws SQLException {
    
    String sql = "DELETE FROM categorie WHERE id=?";
    pre = con.prepareStatement(sql);
    pre.setInt(1, id);
    int rowsDeleted = pre.executeUpdate();
    if (rowsDeleted > 0) {
    System.out.println("A categorie was deleted successfully!");
    return true;
}
    return false;
    }
    
    //parametres : id de categorie à modifier, cN: nouvelle categorie
    public boolean update(int id, Categorie cN) throws SQLException {
    
    String sql ="UPDATE categorie SET nom=? WHERE id=?";
    //String sql ="UPDATE categorie SET nom=? WHERE nom=?";
    pre= con.prepareStatement(sql);
    pre.setString(1, cN.getNom());
    pre.setInt(2, id);
    int rowsUpdated = pre.executeUpdate();
    if (rowsUpdated > 0) {
    System.out.println("An existing user was updated successfully!");
    return true;
    }
    return false;
    } 
    
    
    public List<Categorie> readAll() throws SQLException {
    List<Categorie> arr = new ArrayList<>();
    String sql = "SELECT * FROM categorie";
    ste = con.createStatement();
    ResultSet rs = ste.executeQuery(sql);
    
    while(rs.next()){
            int id=rs.getInt(1);
            String nom=rs.getString("nom");
            Categorie c=new Categorie(id, nom);
            arr.add(c);
    }
    
    return arr;
    
}
    //trier les categories par ordre alphabetique
   public List<Categorie> trierCatAlph(List<Categorie> listCat){
       
         listCat.sort( 
                new Comparator<Categorie>()
{ 
                        public int compare(Categorie c1, Categorie c2)
                        {      
                            String firstCharS1 = String.valueOf(c1.getNom().charAt(0));
                            String firstCharS2 = String.valueOf(c2.getNom().charAt(0));
                            return firstCharS1.compareTo(firstCharS2);
                        }
        });
         return listCat;
   }
}
