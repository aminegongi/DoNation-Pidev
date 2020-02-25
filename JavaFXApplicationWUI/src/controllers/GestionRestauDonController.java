/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.*;
import Services.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static java.awt.Color.green;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;

/**
 * FXML Controller class
 *
 * @author Ahmed Fourati
 */
public class GestionRestauDonController implements Initializable {
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
    private JFXTextField txtMontant;
    @FXML
    private JFXButton btnDonner;
    @FXML
    private Label lblSolde;
    @FXML
    private JFXButton btnServir;
    
    int idResto = UiLoginController.uh.getId();
    
    @FXML
    private JFXTextField txtMail;
    @FXML
    private Label lblMessage;
    @FXML
    private Pane paneMessage;
    @FXML
    private JFXButton btnMessage;
    @FXML
    private Pane paneModifTarif;
    @FXML
    private Label lblModifTarif;
    @FXML
    private JFXButton btnModifTarif;
    @FXML
    private JFXButton btnTarif;
    @FXML
    private JFXButton btnAnnulerModifTarif;
    @FXML
    private JFXTextField txtTarif;
    @FXML
    private JFXButton btnAjouterTarif;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        stackSide2.setStyle("-fx-background-color: #2CB687;");
        paneMessage.setVisible(false);
        paneModifTarif.setVisible(false);
        
        //*****************init color solde******************************
         ServiceTarifResto serTar = new ServiceTarifResto();
         ServiceRepasServi serRep = new ServiceRepasServi();
        float solde = 0;
        try {
            if(serTar.tarifExist(idResto)==true){
            solde = serTar.selectPortefeuille(idResto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRestauDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblSolde.setText(String.valueOf(solde)+" Dinars");
        try {
            if (serRep.RepasAservir(idResto) == true){
                lblSolde.setStyle("-fx-background-color: #2cb687;");
            }else {
                lblSolde.setStyle("-fx-background-color: #FF0000;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRestauDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //**********************************************************************************
        //**********************************************************************************
    }    

     @FXML
    private void OpenSidebar(MouseEvent event) {
        if(!flag){
            flag = true;
            stackSide.setPrefWidth(200);
            System.out.println("bye");
            paneSide.setVisible(true);
            paneSide.setStyle("-fx-background-color: #2CB687;");
            
            
        }

    }

    @FXML
    private void CloseSideBar(MouseEvent event) {
        if(flag){
            flag = false;
            paneSide.setVisible(false);
            System.out.println("Hye");
            stackSide.setPrefWidth(20);
            stackSide2.setStyle("-fx-background-color: #2CB687;");
          
        
        }
    }

    @FXML
    private void Donner(ActionEvent event) throws SQLException {
        long millis=System.currentTimeMillis();
        java.sql.Timestamp date=new java.sql.Timestamp(millis);
        ServiceDonRestaurant serDon = new ServiceDonRestaurant();
        int idUser = serDon.getIdUserFromMail(txtMail.getText());
        float Montant = Float.parseFloat(txtMontant.getText());
        DonRestaurant d = new DonRestaurant(idResto, idUser, (float) Montant, date);
        serDon.ajouter(d);
        serDon.updatePV(d);
        //************************mettre à jour le Solde************************
        ServiceTarifResto serTar = new ServiceTarifResto();
        ServiceRepasServi serRep = new ServiceRepasServi();
        float solde = 0;
        try {
            solde = serTar.selectPortefeuille(idResto);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRestauDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblSolde.setText(String.valueOf(solde)+" Dinars");
        try {
            if (serRep.RepasAservir(idResto) == true){
                lblSolde.setStyle("-fx-background-color: #2cb687;");
            }else {
                lblSolde.setStyle("-fx-background-color: #FF0000;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRestauDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //**************************************************************************************
        //**************************************************************************************
        
        paneMessage.setVisible(true);
        lblMessage.setText("Donnation effectué !");
    }

    @FXML
    private void servir(ActionEvent event) throws SQLException {
        long millis=System.currentTimeMillis();
        java.sql.Timestamp date=new java.sql.Timestamp(millis);
        ServiceRepasServi serRep = new ServiceRepasServi();
        RepasServi r = new RepasServi(idResto, date);
        if (serRep.RepasAservir(idResto) == true){
            serRep.ajouter(r);
            serRep.update(r);
            paneMessage.setVisible(true);
            lblMessage.setText("Repas servi !");
            } else {
            //affichage de l'impossibilité de servir un repas
            paneMessage.setVisible(true);
            lblMessage.setText("Votre solde est insuffisant !");
        }
        //************************mettre à jour le Solde************************
        ServiceTarifResto serTar = new ServiceTarifResto();
        float solde = 0;
        try {
            solde = serTar.selectPortefeuille(idResto);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRestauDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblSolde.setText(String.valueOf(solde)+" Dinars");
        try {
            if (serRep.RepasAservir(idResto) == true){
                lblSolde.setStyle("-fx-background-color: #2cb687;");
            }else {
                lblSolde.setStyle("-fx-background-color: #FF0000;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRestauDonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //**************************************************************************************
        //**************************************************************************************
    }

    @FXML
    private void fermerPaneMessage(ActionEvent event) {
        paneMessage.setVisible(false);
        lblMessage.setText("");
        txtMontant.setText("");
        txtMail.setText("");
    }

    @FXML
    private void modifierTarif(ActionEvent event) throws SQLException {
        ServiceTarifResto serTar = new ServiceTarifResto();
        if (serTar.tarifExist(idResto)==true){
        TarifResto t =new TarifResto(idResto, Float.parseFloat(txtTarif.getText()));
        serTar.update(t);
        paneModifTarif.setVisible(false);
        txtTarif.setText("");
        } else {
            TarifResto t =new TarifResto(idResto, Float.parseFloat(txtTarif.getText()));
            serTar.ajouter(t);
            paneModifTarif.setVisible(false);
            txtTarif.setText("");
        }
        
    }

    @FXML
    private void activerModifTarif(ActionEvent event) throws SQLException {
        ServiceTarifResto serTar = new ServiceTarifResto();
        if (serTar.tarifExist(idResto)==false){
        btnAjouterTarif.setVisible(true);
        btnModifTarif.setVisible(false);
        } else {
            btnAjouterTarif.setVisible(false);
            btnModifTarif.setVisible(true);
        }
        paneModifTarif.setVisible(true);
    }

    @FXML
    private void annulerModifierTarif(ActionEvent event) {
        paneModifTarif.setVisible(false);
        txtTarif.setText("");
    }
    
    }


