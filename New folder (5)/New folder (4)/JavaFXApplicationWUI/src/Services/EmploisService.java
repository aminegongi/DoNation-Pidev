/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Emplois;
import ISevices.IServiceEmplois;
import Utils.DataSource;
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
 * @author heshem
 */
public class EmploisService implements IServiceEmplois{

    
         private Connection con;
    private Statement ste;

    public EmploisService() {
        con = DataSource.getInstance().getConnection();

    }

     
     @Override
    public void ajouter(Emplois t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `donation`.`emplois` (`id`, `titre`, `description`, `Photo`, `salaire`, `emplacement`, `TypeDemploi`, `TypeContrat`, `idcategorie`) VALUES ( NULL,?, ?, ?, ?, ?, ?, ?, ?);");
    pre.setString(1, t.getTitre());
    pre.setString(2, t.getDescreption());
    
     pre.setString(3, t.getPhoto());
    pre.setDouble(4, t.getSalaire());
    pre.setString(5, t.getEmplacement());
     pre.setString(6, t.getTypeDemploi());
     pre.setString(7, t.getTypeContrat());
     pre.setInt(8, t.getIdCategorie());
     
    
    pre.executeUpdate();
    }
    
  
    
    public void ajouter1(Emplois p) throws SQLException
    {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `donation`.`emplois`  (`id`, `titre`, `description`, `Photo`, `salaire`, `emplacement`, `TypeDemploi`, `TypeContrat`, `idcategorie`) VALUES (NULL,?,?,?,?,?,?,?,?);");
    pre.setString(1, p.getTitre());
    pre.setString(2, p.getDescreption()); 
     pre.setString(3, p.getPhoto());
    pre.setDouble(4, p.getSalaire());
    pre.setString(5, p.getEmplacement());
    pre.setString(6, p.getTypeDemploi());
    pre.setString(7, p.getTypeContrat());
    pre.setInt(8, p.getIdCategorie());
    
    pre.executeUpdate();   
    }

    @Override
    public boolean delete(int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `donation`.`emplois` where id =?");
        pre.setInt(1, id);
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("emplois was deleted successfully!");
        }
        return true;
    }

    @Override
    public boolean update(Emplois t,int id) throws SQLException {
      String sql = "UPDATE emplois SET titre=?, description=?, Photo=?, salaire=?, emplacement=?, TypeDemploi=?, TypeContrat=? WHERE id=? ";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, t.getTitre());
        statement.setString(2, t.getDescreption());
        statement.setString(3, t.getPhoto());
        statement.setDouble(4, t.getSalaire());
        statement.setString(5, t.getEmplacement());
        statement.setString(6, t.getTypeDemploi());
        statement.setString(7, t.getTypeContrat());
        statement.setInt(8, id);
       

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing emplois was updated successfully!");
        }
        return true;
    }

    @Override
    public List<Emplois> readAll() throws SQLException {
    List<Emplois> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from emplois");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String titre=rs.getString("titre");
               String description=rs.getString("description");
               String photo=rs.getString("Photo");
               double salaire=rs.getDouble("salaire");
               String emplacement=rs.getString("emplacement");
               String TypeDemploi=rs.getString("TypeDemploi");
               String TypeContrat=rs.getString("TypeContrat");
               int IdCategorie=rs.getInt("idcategorie");
               Emplois p=new Emplois(id, titre, description, photo, salaire, emplacement, TypeDemploi, TypeContrat,IdCategorie);
     arr.add(p);
     }
    return arr;    }
    
    public Boolean findById(int id) throws SQLException {
        String req = "select * from emplois where id = ?";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next() == true) {
            System.out.println("emplois touvé !");
            return true;
            
        }
        System.out.println("emplois non touvé !");
        return false;
    }
    
    public List<Emplois> trierTitre(int t) throws SQLException{
    List<Emplois> list = this.readAll();
    if(t==0)
        list.sort((Emplois o1 ,Emplois o2)->o1.getTitre().compareToIgnoreCase(o2.getTitre()));
    else
        list.sort((Emplois o1 ,Emplois o2)->o2.getTitre().compareToIgnoreCase(o1.getTitre()));
        return list; 
    }
}
