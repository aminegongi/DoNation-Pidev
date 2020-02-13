/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;

import com.esprit.Entite.RepasServi;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author safratix
 */
public class BrainStorming {
    
    
    private Connection con;
    private Statement ste;

    public BrainStorming() {
        con = DataBase.getInstance().getConnection();

    }
    
    public float selectPortefeuille(int idResto) throws SQLException{
        ResultSet rs=ste.executeQuery("select `portefeuilleVirtuel` from TarifResto WHERE `idResto` = '" + idResto + "';");
        rs.next();    
               float portefeuilleVirtuel=rs.getFloat(1);
               return portefeuilleVirtuel;
     
    }
    
    
    public float selectTarif(int idResto) throws SQLException{
        ResultSet rs=ste.executeQuery("select `tarif` from TarifResto WHERE `idResto` = '" + idResto + "';");
        rs.next();    
               float tarif=rs.getFloat(1);
               return tarif;
     
    }
    
    
     public float calculeNewPortefeuille (int idResto) throws SQLException{
         float pv;
         pv = selectPortefeuille(idResto);
         pv-= selectTarif(idResto);
         return pv;
    }
    
    public boolean RepasAservir(int idResto) throws SQLException{
         float pv;
         pv = selectPortefeuille(idResto);
         pv-= selectTarif(idResto);
         if (pv<0){
             return false;
         }else {
             return true;
         }
    }
    
}
