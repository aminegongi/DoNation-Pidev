/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrestauoragnisation.entities;

/**
 *
 * @author Ahmed Fourati
 */
public class Publicité {
    int id ;
    String titre ; 
    String description ;
    String marque ; 
    String dateAjout ; 

    public Publicité() {
    }

    public Publicité( String titre, String description,String marque , String dateAjout) {
       
        this.titre = titre;
        this.description = description;
        this.dateAjout = dateAjout;
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", marque=" + marque + ", dateAjout=" + dateAjout + '}';
    }

    
    
    
     
}
