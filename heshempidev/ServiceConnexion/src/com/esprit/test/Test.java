/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Emplois;
import com.esprit.Service.EmploisService;
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
//        ServicePersonne ser = new ServicePersonne();
//        
//        Personne p1 = new Personne("sana", "ben fadhel", 10);
//        Personne p2 = new Personne("Karray", "Gargouri", 10);
//        
//        try {
////         
//            ser.ajouter1(p2);
//            ser.ajouter(p1);
//            List<Personne> list = ser.readAll();
//            System.out.println(list);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
        
        
         EmploisService serv = new EmploisService();
    Emplois e1=  new Emplois("heshem", "benfarhat", "hahaha", 500.2, "Tunis", "Offre", "ContratUniqueInsertion");
    Emplois e2=  new Emplois("louay", "yahyaoui", "lalalla", 55.6, "Ariana", "Offre", "ContratUniqueInsertion");
    try {
        serv.ajouter(e2);
        serv.ajouter(e1);
//        serv.update(e2,2);
        //serv.delete(1
             List<Emplois> list = serv.readAll();
            System.out.println(list);

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    }
    
}
