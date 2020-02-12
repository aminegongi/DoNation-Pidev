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
public class PubliciteRegion {
    int idPublicite; 
    String nomRegion;
    int nbClick ;

    public PubliciteRegion() {
    }

    public PubliciteRegion(int idPublicite, String nomRegion, int nbClick) {
        this.idPublicite = idPublicite;
        this.nomRegion = nomRegion;
        this.nbClick = nbClick;
    }

    public int getIdPublicite() {
        return idPublicite;
    }

    public void setIdPublicite(int idPublicite) {
        this.idPublicite = idPublicite;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getNbClick() {
        return nbClick;
    }

    public void setNbClick(int nbClick) {
        this.nbClick = nbClick;
    }

    @Override
    public String toString() {
        return "PubliciteRegion{" + "idPublicite=" + idPublicite + ", nomRegion=" + nomRegion + ", nbClick=" + nbClick + '}';
    }
    
}
