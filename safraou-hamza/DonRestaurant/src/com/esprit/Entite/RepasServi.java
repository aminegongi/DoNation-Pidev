/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author safratix
 */
public class RepasServi {
    private int idResto;
    private Date date;
    
    
    public RepasServi(int idResto, Date date){
        this.idResto = idResto;
        this.date = date;
    }
    
    public void setIdResto(int idResto){
        this.idResto = idResto;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public int getIdResto(){
        return idResto;
    }
    
    public Date getDate(){
        return date;
    }
    
    @Override
    public String toString(){
        return "IdResto : "+ idResto + ", Date : "+ date +"\n";
    }
    
    
}
