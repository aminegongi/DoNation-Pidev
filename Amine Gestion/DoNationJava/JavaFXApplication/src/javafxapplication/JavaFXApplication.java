/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import Entities.*;
import Services.*;
import Utils.Adresse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


/**
 *
 * @author Amine Gongi
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        /*
        Administrateur ad= new Administrateur("amine", "amine@gmail.com", "azdaze", "dzdzada", "amine");
        Administrateur ad1= new Administrateur("rafraf", "amine@gmail.com", "azdaze", "dzdzada", "amine");
        GestionnaireAdministrateur gad=new GestionnaireAdministrateur();
        gad.ajouterAdmin(ad);
        System.out.println("-------------------------------");
        System.out.println(gad.fetchAdministrateurs());
        System.out.println("-------------------------------");
        gad.modifierAdmin(ad1, 3);
        gad.supprimerPersonne_I(1);
        System.out.println(gad.fetchAdministrateurs());
        */
        
        /*
        Date dd = new Date(2006, 2, 7);
        Utilisateur_Simple us = new Utilisateur_Simple("Gongi", "Homme", dd,"amine.googn@espritt.tn", "azaeazae", "azrazrza", "989899999", new Adresse("Tunisie", "Tunis"), "image", 121, 1, "eererzerzr", null, "Amine");
        GestionnaireUtilisateur_Simple gus = new GestionnaireUtilisateur_Simple();
        Utilisateur_Simple us1 = new Utilisateur_Simple("Gonoo", "Fomme", dd,"amine.gogn@t.tn", "abbbbbb", "rrrrrrr", "9819", new Adresse("Tie", "Tu"), "imagmme", 121, 1, "aaaaaaaaaaaaa", null, "Sedki");
        System.out.println("--------------------------");
        //gus.InscrireUS(us);
        //gus.supprimerUS_I(1);
        //gus.modifierUS(us1, 2);
        System.out.println("--------------------------");
        System.out.println(gus.fetchUS());
        //System.out.println(gus.fetchOneUS(3));
        //System.out.println(gus.checkMail("amine.googn@espritt.tn"));
        //System.out.println(gus.loginU("amine.googn@espritt.tn", "azaeazae"));
        */
        
        /*
        Organisation org = new Organisation("ORG12341", "fb.com/ORG", "sw.com/ORG", "AQZSS", 1, 2, "mail.com@om", "aaza", "aqqdfe21", "311212212", new Adresse("Tunisie", "Ghazella"), "image", 3211,1, "AZAZA1212121", null, "Org Enactus555");
        Organisation org1 = new Organisation("ORG98988", "fb.com/ORG1", "sw.com/ORG1", "AQZSS1", 99, (float) 987.6, "mail.com@om1", "aaza1", "aqqdfe21111", "3112122121", new Adresse("Tunisie1", "Ghazella1"), "image1", 321111,111, "AZAZA12121211", null, "Org Enactus");
        GestionnaireOrganisation gorg = new GestionnaireOrganisation();
        //gorg.InscrireORG(org);
        //System.out.println(gorg.fetchOrg());
        System.out.println(gorg.fetchOneOrg(8));
        gorg.modifierORG(org, 8);
        System.out.println(gorg.fetchOneOrg(8));
        */
        
        /*
        Entreprise ent = new Entreprise("ENT12341", "fb.com/ENT", "sw.com/ENT", "AQENT", 55, 42, "mail.com@ENT", "aazaENT", "aqqdfe21ENT", "311212212", new Adresse("Tunisie", "Ghazella"), "image", 3211,1, "AZAZA1212121ENT", null, "ENT MFC");
        Entreprise ent1 = new Entreprise("ENT999", "fb.com/ENT999", "sw.com/ENT999", "AQENT999", 99, 112, "mail.com@ENT999", "aazaENT999", "aqqdfe21ENT999", "311212212999", new Adresse("Tunisi999e", "999Ghazella"), "image999", 3211999,1999, "AZAZA1212121ENT999", null, "ENT MFC999");
        GestionnaireEntreprise gent = new GestionnaireEntreprise();
        gent.InscrireENT(ent);
        //gent.InscrireENT(ent);
        System.out.println(gent.fetchENT());
        System.out.println("--------------------------");
        System.out.println(gent.fetchOneENT(11));
        System.out.println("--------------------------");
        gent.modifierENT(ent1, 11);
        System.out.println(gent.fetchOneENT(11));
        */
        
        /*
        Restaurant res = new Restaurant((float) 9898.44, "fb.com/REST", "sw.com/REST", "AQREST", 52, 422, "mail.com@REST", "aazaREST", "aqqdfe21REST", "311212212", new Adresse("Tunisie", "Ghazella"), "image", 3211,1, "AZAZA1212121RESTENT", null, "REST MFC");
        Restaurant res1 = new Restaurant((float) 118.244, "fb.com/RESTREST", "sw.com/RESTREST", "AQRESTREST", 655, 142, "mail.com@REST", "aazaRESTREST", "aqqdfe21RESTREST", "311212212REST", new Adresse("TuniRESTsie", "GhaRESTzella"), "imaRESTge", 3211,1, "AZAZRESTA1212121REST", null, "RESTREST MFC");
        GestionnaireRestaurant gresto = new GestionnaireRestaurant();
        
        gresto.InscrireResto(res);
        gresto.InscrireResto(res);
        System.out.println(gresto.fetchResto());
        System.out.println("--------------------------");
        System.out.println(gresto.fetchOneResto(13));
        System.out.println("--------------------------");
        gresto.modifierResto(res1, 13);
        System.out.println(gresto.fetchOneResto(13));
        gresto.supprimerResto_I(14);
        System.out.println(gresto.fetchResto());
        
        //gresto.activerCompte(2);
        gresto.pointXp(2, -999998);
        
        int x=gresto.loginU("mail.com@ENT", "aazaENT");
        System.out.println(x);
        
        HashMap<String,Integer> hm = new HashMap<>();
        hm=gresto.nbCompteRole();
        System.out.println(hm);
        
        */
        
        HistoriqueConnexion hc = new HistoriqueConnexion(2);
        GestionnaireHistoriqueConnexion ghc=new GestionnaireHistoriqueConnexion();
        //ghc.AjouterHC(hc);
        System.out.println(ghc.fetchHC());
        System.out.println(ghc.fetchOneHC(3));
        

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
