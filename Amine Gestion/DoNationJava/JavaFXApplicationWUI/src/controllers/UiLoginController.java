/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import Services.*;
import Entities.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amine Gongi
 */
public class UiLoginController implements Initializable {

    @FXML
    private Button btnCnx;
    @FXML
    private TextField txtMail;
    @FXML
    private PasswordField txtMdp;
    @FXML
    private Button FacebookSign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) {
        GestionnaireUtilisateur gu = new GestionnaireUtilisateur();
        int l = gu.loginU(txtMail.getText(), txtMdp.getText());
        Alert al = new Alert(Alert.AlertType.WARNING, "Compte désactiver , Call l'administrateur", ButtonType.OK);
        Alert al1 = new Alert(Alert.AlertType.WARNING, "Activer votre Compte Redirection ..", ButtonType.OK);
        Alert al2 = new Alert(Alert.AlertType.ERROR, "Invalid Mail ou Mot de Pass", ButtonType.OK);

        System.out.println(txtMail.getText());
        System.out.println("------------");
        System.out.println(txtMdp.getText());
        System.out.println("------------");
        System.out.println(l);
        System.out.println("------------");

        if (l == -1) {
            al2.showAndWait();
        } else if (l == -2) {
            al.showAndWait();
        } else if (l == -3) {
            al1.showAndWait();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/UIActivationCompte.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 380, 550);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {

            }
        } else {
            System.out.println("OK");
            String mail = txtMail.getText();
            String mdp = txtMdp.getText();

        }
        txtMail.clear();
        txtMdp.clear();

    }

}
