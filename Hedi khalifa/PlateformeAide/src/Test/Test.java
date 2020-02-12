/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import Entite.Categorie;
import Entite.DemandeAide;
import Service.ServiceCategorie;
import Service.ServiceDemandeAide;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hedi
 */
public class Test {
    
        public static void main(String[] args) {
                ServiceDemandeAide serDmnd = new ServiceDemandeAide();
                DemandeAide d1 = new DemandeAide("demande id", "cest la  demande id");
                DemandeAide d2 = new DemandeAide("demande id new", "cest la  demande id new");
                DemandeAide d3 = new DemandeAide("demande enum", "cest la  demande enum");
                
                ServiceCategorie serCat = new ServiceCategorie();
                //Categorie c1 = new Categorie("Education");
                //Categorie c2 = new Categorie("learning");
                Categorie ca = new Categorie("acat");
                Categorie cb = new Categorie("bcat");
                Categorie cc = new Categorie("ccat");
                Categorie cz = new Categorie("zcat");
                
                

            try {
                
//***************************************TEST DEMANDE*****************************************
//serDmnd.ajouter(d1);
//serDmnd.delete(9);
//serDmnd.update(10, d2);
//List<DemandeAide> listDmnd = serDmnd.readAll();
//System.out.println(listDmnd);
//***************************************TEST DEMANDE*****************************************

//**************************************TEST CATEGORIE****************************************
//serCat.ajouter(c1);
//serCat.update(16, c2);
//serCat.delete(16);


/*serCat.ajouter(ca);
serCat.ajouter(cb);
serCat.ajouter(cc);*/
serCat.update(18, cz);
List<Categorie> listCat = serCat.readAll();
System.out.println(listCat);
System.out.println("trie****trie***trie");
List<Categorie> listCatTrie = serCat.trierCatAlph(listCat);
System.out.println(listCatTrie);
//**************************************TEST CATEGORIE****************************************

            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }
}
