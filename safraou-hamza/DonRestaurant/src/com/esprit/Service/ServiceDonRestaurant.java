/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.DonRestaurant;
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
    PreparedStatement pre=con.prepareStatement("INSERT INTO `PiDev`.`DonRestaurant` ( `idResto`, `idUser`, `montant`, `date`) VALUES ( ?, ?, ?, ?);");
    pre.setInt(1, d.getIdResto());
    pre.setInt(2, d.getIdUser());
    pre.setFloat(3, d.getMontant());
    pre.setDate(4, d.getDate());
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
    pre.setDate(3, d.getDate());
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
               Date date=rs.getDate(5);
               DonRestaurant d=new DonRestaurant(idDon, idResto, idUser, montant, date);
     arr.add(d);
     }
    return arr;
    }
}
