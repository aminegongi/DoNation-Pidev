/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.DonRestaurant;
import com.esprit.Entite.TarifResto;
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
public class ServiceTarifResto implements IService<TarifResto> {

    private Connection con;
    private Statement ste;

    public ServiceTarifResto() {
        con = DataBase.getInstance().getConnection();

    }

   
    @Override
    public void ajouter(TarifResto t) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `PiDev`.`TarifResto` ( `idResto`, `tarif`) VALUES ( ?, ?);");
    pre.setInt(1, t.getIdResto());
    pre.setFloat(2, t.getTarif());
    pre.executeUpdate();
    }
            

    @Override
    public boolean delete(TarifResto t) throws SQLException {
        try{
        PreparedStatement pre=con.prepareStatement("DELETE FROM `PiDev`.`TarifResto` WHERE `idResto` = ? ;");
        pre.setInt(1, t.getIdResto());
        pre.execute();
    return true;
    }catch(SQLException Ex){
        System.out.println("erreur delete");
        return false;
        }
    }

    @Override
    public boolean update(TarifResto t) throws SQLException {
    try{
    PreparedStatement pre=con.prepareStatement("UPDATE `TarifResto` SET `tarif`=? WHERE `idResto` = ?;");
    pre.setFloat(1, t.getTarif());
    pre.setInt(2, t.getIdResto());
    pre.execute();
    return true;
        }catch(SQLException Ex){
            System.out.println("erreur update");
            return false;
        }
    }

    @Override
    public List<TarifResto> readAll() throws SQLException {
    List<TarifResto> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from TarifResto");
     while (rs.next()) {                
               int idResto=rs.getInt(1);
               float tarif=rs.getFloat(2);
               TarifResto t=new TarifResto(idResto, tarif);
     arr.add(t);
     }
    return arr;
    }
    
    
    
    
    
    //Métiers
    
    
    public boolean tarifExist(TarifResto t) throws SQLException{
        ResultSet rs=ste.executeQuery("select * from TarifResto WHERE `idResto` = '" + t.getIdResto() + "';");       
        if(rs.next()){
            return true;
        } else {
            return false;
        }
    }
}

