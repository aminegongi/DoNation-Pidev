/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.DonRestaurant;
import com.esprit.IService.BrainStorming;
import com.esprit.IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceDonRestaurant implements IService<DonRestaurant> {

    private Connection con;
    private Statement ste;

    public ServiceDonRestaurant() {
        con = DataBase.getInstance().getConnection();

    }

   
    @Override
    public void ajouter(DonRestaurant d) throws SQLException
    {
    
    PreparedStatement pre=con.prepareStatement("INSERT INTO `PiDev`.`DonRestaurant` ( `idDon`, `idResto`, `idUser`, `montant`, `date`) VALUES (?, ?, ?, ?, ?);");
    pre.setInt(1, d.getIdDon());
    pre.setInt(2, d.getIdResto());
    pre.setInt(3, d.getIdUser());
    pre.setFloat(4, d.getMontant());
    pre.setTimestamp(5, d.getDate());
    pre.executeUpdate();
    
    }
            

    @Override
    public boolean delete(DonRestaurant d) throws SQLException {
        try{
        PreparedStatement pre=con.prepareStatement("DELETE FROM `PiDev`.`DonRestaurant` WHERE `idDon` = ?;");
        pre.setInt(1, d.getIdDon());
        pre.execute();
    return true;
    }catch(SQLException Ex){
        System.out.println("erreur");
        return false;
        }
        
    }

    @Override
    public boolean update(DonRestaurant d) throws SQLException {
        try{
    PreparedStatement pre=con.prepareStatement("UPDATE `DonRestaurant` SET `idUser`=?,`montant`=?,`date`=? WHERE `idDon` = ?;");
    pre.setInt(1, d.getIdUser());
    pre.setFloat(2, d.getMontant());
    pre.setTimestamp(3, d.getDate());
    pre.setInt(4, d.getIdDon());
    pre.execute();
    return true;
        }catch(SQLException Ex){
            System.out.println("erreur update");
            return false;
        }
    }

    @Override
    public List<DonRestaurant> readAll() throws SQLException {
    List<DonRestaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from DonRestaurant");
     while (rs.next()) {                
               int idDon=rs.getInt(1);
               int idResto=rs.getInt(2);
               int idUser=rs.getInt(3);
               float montant=rs.getFloat(4);
               Timestamp date=rs.getTimestamp(5);
               DonRestaurant d=new DonRestaurant(idDon, idResto, idUser, montant, date);
     arr.add(d);
     }
    return arr;
    }
    
    
    
    public boolean updatePV(DonRestaurant d) throws SQLException {
        float nPV;
        boolean bienpasse = false;
      //  if ((selectPortefeuille(d) >= selectTarifExist(d.getIdResto())) && (selectTarifExist(d.getIdResto()) != -1) ){
        //    System.out.println("erreur recherche");
          //  return false;
       // } else {
      
        nPV = selectPortefeuille(d) + d.getMontant();
        
        
    PreparedStatement pre=con.prepareStatement("UPDATE `PiDev`.`TarifResto` SET `portefeuilleVirtuel`=? WHERE `idResto` = ?;");
    pre.setFloat(1, nPV);
    pre.setInt(2, d.getIdResto());
    pre.execute();
    bienpasse = true;
    return bienpasse;
        
        
 //       }
}

    
    
    //métier
    
    
    
    public float selectPortefeuille(DonRestaurant d) throws SQLException{
      
    ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select `portefeuilleVirtuel` from TarifResto WHERE `idResto` = '" + d.getIdResto() + "';");
        if (rs.next()){    
               float portefeuilleVirtuel=rs.getFloat(1);
               return portefeuilleVirtuel;
        }else {
            return -1;
        }
        
    }
    
    
    
     public boolean tarifExist(int idResto) throws SQLException{
        ResultSet rs=ste.executeQuery("select * from TarifResto WHERE `idResto` = '" + idResto + "';");       
        if(rs.next()){
            return true;
        } else {
            return false;
        }
    }
    
    
    public float selectTarifExist(int idResto) throws SQLException{
      if (tarifExist(idResto)==true){
        
        ResultSet rs=ste.executeQuery("select `tarif` from TarifResto WHERE `idResto` = '" + idResto + "';");       
        rs.next();
            float tarif = rs.getFloat(1);
            return tarif;
        
      } else {
          return -1;
      }
    }
   
    
    
     public float calculeNewPortefeuille (DonRestaurant d) throws SQLException{
         float pv;
         pv = selectPortefeuille(d);
         return pv;
    }
     
     
     //afficher la liste des restaurants auquel un utilisateur a fait une donation
     
     public List<DonRestaurant> donationUser(int idUserR) throws SQLException {
    List<DonRestaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from DonRestaurant WHERE `idUser` = '" + idUserR + "';" );
     while (rs.next()) {                
               int idDon=rs.getInt(1);
               int idResto=rs.getInt(2);
               int idUser=rs.getInt(3);
               float montant=rs.getFloat(4);
               Timestamp date=rs.getTimestamp(5);
               DonRestaurant d=new DonRestaurant(idDon, idResto, idUser, montant, date);
     arr.add(d);
     }
    return arr;
    }
     
     //afficher la liste des utilisateurs qui ont donné à un restaurant
     
      public List<DonRestaurant> donationResto(int idRestoR) throws SQLException {
    List<DonRestaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from DonRestaurant WHERE `idResto` = '" + idRestoR + "';" );
     while (rs.next()) {                
               int idDon=rs.getInt(1);
               int idResto=rs.getInt(2);
               int idUser=rs.getInt(3);
               float montant=rs.getFloat(4);
               Timestamp date=rs.getTimestamp(5);
               DonRestaurant d=new DonRestaurant(idDon, idResto, idUser, montant, date);
     arr.add(d);
     }
    return arr;
    }
      
}
