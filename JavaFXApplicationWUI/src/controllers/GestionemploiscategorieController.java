/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Categorie_Emplois;
import Entities.*;
import Services.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.GatheringByteChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author heshem
 */
public class GestionemploiscategorieController implements Initializable {

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
    private TextField tfRecherche;
    @FXML
    private FlowPane flowPaneUsers;
    @FXML
    private ImageView btnBack;
    @FXML
    private TextField tfLibelle;
    @FXML
    private TextArea tfDesc;
    @FXML
    private Button btnAjouterCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      try {
          affichageUS();
      } catch (SQLException ex) {
          Logger.getLogger(GestionemploiscategorieController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    private void affichageUS() throws SQLException {
        flowPaneUsers.getChildren().clear();
        Categorie_EmploisService gUs = new Categorie_EmploisService();

        ArrayList<Categorie_Emplois> listUs = (ArrayList<Categorie_Emplois>) gUs.readAllCategorieEmplois();
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();

        for (int i = 0; i < listUs.size(); i++) {

            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(24);
            h.setVisible(false);
            as.add(h);

            VBox VBoxUser = new VBox();
            VBoxUser.setSpacing(5);
            VBoxUser.setStyle("-fx-background-color : #dddddd;");
            VBoxUser.setAlignment(Pos.CENTER);
            VBoxUser.setPrefHeight(262);
            VBoxUser.setPrefWidth(170);

            //Circle c = new Circle(35);

            /*try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:\\Users\\Amine Gongi\\Desktop\\Esprit 3A\\PIDEV\\DoNationJava\\JavaFXApplicationWUI\\src\\images\\DoNation.png"))));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DashbordAdmin_Users_USController.class.getName()).log(Level.SEVERE, null, ex);
            } */

            //VBoxUser.getChildren().add(c);

            Label nom = new Label("Titre : " + listUs.get(i).getTitre());
            Label prenom = new Label("Description: " + listUs.get(i).getDescription());
            //Label mail = new Label("Mail: " + listUs.get(i).getMail());
            //Label tel = new Label("téléphone: " + listUs.get(i).getNumTel());
            //Label etat = new Label();
            //Label adresse = new Label("Adresse: " + listUs.get(i).getAdresse().getVille() + "," + listUs.get(i).getAdresse().getPays());

            int id = listUs.get(i).getId_Categorie_Emplois();
            
            
            Button btnSupp = new Button("supp");
            btnSupp.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        gUs.deleteCategorieEmplois(id);
                        affichageUS();
                        System.out.println(id+"aazazaza");
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionemploiscategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            VBoxUser.getChildren().add(btnSupp);
//            ComboBox<String> actions = new ComboBox<>();
//            actions.setPromptText("Les Actions");
//
//            if (listUs.get(i).getEnabled() == 1) {
//                etat.setText("Etat: Activer");
//                actions.getItems().addAll("Voir Profil", "Désactiver", "Chat");
//            } else if (listUs.get(i).getEnabled() == 0) {
//                etat.setText("Etat: Désactiver");
//                actions.getItems().addAll("Voir Profil", "Activer", "Chat");
//            }
//            else if (listUs.get(i).getEnabled() == -1) {
//                etat.setText("Etat: Non Encore Activer");
//                actions.getItems().addAll("Voir Profil", "Activer", "Chat");
//            }
//            
//            Alert al = new Alert(Alert.AlertType.NONE);
//            ButtonType Oui = new ButtonType("Oui");
//            ButtonType Non = new ButtonType("Non");
//
//            al.getButtonTypes().addAll(Oui, Non);

//            actions.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    if (actions.getValue().equals("Voir Profil")) {
//                        System.out.println("Voir Profil " + id);
//                    } else if (actions.getValue().equals("Désactiver")) {
//                        al.setContentText("Vous Voulez vraiment désactiver le compte !");
//                        Optional<ButtonType> OuiNon = al.showAndWait();
//                        if (OuiNon.get() == Oui) {
//                            gUs.desactiverCompte(id);
//                            flowPaneUsers.getChildren().clear();
//                            affichageUS();
//                        }
//
//                    } else if (actions.getValue().equals("Activer")) {
//                        al.setContentText("Vous Voulez vraiment activer le compte !");
//                        Optional<ButtonType> OuiNon = al.showAndWait();
//                        if (OuiNon.get() == Oui) {
//                            gUs.activerCompte(id);
//                            flowPaneUsers.getChildren().clear();
//                            affichageUS();
//                        }
//                    }
//                    System.out.println(actions.getValue() + " ; " + id);
//
//                }
//            });
            
            VBoxUser.getChildren().add(nom);
            VBoxUser.getChildren().add(prenom);
//            VBoxUser.getChildren().add(mail);
//            VBoxUser.getChildren().add(etat);
//            VBoxUser.getChildren().add(adresse);
//            VBoxUser.getChildren().add(actions);

            vbx.add(VBoxUser);
            flowPaneUsers.getChildren().add(vbx.get(i));

            flowPaneUsers.getChildren().add(as.get(i));

            if (i == 0) {
                System.out.println("i=0");
            } else {
                if (((i + 1) % 3) == 0) {
                    Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                    sepHoriz.setPrefWidth(1120);
                    sepHoriz.setPrefHeight(35);
                    sepHoriz.setVisible(false);
                    flowPaneUsers.getChildren().add(sepHoriz);
                }
            }
        }
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
    private void BackToUser(MouseEvent event) {

        Pane newLoadedPane;
        try {
            newLoadedPane = FXMLLoader.load(getClass().getResource("/views/DashbordAdmin_Users.fxml"));
            rootPane.getChildren().clear();
            rootPane.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(UiLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajoutCat(ActionEvent event) {
        String l = tfLibelle.getText();
        String d = tfDesc.getText();
        Categorie_Emplois ce = new Categorie_Emplois(l, d);

        Categorie_EmploisService gEs = new Categorie_EmploisService();
      try {
          gEs.ajouterCategorieEmplois(ce);
          affichageUS();
      } catch (SQLException ex) {
          Logger.getLogger(GestionemploiscategorieController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
