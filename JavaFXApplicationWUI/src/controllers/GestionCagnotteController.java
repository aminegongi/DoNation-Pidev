/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.cagnotte;
import Entities.categorieCagnotte;
import Services.GestionnaireCagnotte;
import Services.GestionnaireCategorie;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.color;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class GestionCagnotteController implements Initializable {
    @FXML
    private BorderPane border_pane;
    @FXML
    private StackPane stackSide;
    @FXML
    private Pane paneSide;
    boolean flag = false;
    @FXML
    private Pane stackSide2;
    @FXML
    private StackPane rootPaneM;
    private Pane paneHomePage;
    @FXML
    private Pane paneDetailCagnotte;
    @FXML
    private Pane paneFaireDon;
    @FXML
    private FlowPane paneListerCagnottes;
    @FXML
    private Button backToList;
    @FXML
    private ScrollPane paneListerCagnottesParent;
    @FXML
    private Label nom;
    @FXML
    private Label organisation;
    @FXML
    private Label proprietaire;
    @FXML
    private Label date_fin;
    @FXML
    private Label date_debut;
    @FXML
    private ProgressBar progress_bar;
    @FXML
    private Label montant_actuel;
    @FXML
    private Label montant_demande;
    @FXML
    private Button faire_un_don;
    private cagnotte selected_cagnotte = null;
    private boolean faire_don_initialized = false;
    private boolean ajouter_don_initialized = false;
    private JFXTextField montant;
    @FXML
    private Button valider;
    @FXML
    private CheckBox anon;
    @FXML
    private JFXTextField nom_field;
    @FXML
    private JFXTextField montant_field;
    @FXML
    private ChoiceBox<String> methode_field;
    @FXML
    private Button backToDetail;
    @FXML
    private Button ajouterCagnotteButton;
    @FXML
    private Pane paneAjouterCagnotte;
    @FXML
    private JFXTextField nom_field_ajout;
    @FXML
    private JFXTextField dd;
    @FXML
    private JFXTextField montant_actuel_field_ajout;
    @FXML
    private JFXTextField montant_demande_field_ajout;
    @FXML
    private ChoiceBox<String> cat;
    @FXML
    private JFXTextField dm;
    @FXML
    private JFXTextField dy;
    @FXML
    private JFXTextField fd;
    @FXML
    private JFXTextField fm;
    @FXML
    private JFXTextField fy;
    @FXML
    private Button ajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackSide2.setStyle("-fx-background-color: #F83F29;");
        paneListerCagnottes.setVisible(true);
        affichageCagnottes("alphabetique");
        
        
    }    

     @FXML
    private void OpenSidebar(MouseEvent event) {
        if(!flag){
            flag = true;
            stackSide.setPrefWidth(200);
            System.out.println("bye");
            paneSide.setVisible(true);
            paneSide.setStyle("-fx-background-color: #F83F29;");
            
            
        }

    }

    @FXML
    private void CloseSideBar(MouseEvent event) {
        if(flag){
            flag = false;
            paneSide.setVisible(false);
            System.out.println("Hye");
            stackSide.setPrefWidth(20);
            stackSide2.setStyle("-fx-background-color: #F83F29;");
          
        
        }
    }

    private void goToListerCagnottes(ActionEvent event) {
        paneDetailCagnotte.setVisible(false);
        paneListerCagnottesParent.setVisible(true);
        paneListerCagnottes.setVisible(true);        
    }
    
    private void affichageCagnottes(String trieType){

        GestionnaireCagnotte gc = new GestionnaireCagnotte();
        List<cagnotte> list = new ArrayList<>();
        //list = null;
        list = gc.getCagnottes();
          
          //afficher que les demandes non signalées
          //listDmnd = serDmnd.readNotSign();
          //listDmnd = serDmnd.readNotSignSql();
          
          
          //comboBox choix trie demande  date d'ajout proche(nouvelles demandes)
          /*if(trieType.equals("alphabetique")){
                ListDemandeAide listDmndSorted = null;
                listDmndSorted =serDmnd.trierCatAlph(listDmnd);
                System.out.println(listDmndSorted);
                listDmnd = listDmndSorted;
          }*/
          
          //comboBox choix trie Categorie  date d'ajout lointaine(anciennes demandes)
          /*if(trieType.equals(ajoutDateProche)){
                ListCategorie listCatSorted = null;
                listCatSorted =serCat.trierCatOrdreAjtDec();
                System.out.println(listCatSorted);
                listCat = listCatSorted;
          }
              
          //comboBox choix trie Categorie  date lointaine  
          if(trieType.equals(ajoutDateLointaine)){
                ListCategorie listCatSorted = null;
                listCatSorted =serCat.trierCatOrdreAjtCroi();
                System.out.println(listCatSorted);
                listCat = listCatSorted;
          }*/
        ArrayList<Separator> as = new ArrayList();
        ArrayList<VBox> vbx = new ArrayList(); 
        
        for (int i = 0; i < list.size(); i++) {
            
            cagnotte c = list.get(i);
            
            //details sur user proprietaire du demande
            int id = c.getId();
            String nom = c.getNom();
            int id_categorie = c.getId_categorie();
            float montant_demande = c.getMontant_demande();
            float montant_actuel = c.getMontant_actuel();
            int id_proprietaire = c.getId_proprietaire();
            int id_organisation = c.getId_organisation();
            int etat = c.getEtat();
            
            //Separator vertical entre les categories
            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(44);
            h.setVisible(false);
            as.add(h);
            
            //Vbox container pour l'affichage d'une categorie
            VBox VBoxCat = new VBox();
            VBoxCat.setSpacing(5);
            //VBoxCat.setStyle("-fx-background-color:  #dddddd;");
            VBoxCat.getStyleClass().add("vboxcagnotte");
            VBoxCat.setAlignment(Pos.CENTER);
            VBoxCat.setPrefHeight(400);
            VBoxCat.setPrefWidth(280);

            Label nom_lab = new Label("Titre: " + nom);
            //nom_lab.getStyleClass().add("titrecagnote");
            Label categorie_lab = new Label("Categorie: " + id_categorie);
            Label montant_demande_lab = new Label("Montant demandé: " + montant_demande);
            Label montant_actuel_lab= new Label("Montant Achevé: " + montant_actuel);
            Label proprietaire_lab= new Label("Publié par: " + id_proprietaire);
            Label organisation = new Label("Organisation: " + id_organisation);
            Label etat_lab = new Label("Etat: " + etat);
            
            
            
            //separateur horizontal entre nom et bouttons
            Separator sh = new Separator(Orientation.HORIZONTAL);
            sh.setPrefHeight(80);
            sh.setVisible(false);
       
            //boutton preview Demande = btnpreview
            /*FileInputStream inputPreview = new FileInputStream(CUsersHediDocumentsNetBeansProjectsPlateformeAideFXsrcRessourcespreview.png);
            Image imagePreview = new Image(inputPreview);
            ImageView imageViewPreview = new ImageView(imagePreview);
            imageViewPreview.setFitHeight(20);
            imageViewPreview.setFitWidth(20);*/
            Button button_afficher = new Button("Afficher", null);
            button_afficher.setMaxSize(100, 200);
            button_afficher.setOnAction((event) -> {
            System.out.println("Button afficher");
            selected_cagnotte = c;
            goToDetailCagnotte();
            initializeDetailCagnotte();
            });
            
            
            //ajout des differents element representant une categorie dans un Vbox           
            VBoxCat.getChildren().add(nom_lab);
            VBoxCat.getChildren().add(categorie_lab);
            VBoxCat.getChildren().add(montant_demande_lab);
            VBoxCat.getChildren().add(montant_actuel_lab);
            VBoxCat.getChildren().add(proprietaire_lab);
            VBoxCat.getChildren().add(organisation);
            VBoxCat.getChildren().add(etat_lab);
            VBoxCat.getChildren().add(button_afficher);

            //vbx array contient les different Vbox(categories)
            vbx.add(VBoxCat);
            
            paneListerCagnottes.getChildren().add(vbx.get(i));
            
            
            paneListerCagnottes.getChildren().add(as.get(i));
            
            if (i == 0) {
                System.out.println(i=0);
            } else {
                if (((i + 1) %4) == 0) {
                    Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                    sepHoriz.setPrefWidth(1120);
                    sepHoriz.setPrefHeight(35);
                    sepHoriz.setPrefWidth(1400);
                    
                    sepHoriz.setVisible(false);
                    
                    paneListerCagnottes.getChildren().add(sepHoriz);
                    
                }
            }
        }
    }
    
    @FXML
    private void backToListButton(ActionEvent event) {
        paneDetailCagnotte.setVisible(false);
        paneAjouterCagnotte.setVisible(false);
        paneListerCagnottesParent.setVisible(true);
        paneListerCagnottes.setVisible(true);
    }

    @FXML
    private void backToDetailButton(ActionEvent event) {
        paneFaireDon.setVisible(false);
        paneDetailCagnotte.setVisible(true);
    }
    
    private void goToAjouterCagnotte(){
        paneListerCagnottesParent.setVisible(false);
        paneListerCagnottes.setVisible(false);
        paneAjouterCagnotte.setVisible(true);
    }
    
    private void goToDetailCagnotte(){
        paneListerCagnottesParent.setVisible(false);
        paneListerCagnottes.setVisible(false);
        paneDetailCagnotte.setVisible(true);
    }
    
    private void goToFaireDon(){
        paneDetailCagnotte.setVisible(false);
        paneFaireDon.setVisible(true);
    }
    
    private void initializeDetailCagnotte(){
        GestionnaireCagnotte gc = new GestionnaireCagnotte();
        cagnotte c = selected_cagnotte;
        nom.setText(c.getNom());
        organisation.setText(String.valueOf((c.getId_organisation())));
        proprietaire.setText(String.valueOf((c.getId_proprietaire())));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        date_debut.setText(df.format(c.getDate_de_debut()));
        date_fin.setText(df.format(c.getDate_de_fin()));
        montant_demande.setText(String.valueOf((c.getMontant_demande()) + " DT"));
        montant_actuel.setText(String.valueOf((c.getMontant_actuel()) + " DT"));
        progress_bar.setProgress((c.getMontant_actuel()/c.getMontant_demande()));
    }

    @FXML
    private void faire_un_don(ActionEvent event) {
        goToFaireDon();
        initializeFaireDon();
    }
    
    private void initializeFaireDon(){
        cagnotte c = selected_cagnotte;
        if(faire_don_initialized == false){
            methode_field.getItems().add("PayPal");
            faire_don_initialized = true;
        } 
    }

    private void initializeAjouterCagnotte(){
        if(ajouter_don_initialized == false){
            List<categorieCagnotte> l = new ArrayList<>();
            GestionnaireCategorie gcat = new GestionnaireCategorie();
            l = gcat.getCategories();
            for(int i=0; i<l.size(); i++){
                cat.getItems().add(l.get(i).getNom());
            }
            ajouter_don_initialized = true;
        } 
    }
    
    @FXML
    private void validerPaiement(ActionEvent event) {
        if (anon.isSelected()){
            cagnotte c = selected_cagnotte;
            GestionnaireCagnotte gc = new GestionnaireCagnotte();
            System.out.println("Montant: "+ montant_field.getText());
            gc.ajouterDon(c, "Anonyme", Float.parseFloat(montant_field.getText()), methode_field.getValue());
            
        }else{
            cagnotte c = selected_cagnotte;
            GestionnaireCagnotte gc = new GestionnaireCagnotte();
            System.out.println("Montant: "+ montant_field.getText());
            gc.ajouterDon(c, nom_field.getText(), Float.parseFloat(montant_field.getText()), methode_field.getValue());
        }
    }

    @FXML
    private void setAnon(ActionEvent event) {
        if (anon.isSelected()){
            nom_field.setDisable(true);
        }else{
            nom_field.setDisable(false);
        }
    }

    @FXML
    private void ajouterCagnotte(ActionEvent event) {
        goToAjouterCagnotte();
        initializeAjouterCagnotte();
    }

    @FXML
    private void valider_ajout_cagnotte(ActionEvent event) {
        GestionnaireCagnotte gc = new GestionnaireCagnotte();
        GestionnaireCategorie gct = new GestionnaireCategorie();
        Date date_debut = new Date(Integer.parseInt(dy.getText()) - 1900, Integer.parseInt(dm.getText()), Integer.parseInt(dd.getText()));
        Date date_fin = new Date(Integer.parseInt(fy.getText()) - 1900, Integer.parseInt(fm.getText()), Integer.parseInt(fd.getText()));
        int id_categorie = gct.getCategorieIdFromName(cat.getValue());
        System.out.println("Cat: " + id_categorie);
        cagnotte c = new cagnotte(nom_field_ajout.getText(), id_categorie, date_debut, date_fin, Float.parseFloat(montant_demande_field_ajout.getText()), Float.parseFloat(montant_actuel_field_ajout.getText()), 1);
        gc.ajouterDemande(c);
    }

}
