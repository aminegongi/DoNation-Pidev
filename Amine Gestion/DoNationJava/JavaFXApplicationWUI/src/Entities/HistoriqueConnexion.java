/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Objects;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author Amine Gongi
 */
public class HistoriqueConnexion {
    private int id;
    private int idUtilisateur;
    private String ipAdresse;
    private String dateCnx;

    public HistoriqueConnexion() {
    }
    
    
    public HistoriqueConnexion(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.dateCnx=null;
        /* Adresse IP machine
        try {
            this.ipAdresse =InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            this.ipAdresse = "IP Prob" ;
        }
        */
        
        // Adresse IP Publique
        try
        { 
            URL url_name = new URL("http://bot.whatismyipaddress.com"); // ou http://checkip.amazonaws.com/
            BufferedReader bf = new BufferedReader(new InputStreamReader(url_name.openStream())); 
            this.ipAdresse = bf.readLine().trim(); 
        } 
        catch (Exception e) 
        { 
            this.ipAdresse = "IP Prob" ;
        } 
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIpAdresse() {
        return ipAdresse;
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }

    public String getDateCnx() {
        return dateCnx;
    }

    public void setDateCnx(String dateCnx) {
        this.dateCnx = dateCnx;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.idUtilisateur;
        hash = 29 * hash + Objects.hashCode(this.ipAdresse);
        hash = 29 * hash + Objects.hashCode(this.dateCnx);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistoriqueConnexion other = (HistoriqueConnexion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        if (!Objects.equals(this.ipAdresse, other.ipAdresse)) {
            return false;
        }
        if (!Objects.equals(this.dateCnx, other.dateCnx)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n"+"HistoriqueConnexion{" + "id=" + id + ", idUtilisateur=" + idUtilisateur + ", ipAdresse=" + ipAdresse + ", dateCnx=" + dateCnx + '}';
    }


    
    
    
}
