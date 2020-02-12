/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author safratix
 */
public class TarifResto {
    private int idResto;
    private float tarif;
    
    public TarifResto(int idResto, float tarif){
        this.idResto = idResto;
        this.tarif = tarif;
    }
    
    public TarifResto(float tarif){
        this.tarif = tarif;
    }
    
    public void setIdResto(int idResto){
        this.idResto = idResto;
    }
    
    public void setTarif(float tarif){
        this.tarif = tarif;
    }
    
    public int getIdResto(){
        return idResto;
    }
    
    public float getTarif(){
        return tarif;
    }
    
    @Override
    public String toString(){
        return "IdResto : "+ idResto +", Tarif : "+ tarif +"\n" ; 
    }
    
    
}
