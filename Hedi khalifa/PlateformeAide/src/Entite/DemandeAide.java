/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import Utils.Etat;



/**
 *
 * @author Hedi
 */
 /*enum Etat{
    VISIBLE,    //publiée sur la plateforme
    VALIDE,    //un utilisateur a participé a cette demande
    SIGNALEE  //un utilisateur a signalé  cette demande
}*/
public class DemandeAide {
    private int id;
    private String titre;
    private String description;
    private Etat etat=Etat.VISIBLE;
    private int nbParticipants;
    private int nbReactions;
    private int nbCommentaires;

    public DemandeAide(int id, String titre, String description, Etat etat, int nbParticipants, int nbReactions, int nbCommentaires) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.nbParticipants = nbParticipants;
        this.nbReactions = nbReactions;
        this.nbCommentaires = nbCommentaires;
    }

    public DemandeAide(String titre, String description) {
        this.titre = titre;
        this.description = description;
        this.etat = Etat.VISIBLE;
        this.nbParticipants = 0;
        this.nbReactions = 0;
        this.nbCommentaires = 0;
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

    public Etat getEtat() {
        return this.etat;
    }
    
    public String getEtatAsString() {
        return this.etat.name();
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    public int getNbReactions() {
        return nbReactions;
    }

    public void setNbReactions(int nbReactions) {
        this.nbReactions = nbReactions;
    }

    public int getNbCommentaires() {
        return nbCommentaires;
    }

    public void setNbCommentaires(int nbCommentaires) {
        this.nbCommentaires = nbCommentaires;
    }

    @Override
    public String toString() {
        return "DemandeAide{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", etat=" + etat + ", nbParticipants=" + nbParticipants + ", nbReactions=" + nbReactions + ", nbCommentaires=" + nbCommentaires + '}';
    }
         
}
