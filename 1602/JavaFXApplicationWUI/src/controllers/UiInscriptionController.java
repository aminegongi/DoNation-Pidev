/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.*;
import Services.*;
import Utils.Adresse;
import com.jfoenix.controls.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Amine Gongi
 */
public class UiInscriptionController implements Initializable {

    @FXML
    private JFXComboBox<String> CBType;
    private String role;
    @FXML
    private FlowPane Flowpane;
    @FXML
    private VBox VBoxInscri;
    @FXML
    private JFXButton btInscri;

    //US
    JFXTextField tfNom = new JFXTextField();
    JFXTextField tfPrenom = new JFXTextField();
    JFXTextField tfMail = new JFXTextField();
    JFXTextField tfTel = new JFXTextField();
    JFXPasswordField tfPassword = new JFXPasswordField();
    JFXComboBox<String> cbPays = new JFXComboBox<>();
    JFXTextField tfVille = new JFXTextField();
    JFXComboBox<String> cbGenre = new JFXComboBox<>();
    JFXDatePicker dateP = new JFXDatePicker();
    @FXML
    private StackPane stackInscri;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CBType.getItems().addAll("Utilisateur Simple", "Organisation", "Restaurant", "Entreprise");
    }

    @FXML
    private void choixType(ActionEvent event) {
        VBoxInscri.getChildren().clear();
        if (CBType.getValue().equals("Utilisateur Simple")) {

            tfNom.setPromptText("Votre Nom : ");
            tfNom.setLabelFloat(true);

            tfPrenom.setPromptText("Votre Prénom : ");
            tfPrenom.setLabelFloat(true);

            tfMail.setPromptText("Votre EMail : ");
            tfMail.setLabelFloat(true);

            tfPassword.setPromptText("Votre Password : ");
            tfPassword.setLabelFloat(true);

            tfTel.setPromptText("Votre Téléphone : ");
            tfTel.setLabelFloat(true);

            cbPays.getItems().addAll("Tunisie", "Maroc", "Italie", "France", "Malte");

            tfVille.setPromptText("Votre Ville : ");
            tfVille.setLabelFloat(true);

            cbGenre.getItems().addAll("Homme", "Femme");

            dateP.setPromptText("Vote Date d'anniversaire : ");

            ArrayList<Separator> ALsep = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Separator sp = new Separator(Orientation.HORIZONTAL);
                sp.setVisible(false);
                sp.setPrefHeight(122);
                ALsep.add(sp);
            }

            VBoxInscri.getChildren().add(tfNom);
            VBoxInscri.getChildren().add(ALsep.get(0));
            VBoxInscri.getChildren().add(tfPrenom);
            VBoxInscri.getChildren().add(ALsep.get(1));

            VBoxInscri.getChildren().add(tfMail);
            VBoxInscri.getChildren().add(ALsep.get(2));

            VBoxInscri.getChildren().add(tfPassword);
            VBoxInscri.getChildren().add(ALsep.get(3));
            VBoxInscri.getChildren().add(tfTel);
            VBoxInscri.getChildren().add(ALsep.get(4));
            VBoxInscri.getChildren().add(cbPays);
            VBoxInscri.getChildren().add(ALsep.get(5));
            VBoxInscri.getChildren().add(tfVille);
            VBoxInscri.getChildren().add(ALsep.get(6));
            VBoxInscri.getChildren().add(cbGenre);
            VBoxInscri.getChildren().add(ALsep.get(7));
            VBoxInscri.getChildren().add(dateP);
            //VBoxInscri.getChildren().addAll(tfNom,tfPrenom,tfMail,tfTel,cbPays,tfVille,cbGenre,dateP);
        } else {
            JFXTextField tf = new JFXTextField();
            tf.setText(CBType.getValue());
            tf.setDisable(true);
            VBoxInscri.getChildren().add(tf);
        }
    }

    @FXML
    private void Inscri(ActionEvent event) {
        if (CBType.getValue().equals("Utilisateur Simple")) {
            GestionnaireUtilisateur_Simple gus = new GestionnaireUtilisateur_Simple();
            if(!gus.checkMail(tfMail.getText())){
                Utilisateur_Simple us = new Utilisateur_Simple(tfPrenom.getText(), cbGenre.getValue(), Date.valueOf(dateP.getValue()), tfMail.getText(), tfPassword.getText(), "Bsalt", tfTel.getText(), new Adresse(cbPays.getValue(), tfVille.getText()), "image", 0, tfNom.getText());
            
                int X = gus.InscrireUS(us);
                Alert alV = new Alert(Alert.AlertType.CONFIRMATION, "Inscription Réussi , confirmer votre compte", ButtonType.OK);
                Alert alE = new Alert(Alert.AlertType.WARNING, "Echec Inscription", ButtonType.OK);
                if (X == 1) {
                    alV.showAndWait();
                    
                    /*
                    Pane newLoadedPane;
                    try {
                        newLoadedPane = FXMLLoader.load(getClass().getResource("/views/UiActivationCompte.fxml"));
                        stackInscri.getChildren().clear();
                        stackInscri.getChildren().add(newLoadedPane);
                    } catch (IOException ex) {
                        Logger.getLogger(UiLoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    */
                    
                } else {

                    alE.showAndWait();
                }
            }
            else{
                Alert alM = new Alert(Alert.AlertType.WARNING, "Mail existant", ButtonType.OK);
                alM.showAndWait();
            }
                
            
        } else {
            System.out.println("Bientôt !");

        }
    }

}
