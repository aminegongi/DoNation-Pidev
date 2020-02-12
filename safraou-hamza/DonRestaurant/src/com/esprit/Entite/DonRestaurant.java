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
public class DonRestaurant {
    private int idDon;
    private int idResto;
    private int idUser;
    private float montant;
    private Date date;
    
 public DonRestaurant(int idDon, int idResto, int idUser, float montant, Date date){
 this.idDon = idDon;
 this.idResto = idResto;
 this.idUser = idUser;
 this.montant = montant;
 this.date = date;
 } 
    
 public DonRestaurant(int idResto, int idUser, float montant, Date date){
 this.idResto = idResto;
 this.idUser = idUser;
 this.montant = montant;
 this.date = date;
 } 

 
 public void setIdDon(int idDon){
    this.idDon = idDon;
 }
 
 public void setIdResto(int idResto){
    this.idResto = idResto;
 }
 
 public void setIdUser(int idUser){
    this.idUser = idUser; 
 }
 
 public void setMontant(float montant){
     this.montant = montant;
 }
 
 public void setDate(Date date){
     this.date = date;
 }
 
 public int getIdDon(){
     return idDon;
 }
 
 public int getIdResto(){
     return idResto;
 }
 
 public int getIdUser(){
     return idUser;
 }
 
 public float getMontant(){
     return montant;
 }
 
 public Date getDate(){
     return date;
 }
 
    @Override
 public String toString(){
     return "IdDon : " + idDon + ", IdResto : " + idResto + ", IdUser : " + idUser + ", Montant : " + montant + ", Date : " + date +"\n"; 
 }
 
}
