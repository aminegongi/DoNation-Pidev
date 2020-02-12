/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.DonRestaurant;
import com.esprit.Entite.RepasServi;
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
public class ServiceRepasServi implements IService<RepasServi> {

    private Connection con;
    private Statement ste;

    public ServiceRepasServi() {
        con = DataBase.getInstance().getConnection();

    }

   
    @Override
    public void ajouter(RepasServi r) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `PiDev`.`RepasServi` ( `idResto`, `date`) VALUES ( ?, ?);");
    pre.setInt(1, r.getIdResto());
    pre.setDate(2, r.getDate());
    pre.executeUpdate();
    }
            

    @Override
    public boolean delete(RepasServi r) throws SQLException {
        try{
        PreparedStatement pre=con.prepareStatement("DELETE FROM `PiDev`.`RepasServi` WHERE `idResto` = ? AND `date` = ? ORDER BY `idResto` DESC LIMIT 1 ;");
        pre.setInt(1, r.getIdResto());
        pre.setDate(2, r.getDate());
        pre.execute();
    return true;
    }catch(SQLException Ex){
        System.out.println("erreur delete");
        return false;
        }
    }

    @Override
    public boolean update(RepasServi r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RepasServi> readAll() throws SQLException {
    List<RepasServi> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from RepasServi");
     while (rs.next()) {                
               int idResto=rs.getInt(1);
               Date date=rs.getDate(2);
               RepasServi r=new RepasServi(idResto, date);
     arr.add(r);
     }
    return arr;
    }
}
