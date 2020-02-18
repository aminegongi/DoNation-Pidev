/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Ahmed
 */
public class commentaire {
    protected int id;
    protected int id_cagnotte;
    protected int id_utilisateur;
    protected String body;

    public commentaire() {
    }
    
    public commentaire(String body) {
        this.body = body;
    }
    
    public commentaire(int id_cagnotte, int id_utilisateur, String body) {
        this.id_cagnotte = id_cagnotte;
        this.id_utilisateur = id_utilisateur;
        this.body = body;
    }    
    
    public commentaire(int id, int id_cagnotte, int id_utilisateur, String body) {
        this.id = id;
        this.id_cagnotte = id_cagnotte;
        this.id_utilisateur = id_utilisateur;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cagnotte() {
        return id_cagnotte;
    }

    public void setId_cagnotte(int id_cagnotte) {
        this.id_cagnotte = id_cagnotte;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + this.id_cagnotte;
        hash = 89 * hash + this.id_utilisateur;
        hash = 89 * hash + Objects.hashCode(this.body);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final commentaire other = (commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_cagnotte != other.id_cagnotte) {
            return false;
        }
        if (this.id_utilisateur != other.id_utilisateur) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "comment{" + "id=" + id + ", id_cagnotte=" + id_cagnotte + ", id_utilisateur=" + id_utilisateur + ", body=" + body + '}';
    }
    
    
    
}
