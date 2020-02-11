/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Services.GestionnaireUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amine Gongi
 */
public class UIActivationCompteController implements Initializable {

    @FXML
    private TextField txtMail;
    @FXML
    private Button btnActivation;
    @FXML
    private TextField txtCodeAct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ActivationCompte(ActionEvent event) {
        GestionnaireUtilisateur gu = new GestionnaireUtilisateur();
        boolean ok = gu.activerCompteKeyMail(txtMail.getText(), txtCodeAct.getText());
        Alert al1 = new Alert(Alert.AlertType.CONFIRMATION, "Compte Activer Bravo", ButtonType.OK);
        Alert al2 = new Alert(Alert.AlertType.WARNING, "Invalide Mail ou Code d'activation", ButtonType.OK);

        if (ok) {
            al1.showAndWait();
        } else {
            al2.showAndWait();
        }
        txtMail.clear();
        txtCodeAct.clear();
    }

}
