/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrestauoragnisation.entities;

import gestionrestauoragnisation.entities.PublicationDon;

/**
 *
 * @author Ahmed Fourati
 */
public class OffreDon extends PublicationDon{
     private int etat ;
    public OffreDon(String titre, String description, String datePublicaton, int nbreUp , int etat ) {
        super(titre, description, datePublicaton, nbreUp);
        this.etat = etat ;
    }

    public OffreDon() {
        super();
    }

    

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        
//        return "OffreDon{" + super.toString() + "etat=" + etat + '}';
        return "OffreDon{" + super.toString() ;
    }
    
}
