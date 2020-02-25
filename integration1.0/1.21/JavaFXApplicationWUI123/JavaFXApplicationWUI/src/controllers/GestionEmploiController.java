/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Categorie_Emplois;
import Entities.Emplois;
import Entities.Organisation;
import Services.EmploisService;
import Entities.Utilisateur;
import Entities.Utilisateur_Simple;
import Services.Categorie_EmploisService;
import Services.GestionnaireEntreprise;
import Services.GestionnaireOrganisation;
import Services.GestionnaireRestaurant;
import Services.GestionnaireUtilisateur;
import Services.GestionnaireUtilisateur_Simple;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Ahmed Fourati
 */
public class GestionEmploiController implements Initializable {

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
    private boolean flag;
    @FXML
    private TilePane tilePaneEmploi;
    @FXML
    private JFXButton allEmp;
    @FXML
    private JFXButton mesemploi;
    @FXML
    private JFXButton ajouteremploi;
     private VBox VBoxajout;
    String imagePublicite;
    
    
    Utilisateur UserConnect ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(HomeFXMLController.isUserRole); 
        UserConnect= UiLoginController.uh;
        
        System.out.println("$$$$$$$$$$$$$$$$ùùùùùùùùùùùùùùùùùùù$$$$$$$$$$$$$$$$$$$$$$");
        
