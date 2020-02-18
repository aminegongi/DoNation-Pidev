/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import Entities.cagnotte;
import Entities.categorie;
import Entities.commentaire;
import Services.GestionnaireCagnotte;
import Services.GestionnaireCategorie;
import Services.GestionnaireCommentaire;
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
        Date date_debut = new Date(120,03,12);
        Date date_fin = new Date(2020,03,12);
        //cagnotte c = new cagnotte("TEST", 1, date_debut, date_fin, 2000, 0, 2);
        //GestionnaireCagnotte gc = new GestionnaireCagnotte();
        cagnotte c = new cagnotte("IAD", 1, date_debut, date_fin, 10000, 0, 3);
        GestionnaireCagnotte gc = new GestionnaireCagnotte();
        //gc.ajouterDemande(c);
        c.setId(10); //Tempo
        gc.supprimerCagnotte(10);
        //c.setId(22);
        //commentaire cm = new commentaire(25, 2, "This is a comment 55.");
        //GestionnaireCommentaire gcm = new GestionnaireCommentaire();
        //gcm.ajouterCommentaire(cm);
        //gc.validerDemande(c);
        //gc.ajouterDon(c, 5000);
        /*System.out.println("test");
        Date date_debut = new Date(2020,02,12);
        Date date_fin = new Date(2020,03,12);
        cagnotte c = new cagnotte("SOS Kram", 80, date_debut, date_fin, 5000, 0, 2);
        GestionnaireCagnotte gc= new GestionnaireCagnotte();
        gc.ajouterDemande(c);
        c.setId(1););
        gc.ajouterDon(c, 5000);
        /*System.out.println("test");
        Date date_debut = new Date(2020,02,12);
        Date date_fin = new Date(2020,03,12);

        gc.ajouterDon(c, 8000);
        c.setNom("SOS Sousse");
        //gc.modifierDemande(c);
        //gc.supprimerCagnotte(2);
        gc.validerDemande(c);
        gc.ajouterDon(c, 100);*/
        /*List<commentaire> list = new ArrayList<>();
        list = gcm.getCommentairesDeUtilisateur(1);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }*/
        /*
        categorie ct = new categorie("Maladie", "Les maladies");
        GestionnaireCategorie gct = new GestionnaireCategorie();
        gct.ajouterCategorie(ct);
        List<categorie> listct = new ArrayList<>();
        listct = gct.getCategories();
        for(int i = 0; i < listct.size(); i++){
            System.out.println(listct.get(i).toString());
        }*/
    }
    
}
