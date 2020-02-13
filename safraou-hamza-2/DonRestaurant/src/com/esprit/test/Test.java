/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.DonRestaurant;
import com.esprit.Entite.RepasServi;
import com.esprit.Entite.TarifResto;
import com.esprit.Service.ServiceDonRestaurant;
import com.esprit.Service.ServiceRepasServi;
import com.esprit.Service.ServiceTarifResto;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
   

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) {
 
        long millis=System.currentTimeMillis();
        java.sql.Timestamp date=new java.sql.Timestamp(millis);
   
        ServiceDonRestaurant ser = new ServiceDonRestaurant();
        ServiceRepasServi serRep = new ServiceRepasServi();
        ServiceTarifResto serTar = new ServiceTarifResto();
        
        DonRestaurant d1 = new DonRestaurant(65, 1, 1, (float) 3, date);
        DonRestaurant d2 = new DonRestaurant(21, 1, 1, (float) 7, date);
        DonRestaurant d3 = new DonRestaurant(10, 2, 1, (float) 7, date);
        DonRestaurant d4 = new DonRestaurant(11, 2, 1, (float) 4, date);
        
        RepasServi r1 = new RepasServi(1, date);
        RepasServi r2 = new RepasServi(2, date);
        
        TarifResto t1 = new TarifResto(1,(float) 5);
        TarifResto t2 = new TarifResto(4,(float) 2.7);
        TarifResto t3 = new TarifResto(2,(float) 2.4);
                
        
        try {
//         
            //Servir repas
            if (serRep.RepasAservir(r2.getIdResto()) == true){
            serRep.ajouter(r2);
            serRep.update(r2);
            }
           
            //serRep.ajouter(r1);
            //serRep.ajouter(r1);
            //serRep.ajouter(r2);
          // ser.ajouter(d2);
           //ser.updatePV(d2);
     /*       List<RepasServi> list = serRep.readAll();
            System.out.println(list);
            //serRep.RepasAservir(r1.getIdResto());
            List<RepasServi> list1 = serRep.readAll();
            System.out.println(list1);
     */      
           
           
           
           
            // Don Restaurant
            
            //ser.ajouter(d1);
            //ser.ajouter(d2);
            //ser.delete(d2);
           // ser.update(d2);
            //List<DonRestaurant> list = ser.readAll();
            //System.out.println(list);
            //ser.delete(d2);
            //System.out.println(list1);
          
            
            
            // Tarif Restaurant (existence)
            
            //serTar.ajouter(t1);
            //serTar.ajouter(t1);
            /* List<TarifResto> list1 = serTar.readAll();
            System.out.println(list1);
            serTar.ajouter(t1);
             List<TarifResto> list3 = serTar.readAll();
            System.out.println(list3);
            */
            
            
          /*  if (serTar.tarifExist(t2)){
                System.out.println("existe");
            } else {
                System.out.println("n'existe pas");
           } 
         */ 
          
          
          // test donation by resto
        /*
          serTar.ajouter(t3);
          ser.ajouter(d3);
          ser.updatePV(d3);
          ser.ajouter(d4);
          ser.updatePV(d4);
          List<DonRestaurant> list3 = ser.donationResto(2);
            System.out.println(list3);
        */
         
          
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
