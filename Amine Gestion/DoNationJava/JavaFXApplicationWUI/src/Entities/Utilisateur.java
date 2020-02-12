/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Objects;
import Utils.Adresse;
import java.sql.Timestamp;
import java.util.UUID;
/**
 *
 * @author Amine Gongi
 */
public class Utilisateur {

    protected int id;
    protected String mail;
    protected String mdp;
    protected String salt;
    protected String numTel;
    protected Adresse adresse;
    protected String image;
    protected int pointXP;
    protected int enabled;
    protected String confirmation_token;
    protected Date password_requested_at;

    protected String nom;

    public Utilisateur() {
    }

    public Utilisateur(String mail, String mdp, String salt, String nom) {
        this.mail = mail;
        this.mdp = mdp;
        this.salt = salt;
        this.nom = nom;
    }

    public Utilisateur(int id, String mail, String mdp, String salt, String numTel, Adresse adresse, String image, int pointXP, int enabled, String confirmation_token, Date password_requested_at, String nom) {
        this.id = id;
        this.mail = mail;
        this.mdp = mdp;
        this.salt = salt;
        this.numTel = numTel;
        this.adresse = adresse;
        this.image = image;
        this.pointXP = pointXP;
        this.enabled = enabled;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.nom = nom;
    }
    
    public Utilisateur(String mail, String mdp, String salt, String numTel, Adresse adresse, String image, int pointXP, String nom) {
        this.mail = mail;
        this.mdp = mdp;
        this.salt = salt;
        this.numTel = numTel;
        this.adresse = adresse;
        this.image = image;
        this.pointXP = pointXP;

        int enabled = -1;
        this.enabled = enabled;
        String confirmation_token = UUID.randomUUID().toString().substring(1, 6);
        this.confirmation_token = confirmation_token;
        Date password_requested_at=null;
        this.password_requested_at = password_requested_at;
        this.nom = nom;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPointXP() {
        return pointXP;
    }

    public void setPointXP(int pointXP) {
        this.pointXP = pointXP;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.mail);
        hash = 17 * hash + Objects.hashCode(this.mdp);
        hash = 17 * hash + Objects.hashCode(this.salt);
        hash = 17 * hash + Objects.hashCode(this.numTel);
        hash = 17 * hash + Objects.hashCode(this.adresse);
        hash = 17 * hash + Objects.hashCode(this.image);
        hash = 17 * hash + this.pointXP;
        hash = 17 * hash + this.enabled;
        hash = 17 * hash + Objects.hashCode(this.confirmation_token);
        hash = 17 * hash + Objects.hashCode(this.password_requested_at);
        hash = 17 * hash + Objects.hashCode(this.nom);
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        if (!Objects.equals(this.salt, other.salt)) {
            return false;
        }
        if (!Objects.equals(this.numTel, other.numTel)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (this.pointXP != other.pointXP) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.confirmation_token, other.confirmation_token)) {
            return false;
        }
        if (!Objects.equals(this.password_requested_at, other.password_requested_at)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", salt=" + salt + ", numTel=" + numTel + ", adresse=" + adresse + ", image=" + image + ", pointXP=" + pointXP + ", nom=" + nom + '}';
    }

}
