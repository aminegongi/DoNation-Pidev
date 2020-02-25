/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Categorie;
import Entities.DemandeAide;
import Entities.StatCategorie;
import Services.ServiceCategorie;
import Services.ServiceDemandeAide;
import Services.ServiceStatCategorie;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Hedi
 */
public class DashbordAdmin_AideController implements Initializable {

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
    
    @FXML
    private Button btnGestCat;
    
    @FXML
    private Pane paneDerniereDmnd;
    @FXML
    private Pane paneDerniereCat;
    @FXML
    private ListView listViewStat;
    @FXML
    private Pane PaneStatCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.AfficherDerniereDmnd();
            this.afficherDerniereCat();
            this.afficherStatCat();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(DashbordAdmin_AideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void goToProfile(MouseEvent event) {
    }

    @FXML
    private void goToDash(ActionEvent event) {
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
    
    @FXML
    private void goToCategorie(ActionEvent event) {
             Pane newLoadedPane;
            try {
                newLoadedPane = FXMLLoader.load(getClass().getResource("/views/DashbordAdmin_Aide_Categorie.fxml"));
                rootPane.getChildren().clear();
                rootPane.getChildren().add(newLoadedPane);
            } catch (IOException ex) {
                //Logger.getLogger(UiLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void AfficherDerniereDmnd() throws SQLException{
        ServiceDemandeAide serDmnd = new ServiceDemandeAide();
        DemandeAide dmnd = serDmnd.derniereDmndAjout();
        //Recuperation des different attributs
        String titre = dmnd.getTitre();
        String description = dmnd.getDescription();
        String nbrReaction = Integer.toString(dmnd.getNbReactions());
        //Creation des label
        Label titreLbl = new Label("Titre: "+titre);
        Label descriptionLbl = new Label("Description: "+description);
        Label nbrReactionLbl = new Label("Nombre de reaction : "+nbrReaction);
        //Creation de container VBox
        VBox vBoxDmnd = new VBox();
        vBoxDmnd.setSpacing(5);
        vBoxDmnd.setStyle("-fx-background-color : #dddddd;");
        vBoxDmnd.setAlignment(Pos.CENTER);
        vBoxDmnd.setPrefHeight(262);
        vBoxDmnd.setPrefWidth(170);
        //Ajout attributs au container VBox
        vBoxDmnd.getChildren().add(titreLbl);
        vBoxDmnd.getChildren().add(descriptionLbl);
        vBoxDmnd.getChildren().add(nbrReactionLbl);
        paneDerniereDmnd.getChildren().clear();
        paneDerniereDmnd.getChildren().add(vBoxDmnd);
        
    }
    
    
    private void afficherDerniereCat() throws SQLException, FileNotFoundException{
        ServiceCategorie serCat = new ServiceCategorie();
        Categorie cat = serCat.derniereCatAjout();
        //Recuperation des different attributs
        String nom = cat.getNom();
        int id = cat.getId();
        

        //Creation des label
        Label nomLbl = new Label(nom);
        
 //boutton supprimer Categorie = btnSupp   
        System.out.println("C:/Users/Amine Gongi/Desktop/Esprit 3A/PIDEV/DoNationJava/JavaFXApplicationWUI/src/controllers/delete.png");
            FileInputStream inputSupp = new FileInputStream("C:/Users/Amine Gongi/Desktop/Esprit 3A/PIDEV/DoNationJava/JavaFXApplicationWUI/src/controllers/delete.png");
            Image imageSupp = new Image(inputSupp);
            ImageView imageViewSupp = new ImageView(imageSupp);
            imageViewSupp.setFitHeight(20);
            imageViewSupp.setFitWidth(20);
            Button btnSupp = new Button("Supprimer", imageViewSupp);
            btnSupp.setMaxSize(100, 200);
            btnSupp.setOnAction((event) -> {       
                        ButtonType oui = new ButtonType("Oui", ButtonBar.ButtonData.OK_DONE);
                        ButtonType non = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);
                        Alert alert = new Alert(Alert.AlertType.WARNING,"êtes-vous sûr de vouloir supprimer la categorie "+nom+" ?",oui,non);
                        alert.setTitle("Supprimer une categorie");
                        alert.showAndWait().ifPresent(type -> {
                                    if (type == oui) {
                                        System.out.println("btnSupp Action");
                                        try {
                                            this.supprimerCategorie(id);
                                            System.out.println("id cat a supp selectionée "+ id);
                                            //this.supprimerCategorie(70);
                                            Alert al = new Alert(Alert.AlertType.INFORMATION, "Categorie "+nom+" supprimée avec succès!", ButtonType.OK);
                                            al.show();
                                            System.out.println("supprimer ok!");
                                            this.afficherDerniereCat();
                                            
                                        }catch (SQLException | FileNotFoundException ex){
                                            Logger.getLogger(DashbordAdmin_Aide_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                                        } 
                                        }
                                        });
                                        });

            //boutton modifier Categorie = btnModif
            FileInputStream inputModif = new FileInputStream("C:/Users/Amine Gongi/Desktop/Esprit 3A/PIDEV/DoNationJava/JavaFXApplicationWUI/src/controllers/edit.png");
            Image imageModif = new Image(inputModif);
            ImageView imageViewModif = new ImageView(imageModif);
            imageViewModif.setFitHeight(20);
            imageViewModif.setFitWidth(20);
            Button btnModif = new Button("Modifier", imageViewModif);
            btnModif.setMaxSize(100, 200);
            btnModif.setOnAction((event) -> {
            System.out.println("Button Modif ");
            //fenetre apres click sur btnModif
            TextInputDialog dialog = new TextInputDialog(nom);
            dialog.setTitle("Modification d'une categorie");
            dialog.setHeaderText("Saisir un nouveau nom pour la categorie "+nom);
            dialog.setContentText("nouveau nom :");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nouvNom -> {
                                
                                try {
                                this.modifierCategorie(id,nouvNom);
                                Alert al = new Alert(Alert.AlertType.INFORMATION, "Categorie "+nom+" modifiée avec succès!", ButtonType.OK);
                                al.show();
                                System.out.println("Your name: " + nouvNom);
                                } catch (SQLException ex) {
                                Logger.getLogger(DashbordAdmin_Aide_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (FileNotFoundException ex) {
                                Logger.getLogger(DashbordAdmin_Aide_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                });
                                });            
            
            //separateur horizontal entre nom et bouttons
            Separator sh = new Separator(Orientation.HORIZONTAL);
            sh.setPrefHeight(80);
            sh.setVisible(false);            
            
        //Creation de container VBox
        VBox vBoxCat = new VBox();
        vBoxCat.setSpacing(5);
        vBoxCat.setStyle("-fx-background-color : #dddddd;");
        vBoxCat.setAlignment(Pos.CENTER);
        vBoxCat.setPrefHeight(262);
        vBoxCat.setPrefWidth(170);
        //Ajout attributs au container VBox
        vBoxCat.getChildren().add(nomLbl);
        vBoxCat.getChildren().add(sh);
        vBoxCat.getChildren().add(btnSupp);
        vBoxCat.getChildren().add(btnModif);
        paneDerniereCat.getChildren().clear();
        paneDerniereCat.getChildren().add(vBoxCat);
        
    }

    public void supprimerCategorie(int id) throws SQLException, FileNotFoundException{
        ServiceCategorie serCat = new ServiceCategorie();
        serCat.delete(id);
        paneDerniereCat.getChildren().clear();
        this.afficherDerniereCat();
        }
    
    public void modifierCategorie(int id,String nouvNom) throws SQLException, FileNotFoundException{
        ServiceCategorie serCat = new ServiceCategorie();
        Categorie cat = new Categorie(nouvNom);
        serCat.update(id,cat);
        paneDerniereCat.getChildren().clear();
        this.afficherDerniereCat();
        }


    public void afficherStatCat() throws SQLException{
    
        ServiceStatCategorie serStatCat = new ServiceStatCategorie();
        ServiceCategorie serCat = new ServiceCategorie();
        List<StatCategorie> listStatCat = serStatCat.nbrDmndAllCat(serCat.readAll());
        //ListView listViewStat = new ListView();
        listViewStat.getItems().addAll(listStatCat);
        
        PaneStatCat.getChildren().clear();
        PaneStatCat.getChildren().add(listViewStat);
        
        
    }
}