        cemplacement.getItems().addAll("Ariana", "Tunis");
        ctypeemploi.getItems().addAll("Offre","Demande");
        ctypecontrat.getItems().addAll("ContratUniqueInsertion","ContratDureeIndeterminee");
        flag = false;
        stackSide2.setStyle("-fx-background-color: #F6E859;");
        VBoxajout=new VBox();
        affichageTtEmp();
    }

    private void affichageTtEmp() {
        //GestionnaireUtilisateur_Simple gUs = new GestionnaireUtilisateur_Simple();
        EmploisService gEmp = new EmploisService();
        ArrayList<Emplois> listEmp = null;
        try {
            listEmp = (ArrayList<Emplois>) gEmp.readAll1();
        } catch (SQLException ex) {
            Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<VBox> vbx = new ArrayList<>();

        for (int i = 0; i < listEmp.size(); i++) {
            HBox HboxEmp = new HBox();
            HboxEmp.setSpacing(3);
            HboxEmp.setStyle("-fx-background-color : #dddddd;");
            HboxEmp.setPrefHeight(200);
            HboxEmp.setPrefWidth(580);
            HboxEmp.setAlignment(Pos.CENTER);

            Rectangle r = new Rectangle(185, 185);

            try {
                String x=listEmp.get(i).getPhoto();
                r.setFill(new ImagePattern(new Image(new FileInputStream("src/imagesemplois/"+x))));
            } catch (FileNotFoundException ex) {

            }
            HboxEmp.getChildren().add(r);

            VBox VboxEmp = new VBox();
            VboxEmp.setAlignment(Pos.CENTER_LEFT);
            VboxEmp.setPrefHeight(160);
            VboxEmp.setPrefWidth(380);

            Label titre = new Label("Titre : " + listEmp.get(i).getTitre());
            Label emplacement = new Label("Emplacement : " + listEmp.get(i).getEmplacement());
            Label salaire = new Label("Salaire : " + listEmp.get(i).getSalaire());
            Label typedemploi = new Label("Type d'Emploi : " + listEmp.get(i).getTypeDemploi());
            Label typecontrat = new Label("Type De Contrat : " + listEmp.get(i).getTypeContrat());
            Label description = new Label("Description : " + listEmp.get(i).getDescreption());
            VboxEmp.getChildren().add(titre);
            VboxEmp.getChildren().add(emplacement);
            VboxEmp.getChildren().add(salaire);
            VboxEmp.getChildren().add(typedemploi);
            VboxEmp.getChildren().add(typecontrat);
            VboxEmp.getChildren().add(description);
            
           String maill =listEmp.get(i).getUser().getMail();
             
            /////////////////////////////////
             
            
            
              Button contacter = new Button("contacter");
            
       
            contacter.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try { 
//                         System.out.print(maill);
                    Desktop desktop;
                   if (Desktop.isDesktopSupported() 
                            && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
                                 URI mailto = new URI("mailto:"+maill+"?subject=Offre%20d'%20emploi%20sur%20la%20platforme%20DoNation");
                           desktop.mail(mailto);
                       } else {
  // TODO fallback to some Runtime.exec(..) voodoo?
                        throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
                         }
                    
                    
                    
                    
                    
                    
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }); 
            
            
              VboxEmp.getChildren().add(contacter);
            
            ////////////////////////////////
          
            HboxEmp.getChildren().add(VboxEmp);

            tilePaneEmploi.getChildren().add(HboxEmp);
        }
    }

    private void affichageTtEmpbyid() {
        //GestionnaireUtilisateur_Simple gUs = new GestionnaireUtilisateur_Simple();
        tilePaneEmploi.getChildren().clear();
        EmploisService gEmp = new EmploisService();
        ArrayList<Emplois> listEmp = null;
        try {
            listEmp = (ArrayList<Emplois>) gEmp.readAllbyid(UserConnect.getId());
        } catch (SQLException ex) {
            Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<VBox> vbx = new ArrayList<>();

        for (int i = 0; i < listEmp.size(); i++) {
            HBox HboxEmp = new HBox();
            HboxEmp.setSpacing(3);
            HboxEmp.setStyle("-fx-background-color : #dddddd;");
            HboxEmp.setPrefHeight(200);
            HboxEmp.setPrefWidth(580);
            HboxEmp.setAlignment(Pos.CENTER);

            Rectangle r = new Rectangle(185, 185);

            try {
                r.setFill(new ImagePattern(new Image(new FileInputStream("src/imagesemplois/"+listEmp.get(i).getPhoto()))));
            } catch (FileNotFoundException ex) {

            }
            HboxEmp.getChildren().add(r);

            VBox VboxEmp = new VBox();
            VboxEmp.setAlignment(Pos.CENTER_LEFT);
            VboxEmp.setPrefHeight(160);
            VboxEmp.setPrefWidth(380);

            TextField titre = new TextField(listEmp.get(i).getTitre());
            TextField emplacement = new TextField(listEmp.get(i).getEmplacement());
            TextField salaire = new TextField(listEmp.get(i).getSalaire()+"");
            TextField typedemploi = new TextField(listEmp.get(i).getTypeDemploi());
            TextField typecontrat = new TextField(listEmp.get(i).getTypeContrat());
            TextField description = new TextField(listEmp.get(i).getDescreption());
            
            int IdCategorie= listEmp.get(i).getIdCategorie();
            String photo=listEmp.get(i).getPhoto();
            Utilisateur user = new Utilisateur();
            int id=listEmp.get(i).getId();
            
            HBox hbBtn = new HBox();
            hbBtn.setAlignment(Pos.CENTER_RIGHT);
            Button btSupp = new Button("Supprimer");
            
            
            btSupp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        gEmp.delete(id);
                        affichageTtEmpbyid();
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            Button btModif = new Button("Modifier");
            
            btModif.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                       
                        Emplois emModif = new Emplois(titre.getText(),description.getText(),photo,Double.valueOf(salaire.getText()),emplacement.getText(),typedemploi.getText(),typecontrat.getText(),IdCategorie);
                        gEmp.update(emModif, id);
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            hbBtn.getChildren().addAll(btSupp,btModif);

            VboxEmp.getChildren().add(titre);
            VboxEmp.getChildren().add(emplacement);
            VboxEmp.getChildren().add(salaire);
            VboxEmp.getChildren().add(typedemploi);
            VboxEmp.getChildren().add(typecontrat);
            VboxEmp.getChildren().add(description);
            
            VboxEmp.getChildren().add(hbBtn);
            
            HboxEmp.getChildren().add(VboxEmp);

            tilePaneEmploi.getChildren().add(HboxEmp);
        }
    }

    @FXML
    private void OpenSidebar(MouseEvent event) {
        if (!flag) {
            flag = true;
            stackSide.setPrefWidth(200);
            System.out.println("bye");
            paneSide.setVisible(true);
            paneSide.setStyle("-fx-background-color: #F6E859;");
        }
    }

    @FXML
    private void CloseSideBar(MouseEvent event) {
        if (flag) {
            flag = false;
            paneSide.setVisible(false);
            System.out.println("Hye");
            stackSide.setPrefWidth(20);
            stackSide2.setStyle("-fx-background-color: #F6E859;");

        }
    }

    @FXML
    private void showAllEmp(ActionEvent event) {
        tilePaneEmploi.getChildren().clear();
        affichageTtEmp();
    }

    @FXML
    private void showembyid(ActionEvent event) {

        tilePaneEmploi.getChildren().clear();
        affichageTtEmpbyid();
    }
    
        
    
    
    
   
   
    
    //ajout 
    JFXTextField ttitre = new JFXTextField();
    JFXTextField tdescription = new JFXTextField();
//    JFXTextField tphoto = new JFXTextField();
//    JFXPasswordField tfPassword = new JFXPasswordField();
//    JFXPasswordField tfConfirmPassword = new JFXPasswordField();
     JFXTextField tsalaire = new JFXTextField();
    JFXComboBox<String> cemplacement = new JFXComboBox<>();
    JFXComboBox<String> ctypeemploi = new JFXComboBox<>();
    JFXComboBox<String> ctypecontrat = new JFXComboBox<>();
    JFXComboBox<String> cidcategorie = new JFXComboBox<>();
   
    
    
   
    
    
   
   

    /**
     * Initializes the controller class.
     */
 
   private void importerPubliciteImage(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser() ; 
//        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", listFichier));
        File f = fc.showOpenDialog(null);
        if(f !=null){
        
      //      publiciteImageCommentaire.setText("Image selectionnée"+f.getAbsolutePath());
             InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(new File(f.getAbsolutePath()));
//             System.out.println("Working Directory = " +
//              System.getProperty("user.dir"));
//            System.out.println("nomfichier"+f.getName());
            os = new FileOutputStream(new File("./src/imagesemplois/"+f.getName()));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            System.out.println("szzszas");
            
             
        } finally {
            is.close();
            os.close();
        }
           
              File file = new File("app/src/imagesemplois/"+f.getName());
//            System.out.println(file.toURI().toString());
            ImageView imagePublicitePreview = new ImageView();
            imagePublicitePreview.setImage(new Image(file.toURI().toString()));
            imagePublicite=f.getName() ; 
            System.out.println( imagePublicite);
        }
        //else if (f ==null){
          //  publiciteImageCommentaire.setText("Erreur chargement de l'image");
        //}
    }
   
    private void ajouter() throws SQLException {
          
        VBoxajout.getChildren().clear();
        VBoxajout.setSpacing(17);

        ttitre.setPromptText("Titre : ");
        ttitre.setLabelFloat(true);
        
        tdescription.setPromptText("desc : ");
        tdescription.setLabelFloat(true);
        
        Button btupload = new Button("upload");
        btupload.getStyleClass().add("btnHechem");
        
        btupload.setOnAction(new EventHandler<ActionEvent>() {
 
                @Override
                public void handle(ActionEvent event) {
                   
                    try {
                        importerPubliciteImage(event);
                    } catch (IOException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
    } );
//        tphoto.setPromptText("tphoto : ");
//        tphoto.setLabelFloat(true);
//        
        tsalaire.setPromptText("salaire : ");
        tsalaire.setLabelFloat(true);
        
         


        
        
        
        Categorie_EmploisService serCat = new Categorie_EmploisService();
        List<Categorie_Emplois> listCat = serCat.readAllCategorieEmplois();  
        List<String> listCatNom = new ArrayList<>();
       for (Categorie_Emplois cat : listCat) {
            listCatNom.add(cat.getTitre());
         }
         
         
         ComboBox cidcategorie = new ComboBox();
         ObservableList<String> catChoix = FXCollections.observableArrayList();
         catChoix.addAll(listCatNom);
         cidcategorie.setItems(catChoix);
         cidcategorie.setValue("choisir categorie");
        
//          cidcategorie.getItems().addAll(listt.get(i).getId_Categorie_Emplois(),+"");
        
    //            aa= aa.concat((listt.get(i).getTitre()));    
        
        VBoxajout.getStyleClass().add("vbxAdd");
         VBoxajout.setAlignment(Pos.CENTER);
        VBoxajout.getChildren().addAll(ttitre,tdescription,tsalaire,cemplacement,ctypeemploi,ctypecontrat,cidcategorie);
         VBoxajout.getChildren().add(btupload);  
        Button btajouter = new Button("ajouter");
        btajouter.getStyleClass().add("btnHechem");
         VBoxajout.getChildren().add(btajouter);
         
        tilePaneEmploi.getChildren().add(VBoxajout);
            btajouter.setOnAction(new EventHandler<ActionEvent>() {
 
                @Override
                public void handle(ActionEvent event) {
                   EmploisService serv = new EmploisService();
                   Categorie_EmploisService catserv = new Categorie_EmploisService();
                   Utilisateur user = new Utilisateur();
//                   String cat =cidcategorie;
                   Categorie_Emplois categ =new Categorie_Emplois("b","a");
                    try {
                        categ = catserv.readByName((String) cidcategorie.getValue());
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     int iddd=categ.getId_Categorie_Emplois();
                     System.out.println(iddd);
                     System.out.println("aaaaaaaaa");
                     System.out.println(iddd);
                   Emplois emp = new Emplois(ttitre.getText(),tdescription.getText(),imagePublicite,Double.valueOf(tsalaire.getText()),cemplacement.getValue(),ctypeemploi.getValue(),ctypecontrat.getValue(),iddd,UserConnect);
                   
                    //System.out.println(ttitre.getText()+tdescription.getText()+tphoto.getText()+Double.valueOf(tsalaire.getText())+cemplacement.getValue()+ctypeemploi.getValue()+ctypecontrat.getValue()+Integer.valueOf(cat)+"1111111111111111111111aa");
                  
                    try {
                        serv.ajouter(emp);
                    } catch (SQLException ex) {
                        Logger.getLogger(GestionEmploiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                
                }
                
    } );
                    

   
    }

    @FXML
    private void ajouteremploi(ActionEvent event) throws SQLException {
        
        tilePaneEmploi.getChildren().clear();
        ajouter();
    }
    
}
