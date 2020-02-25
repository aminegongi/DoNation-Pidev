/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Utilisateur_Simple;
import Services.GestionnaireHistoriqueConnexion;
import Services.GestionnaireUtilisateur;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Amine Gongi
 */
public class ProfilUserController implements Initializable {
    @FXML
    private StackPane rootPaneM;
    @FXML
    private BorderPane border_pane;
    @FXML
    private StackPane stackSide;
    @FXML
    private Pane stackSide2;
    @FXML
    private Pane paneSide;
    private boolean flag ;
    @FXML
    private Circle circleImage;
    @FXML
    private JFXButton btnChoisir;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private Hyperlink HyHistoCnx;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flag = false;
        //Utilisateur_Simple us = (Utilisateur_Simple) UiLoginController.uh ;
        nom.setText(UiLoginController.uh.getNom());
        prenom.setText(UiLoginController.uh.getNom());
    }    

     @FXML
    private void OpenSidebar(MouseEvent event) {
        if(!flag){
            flag = true;
            stackSide.setPrefWidth(200);
            System.out.println("bye");
            paneSide.setVisible(true);
        }

    }

    @FXML
    private void CloseSideBar(MouseEvent event) {
        if(flag){
            flag = false;
            paneSide.setVisible(false);
            System.out.println("Hye");
            stackSide.setPrefWidth(20);
        }
    }

    @FXML
    private void uploadPhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File");

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png","*.jpg"));

        File f=fileChooser.showOpenDialog(null);

        System.out.println(f.toURI().toString());

        String chemin = f.getPath();

        Image i= new Image(f.toURI().toString());
        
        circleImage.setFill(new ImagePattern(i));
        GestionnaireUtilisateur gu = new GestionnaireUtilisateur();
        gu.setImage(chemin, UiLoginController.uh.getId());
    }

    @FXML
    private void PrintHistoCnx(ActionEvent event) {
        GestionnaireHistoriqueConnexion ghc = new GestionnaireHistoriqueConnexion();
        ghc.RapportHCbyUser(UiLoginController.uh);
    }
    
}
