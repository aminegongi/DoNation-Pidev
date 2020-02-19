/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Utilisateur;
import Services.GestionnaireAdministrateur;
import Services.GestionnaireEntreprise;
import Services.GestionnaireOrganisation;
import Services.GestionnaireRestaurant;
import Services.GestionnaireUtilisateur;
import Services.GestionnaireUtilisateur_Simple;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Amine Gongi
 */
public class DashbordAdmin_UsersController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private Circle btnImage;
    @FXML
    private Button btnDash;
    @FXML
    private Button btnUsers;
    @FXML
    private Button btnCagnote;
    @FXML
    private Button btnAide;
    @FXML
    private Button btnEmp;
    @FXML
    private Button btnRestoDon;
    @FXML
    private Button btnRestoOrg;
    @FXML
    private Button btnPub;
    @FXML
    private Button btnNews;
    private MenuButton btnFiltre;
    @FXML
    private Button btnUS;
    @FXML
    private Button btnOrg;
    @FXML
    private Button btnResto;
    @FXML
    private Button btnEnt;
    @FXML
    private PieChart PieNbCompteRole;
    @FXML
    private Pane mapUserIpR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GestionnaireUtilisateur gu = new GestionnaireUtilisateur();
        HashMap<String,Integer> CompteRole =gu.nbCompteRole();

        ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("Utilisateur Simple", CompteRole.get("us")),
                    new PieChart.Data("Organisation", CompteRole.get("org")),
                    new PieChart.Data("Restaurant", CompteRole.get("resto")),
                    new PieChart.Data("Entreprise", CompteRole.get("ent")));
        
        int totUser = CompteRole.get("us")+CompteRole.get("org")+CompteRole.get("resto")+CompteRole.get("ent");
        PieNbCompteRole.setData(pieChartData);
        PieNbCompteRole.getData().forEach(data -> {
            String percentage = String.format("%.1f%%", (data.getPieValue() / totUser));
            Tooltip toolTip = new Tooltip(percentage);
            Tooltip.install(data.getNode(), toolTip);
        });
    }

    @FXML
    private void goToProfile(MouseEvent event) {

    }

    @FXML
    private void goToDash(ActionEvent event) {
        Pane newLoadedPane;
        try {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/views/DashbordAdmin.fxml"));
            rootPane.getChildren().clear();
            rootPane.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(UiLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToUsers(ActionEvent event) {
    }

    @FXML
    private void goToCagnote(ActionEvent event) {
    }

    @FXML
    private void goToAide(ActionEvent event) {
    }

    @FXML
    private void goToEmp(ActionEvent event) {
    }

    @FXML
    private void goToRestoDon(ActionEvent event) {
    }

    @FXML
    private void goToRestoOrg(ActionEvent event) {
    }

    @FXML
    private void goToPub(ActionEvent event) {
    }

    @FXML
    private void goToNews(ActionEvent event) {
    }

    @FXML
    private void goToUs(ActionEvent event) {
        Pane newLoadedPane;
        try {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/views/DashbordAdmin_Users_US.fxml"));
            rootPane.getChildren().clear();
            rootPane.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(UiLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToOrg(ActionEvent event) {
    }

    @FXML
    private void goToResto(ActionEvent event) {
    }

    @FXML
    private void goToEnt(ActionEvent event) {
    }

}
