/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Emplois;
import com.esprit.IService.IServiceEmplois;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heshem
 */
public class EmploisService implements IServiceEmplois{

    
         private Connection con;
    private Statement ste;

    public EmploisService() {
        con = DataBase.getInstance().getConnection();

    }

     
     @Override
    public void ajouter(Emplois t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprita12`.`emplois` (`id`, `titre`, `description`, `Photo`,`salaire`,"+"`emplacement`,`TypeDemploi`,`TypeContrat`) VALUES (NULL, '"+ t.getTitre()+ "', '" + t.getDescreption()+ "', '" + t.getPhoto()+ "',"+ " '" + t.getSalaire()+ "', '" + t.getEmplacement()+ "', '" + t.getTypeDemploi()+ "', '" + t.getTypeContrat()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
    
    
    public void ajouter1(Emplois p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `esprita12`.`emplois` (`id`, `titre`, `description`, "
            + "`Photo`,`salaire`,"
                + "`emplacement`,`TypeDemploi`,`TypeContrat`) VALUES ( NULL,?, ?, ?,?,?,?,?);");
    pre.setString(1, p.getTitre());
    pre.setString(2, p.getDescreption());
    
    pre.setString(3, p.getPhoto());
    pre.setDouble(4, p.getSalaire());
    pre.setString(5, p.getEmplacement());
    pre.setString(6, p.getTypeDemploi());
    pre.setString(7, p.getTypeContrat());
    
    pre.executeUpdate();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("DELETE FROM `esprita12`.`emplois` where id =?");
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
               Emplois p=new Emplois(id, titre, description, photo, salaire, emplacement, TypeDemploi, TypeContrat);
     arr.add(p);
     }
    return arr;    }
    
    
}
