/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Entities.cagnotte;
import Services.GestionnaireCagnotte;
import java.sql.Date;

/**
 *
 * @author Ahmed
 */
public class JavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("test");
        Date date_debut = new Date(2020,02,12);
        Date date_fin = new Date(2020,03,12);
        cagnotte c = new cagnotte("SOS Gammarth", date_debut, date_fin, 5000, 0, 2);
        GestionnaireCagnotte gc= new GestionnaireCagnotte();
        //gc.ajouterDemande(c);
        c.setId(1);
        c.setNom("SOS Sousse");
        //gc.modifierDemande(c);
        //gc.supprimerCagnotte(2);
        gc.validerCagnotte(c);
        gc.ajouterDon(c, 100);
    }
    
}
