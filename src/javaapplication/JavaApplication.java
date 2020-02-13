/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Entities.cagnotte;
import Entities.categorie;
import Services.GestionnaireCagnotte;
import Services.GestionnaireCategorie;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
        cagnotte c = new cagnotte("SOS Marsas", 2, date_debut, date_fin, 5000, 0, 2);
        GestionnaireCagnotte gc= new GestionnaireCagnotte();
        gc.ajouterDemande(c);
        c.setId(1);
        c.setNom("SOS Sousse");
        //gc.modifierDemande(c);
        //gc.supprimerCagnotte(2);
        gc.validerDemande(c);
        gc.ajouterDon(c, 100);
        List<cagnotte> list = new ArrayList<>();
        list = gc.getCagnottes();
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
        
        categorie ct = new categorie("Maladie", "Les maladies");
        GestionnaireCategorie gct = new GestionnaireCategorie();
        gct.ajouterCategorie(ct);
        List<categorie> listct = new ArrayList<>();
        listct = gct.getCategories();
        for(int i = 0; i < listct.size(); i++){
            System.out.println(listct.get(i).toString());
        }
    }
    
}
