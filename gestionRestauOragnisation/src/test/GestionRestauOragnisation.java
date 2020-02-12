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
        OffreDon o1 = new OffreDon("Titre","voici une desciption","2021-02-09 14:18:34.00000",3,1);
       
        Publicité p = new Publicité("A","abc","Marque",sdf.format(date));
        p.setId(2);
        PubliciteRegionService prs = new PubliciteRegionService();
        prs.ecrirePdf(p);

    }
    
}
