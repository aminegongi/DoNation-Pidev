/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Categorie;
import Entities.DemandeAide;
import Entities.Signalement;
import Entities.User;
import Entities.UserTest;
import Services.ServiceCategorie;
import Services.ServiceDemandeAide;
import Services.ServiceSignalement;
import Services.ServiceUser;
import Utils.Etat;
import Utils.RaisonSignale;
import Utils.Sms;
import static java.awt.SystemColor.text;
import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Hedi
 */
public class Front_Aide_AccueilController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private Button btnMesDmnd;
    @FXML
    private Button btnAjoutDmnd;
    @FXML
    private FlowPane flowPaneListeDmnd;
    @FXML
    private Label listeDmndAide;
    
    
    @FXML
    private StackPane stackSide;
    @FXML
    private Pane stackSide2;
    @FXML
    private Pane paneSide;
    boolean flag = false;
    
    @FXML
    private Pane opacityPane;
    
    @FXML
    private Pane descPane;
    @FXML
    private ScrollPane descScrollPane;
    @FXML
    private StackPane rootPaneM;
    @FXML
    private BorderPane border_pane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            opacityPane.setVisible(false);
            descPane.setVisible(false);
            btnMesDmnd.setVisible(false);
            this.affichageDemandes("none");
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(Front_Aide_AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stackSide2.setStyle("-fx-background-color: #F89843;");
    }    

    @FXML
    private void goToMesDmnd(ActionEvent event) {
        System.out.println("btn mes dmnd ok");
    }

    @FXML
    private void goToAjoutDmnd(ActionEvent event) throws SQLException {
        System.out.println("btn ajouter dmnd ok");
       // this.clearPane();
       this.afficheFormAjoutDmnd();
    }
    
    public void clearPane(){
    listeDmndAide.setVisible(false);
    flowPaneListeDmnd.setVisible(false);
    
    }
    
    
    public void AimeDmnd(int id) throws SQLException, FileNotFoundException{
    ServiceDemandeAide serDmnd = new ServiceDemandeAide();
    serDmnd.reagir(id);
    flowPaneListeDmnd.getChildren().clear();
    this.affichageDemandes("none");
    }
    
    //signale une demande, prend en param un objet signalement retourne par this.afficheFormSignale()
    public void signaleDmnd(Signalement sig) throws SQLException, FileNotFoundException{
    ServiceSignalement serSig = new ServiceSignalement();
    //Signalement sig = new Signalement(idDemande, idUser, raison, description);
    serSig.ajouter(sig);


    }
    
        private void affichageDemandes(String trieType) throws FileNotFoundException, SQLException {

        ServiceDemandeAide serDmnd = new ServiceDemandeAide();
        List<DemandeAide> listDmnd = null;
        try {
          
          //listDmnd = serDmnd.readAll();
          
          //afficher que les demandes non signalées
          //listDmnd = serDmnd.readNotSign();
          listDmnd = serDmnd.readNotSignSql();
          
          /*
          //comboBox choix trie demande : date d'ajout proche(nouvelles demandes)
          if(trieType.equals("alphabetique")){
                List<DemandeAide> listDmndSorted = null;
                listDmndSorted =serDmnd.trierCatAlph(listDmnd);
                System.out.println(listDmndSorted);
                listDmnd = listDmndSorted;
          }
          *//*
          //comboBox choix trie Categorie : date d'ajout lointaine(anciennes demandes)
          if(trieType.equals("ajoutDateProche")){
                List<Categorie> listCatSorted = null;
                listCatSorted =serCat.trierCatOrdreAjtDec();
                System.out.println(listCatSorted);
                listCat = listCatSorted;
          }*/
            /*  
          //comboBox choix trie Categorie : date lointaine  
          if(trieType.equals("ajoutDateLointaine")){
                List<Categorie> listCatSorted = null;
                listCatSorted =serCat.trierCatOrdreAjtCroi();
                System.out.println(listCatSorted);
                listCat = listCatSorted;
          }*/
          
        } catch (SQLException ex) {
            Logger.getLogger(DashbordAdmin_Aide_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();

        for (int i = 0; i < listDmnd.size(); i++) {
            
            DemandeAide dmnd = listDmnd.get(i);
            
            //details sur user proprietaire du demande
            int idUser = listDmnd.get(i).getIdUser();
            ServiceUser serUser = new ServiceUser();
            User  user = serUser.readById(idUser);
            String nomUser = user.getNom();
            String prenomUser = user.getPrenom();
            String mailUser = user.getMail();
            
            int idDmnd = listDmnd.get(i).getId();
            String TitreDmnd = listDmnd.get(i).getTitre();
            
            //Separator vertical entre les categories
            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(44);
            h.setVisible(false);
            as.add(h);
            
            //Vbox container pour l'affichage d'une categorie
            VBox VBoxCat = new VBox();
            //VBoxCat.setSpacing(5);
            //*******************************style modified**********************************************************************
            //VBoxCat.setStyle("-fx-background-color : #dddddd;");
            //VBoxCat.setStyle("-fx-border-radius: 30px;");
            //VBoxCat.getStyleClass().clear();
            VBoxCat.getStyleClass().add("vbox");
            
            VBoxCat.setAlignment(Pos.CENTER);
            //VBoxCat.setPrefHeight(262);
            VBoxCat.setPrefHeight(300);
           // VBoxCat.setPrefWidth(170);
           VBoxCat.setPrefWidth(350);

            //Label titre = new Label("Titre : " + listDmnd.get(i).getTitre());
            Label titreLbl = new Label(listDmnd.get(i).getTitre());
            titreLbl.getStyleClass().add("titre");
            //Label description
            Label descriptionLbl = new Label(listDmnd.get(i).getDescription());
            descriptionLbl.getStyleClass().add("desc");
            //Label publier par
            Label publierParLbl = new Label("Publiée par :");
            publierParLbl.getStyleClass().add("pbParLbl");
            //Label nomUser et prenomUser
            Label nomPrenomUserLbl = new Label(nomUser+" "+prenomUser);
            //Label mailUser
            Label mailUserLbl = new Label(mailUser);
            mailUserLbl.getStyleClass().add("mailLbl");
            //Label nombre reaction jaime
            Label nbrReactLbl = new Label("J'aime : "+listDmnd.get(i).getNbReactions());
            nbrReactLbl.getStyleClass().add("aimeLbl");
            
            
            
            //separateur horizontal entre nom et bouttons
            Separator sh = new Separator(Orientation.HORIZONTAL);
            sh.setPrefHeight(30);
            sh.setVisible(false);
            
            
            //boutton aime Demande = btnAime            
            FileInputStream inputAime = new FileInputStream("C:/Users/Amine Gongi/Desktop/Esprit 3A/PIDEV/DoNationJava/JavaFXApplicationWUI/src/Ressources/like.png");
            Image imageAime = new Image(inputAime);
            ImageView imageViewAime = new ImageView(imageAime);
            imageViewAime.setFitHeight(30);
            imageViewAime.setFitWidth(30);
            Button btnAime = new Button("", imageViewAime);
            btnAime.setTooltip(new Tooltip("J'aime"));
            btnAime.setMaxSize(100, 200);
            btnAime.setOnAction((event) -> { 
                try {
                    this.AimeDmnd(idDmnd);
                    System.out.println("Aime effectué");
                } catch (SQLException | FileNotFoundException ex) {
                    Logger.getLogger(Front_Aide_AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                }
                                         System.out.println("Aime prb");
                                         
                                        });
            
            //boutton preview Demande = btnpreview
            FileInputStream inputPreview = new FileInputStream("C:/Users/Amine Gongi/Desktop/Esprit 3A/PIDEV/DoNationJava/JavaFXApplicationWUI/src/Ressources/preview.png");
            Image imagePreview = new Image(inputPreview);
            ImageView imageViewPreview = new ImageView(imagePreview);
            imageViewPreview.setFitHeight(30);
            imageViewPreview.setFitWidth(30);
            Button btnPreview = new Button("", imageViewPreview);
            btnPreview.setTooltip(new Tooltip("Description"));
            btnPreview.setMaxSize(100, 200);
            btnPreview.setOnAction((event) -> {
            System.out.println("Button preview ");
            this.afficherDescriptionDmnd(dmnd);
                                });
            
          
            //boutton participate demande = btnPart
            FileInputStream inputPart = new FileInputStream("C:/Users/Amine Gongi/Desktop/Esprit 3A/PIDEV/DoNationJava/JavaFXApplicationWUI/src/Ressources/hands.png");
            Image imagePart = new Image(inputPart);
            ImageView imageViewPart = new ImageView(imagePart);
            imageViewPart.setFitHeight(30);
            imageViewPart.setFitWidth(30);
            //Button btnPart = new Button("Participer", imageViewPart);
            Button btnPart = new Button("", imageViewPart);
            btnPart.setTooltip(new Tooltip("Participer"));
            //btnPart.setMaxSize(100, 200);
           // btnPart.setMaxSize(300, 200);
            btnPart.setOnAction((event) -> {
            System.out.println("Button participate ");
                                });
            
            
            
            //ajout des differents element representant une categorie dans un Vbox           
            VBoxCat.getChildren().add(titreLbl);
            VBoxCat.getChildren().add(descriptionLbl);
            
            VBoxCat.getChildren().add(publierParLbl);
            VBoxCat.getChildren().add(nomPrenomUserLbl);
            VBoxCat.getChildren().add(mailUserLbl);
            
            VBoxCat.getChildren().add(nbrReactLbl);
            VBoxCat.getChildren().add(sh);
            
            HBox btnHBox = new HBox();
            btnHBox.getStyleClass().add("hbox");
            btnHBox.getChildren().add(btnAime);
            btnHBox.getChildren().add(btnPreview);
            btnHBox.getChildren().add(btnPart);
            btnHBox.setSpacing(10);
            btnHBox.setAlignment(Pos.CENTER);
            
            VBoxCat.getChildren().add(btnHBox);
            
            /*VBoxCat.getChildren().add(btnAime);
            VBoxCat.getChildren().add(btnPreview);
            VBoxCat.getChildren().add(btnPart);*/

            //vbx array contient les different Vbox(categories)
            vbx.add(VBoxCat);
            //***********************************************
            flowPaneListeDmnd.getChildren().add(vbx.get(i));
            
            //****************************************************
            flowPaneListeDmnd.getChildren().add(as.get(i));
            
            if (i == 0) {
                System.out.println("i=0");
            } else {
                //if (((i + 1) % 6) == 0) {
                if (((i + 1) % 3) == 0) {
                    Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                    //sepHoriz.setPrefWidth(1120);
                    sepHoriz.setPrefHeight(35);
                    sepHoriz.setPrefWidth(1400);
                    
                    sepHoriz.setVisible(false);
                    //******************************************
                    flowPaneListeDmnd.getChildren().add(sepHoriz);
                    
                }
            }
        }
    }
    
    
    //affiche description d'une demande et lien signaler apres click sur btn afficher 
    private void afficherDescriptionDmnd(DemandeAide dmnd){

    String desc = dmnd.getDescription();
    Text descTxt = new Text(desc);
    VBox descVbx = new VBox();
    descVbx.getChildren().add(descTxt);
    /*Alert alert = new Alert(Alert.AlertType.INFORMATION,desc,ButtonType.OK);
    alert.setHeaderText(dmnd.getTitre());      
    Hyperlink link = new Hyperlink("Signaler");
    TextFlow flow = new TextFlow(new Text(desc), link);
    alert.getDialogPane().contentProperty().set( flow );
    link.setOnAction( (evt) -> {
        this.afficheFormSignale(dmnd);
                alert.close();
                
    } );
    alert.showAndWait();*/
            opacityPane.setVisible(true);
            descPane.setVisible(true);
            //descScrollPane.setVisible(true);
            descScrollPane.setContent(descVbx);
            
    }
        
    //creer objet sig signalement apartir de formulaire et invoker la methode this.signaleDmnd(sig)
    //prend en param objet DemandeAide a signaler
     public void afficheFormSignale(DemandeAide dmnd){
         Dialog dialog = new Dialog();
         ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
         dialog.getDialogPane().getButtonTypes().add(cancelButton);
         dialog.setTitle("Signaler une demande");

         Pane paneForm = new Pane();
         //comboBox pour choisir la raison
         ComboBox raisonBox = new ComboBox();
         ObservableList<String> raisonChoix = FXCollections.observableArrayList("arnaque","haine","violence","autre");
         raisonBox.setItems(raisonChoix);
         raisonBox.setValue("raison de signalement");
         
         //texte area pour la description
         TextArea textDesc = new TextArea();
         
         //boutton signaler
         Button btnSignaler = new Button("Signaler");
         btnSignaler.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
        System.out.println("btnSignaler pressed");
        String raisonString = (String) raisonBox.getValue();
        //test sur raison
        RaisonSignale raison = toRaisonSignale( raisonString ) ;
        
        String description = textDesc.getText();
        System.out.println("raison signale: "+raison);
        System.out.println("description: "+description);
            //dialog.close();   
        Signalement sig = new Signalement (dmnd.getId(), UserTest.id, raison, description);
            try {
                signaleDmnd(sig);
                System.out.println("obj signalé avec succès: "+sig);
                Alert a = new Alert(AlertType.INFORMATION); 
                a.setHeaderText("Demande signalée, merci pour votre collaboration");
                a.show();
                dialog.close();
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(Front_Aide_AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                Alert a = new Alert(AlertType.ERROR); 
                a.setHeaderText("Vous avez deja signlé cette demande");
                a.show();
                dialog.close();
            }
        
            
        }
    });
        
        //VBox contient la formulaire
         VBox vb = new VBox();
         vb.getChildren().add(raisonBox);
         vb.getChildren().add(textDesc);
         vb.getChildren().add(btnSignaler);
         
         paneForm.getChildren().add(vb);
       
        dialog.getDialogPane().setContent(paneForm);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
        System.out.println("result present");
    }
                              
             
     }   
        
    
  public RaisonSignale toRaisonSignale(String str){
  RaisonSignale r = RaisonSignale.valueOf(str.toUpperCase());
  return r;
 }   
  
  
  public void ajouterDmnd(DemandeAide dmnd) throws SQLException{
  ServiceDemandeAide serDmnd = new ServiceDemandeAide();
  serDmnd.ajouter(dmnd);
  }
  
  
  
       public void afficheFormAjoutDmnd() throws SQLException{
         Dialog dialog = new Dialog();
         ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
         dialog.getDialogPane().getButtonTypes().add(cancelButton);
         dialog.setTitle("Ajouter une demande");

         Pane paneForm = new Pane();
         //comboBox pour choisir la categorie
         ServiceCategorie serCat = new ServiceCategorie();
         List<Categorie> listCat = serCat.readAll();
         List<String> listCatNom = new ArrayList<>();
         
         for (Categorie cat : listCat) {
            listCatNom.add(cat.getNom());
         }
         
         
         ComboBox catBox = new ComboBox();
         ObservableList<String> catChoix = FXCollections.observableArrayList();
         catChoix.addAll(listCatNom);
         catBox.setItems(catChoix);
         catBox.setValue("choisir categorie");
         
         //texte field pour le titre
         TextField fieldTitre = new TextField("saisir titre");
         
         //texte area pour la description
         TextArea textDesc = new TextArea("saisir description");
         
         //boutton signaler
         Button btnAjouter = new Button("Publier");
         btnAjouter.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
        
        String dmndCatNom = (String) catBox.getValue();
        Categorie catPourId = new Categorie();
            try {
                //pour recuperer l'id
                catPourId =  serCat.readByName(dmndCatNom);
               
            } catch (SQLException ex) {
                Logger.getLogger(Front_Aide_AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        int idCat = catPourId.getId();
        String description = textDesc.getText();
        String titre = fieldTitre.getText();
        
        System.out.println("categorie: "+fieldTitre);
        System.out.println("categorie: "+dmndCatNom);
        System.out.println("description: "+description);
            //dialog.close();   
        DemandeAide dmnd = new DemandeAide (idCat, 0, titre, description, Etat.VISIBLE, 0);
            try {
                ajouterDmnd(dmnd);
                System.out.println("dmnd ajoutée avec succès: "+dmnd);
                Alert a = new Alert(AlertType.INFORMATION); 
                a.setHeaderText("Demande ajoutée avec succès!");
                //**************************SMS******************SMS**********************************SMS************************SMS
                Sms sms = new Sms();
                sms.sendSms("votre demande a ete ajoutée avec succès");
                a.show();
                dialog.close();
                flowPaneListeDmnd.getChildren().clear();
                affichageDemandes("none");
                
            } catch (SQLException ex) {
                Logger.getLogger(Front_Aide_AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                Alert a = new Alert(AlertType.ERROR); 
                a.setHeaderText("probleme lors de l'ajout de  cette demande");
                a.show();
                dialog.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Front_Aide_AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
            
        }
        
    });
        
        //VBox contient la formulaire
         VBox vb = new VBox();
         vb.getChildren().add(catBox);
         vb.getChildren().add(fieldTitre);
         vb.getChildren().add(textDesc);
         vb.getChildren().add(btnAjouter);
         
         paneForm.getChildren().add(vb);
       
        dialog.getDialogPane().setContent(paneForm);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
        System.out.println("result present");
    }
                              
             
     }
       
       
       
    @FXML
    private void OpenSidebar(MouseEvent event) {
        if(!flag){
            flag = true;
            stackSide.setPrefWidth(200);
            System.out.println("bye");
            paneSide.setVisible(true);
            paneSide.setStyle("-fx-background-color: #F89843;");
            
            
        }

    }
    
    
    
    @FXML
    private void CloseSideBar(MouseEvent event) {
        if(flag){
            flag = false;
            paneSide.setVisible(false);
            System.out.println("Hye");
            stackSide.setPrefWidth(20);
            stackSide2.setStyle("-fx-background-color: # F89843;");
          
        
        }
    }
    
    
}
