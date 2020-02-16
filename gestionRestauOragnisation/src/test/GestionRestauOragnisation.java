/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import gestionrestauoragnisation.entities.AppelAuDon;
import gestionrestauoragnisation.entities.OffreDon;
import gestionrestauoragnisation.entities.PubliciteRegion;
import gestionrestauoragnisation.entities.Publicité;
import gestionrestauoragnisation.service.AppelAuDonService;
import gestionrestauoragnisation.service.OffreDonService;
import gestionrestauoragnisation.service.PubliciteRegionService;
import gestionrestauoragnisation.service.PubliciteService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ahmed Fourati
 */
public class GestionRestauOragnisation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
       

        OffreDon o = new OffreDon("Titre","voici une desciption",sdf.format(date).toString(),3,1);
        OffreDon o1 = new OffreDon("TitreModif","modifiee","2021-02-09 14:18:34.00000",4,0);
        AppelAuDon o2 = new AppelAuDon("testEtat","voici une desciption2",sdf.format(date), 5, 5, 1);
        
        AppelAuDonService x = new AppelAuDonService() ; 
        OffreDonService ods = new OffreDonService () ;
        x.ajouter(o2);
//        x.supprimer(o2);
//        x.modifier(o2, 13);
        
       
//        System.out.println("offre don non trie " );
//        List<OffreDon> list= ods.afficher();
//        System.out.println(list);
//        System.out.println("offre don non trie");
//        List<OffreDon> list2= ods.trierParDate("cr");
//        System.out.println(list2);
//        
//        
//       
//       ods.modifier(o1, 12);
//        Publicité p = new Publicité("A","abcD","MarqueD",sdf.format(date));
//        p.setId(1);
//        PubliciteRegionService prs = new PubliciteRegionService();
//        PubliciteService ps = new PubliciteService() ; 
//        ps.ajouter(p);
//        ps.modifier(p, 1);
//        prs.ecrirePdf(p);
//        ps.supprimer(p);
//        prs.ecrirePdf(p);
        
        


    }
    
}
