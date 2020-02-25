/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Services.PubliciteRegionService;
import Services.PubliciteService;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import Entities.AppelAuDon;
import Entities.OffreDon;
import Entities.PublicationDon;
import Entities.PubliciteRegion;
import Entities.Publicité;
import Services.AppelAuDonService;
import Services.OffreDonService;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Ahmed Fourati
 */
public class GestionRestauOrgController implements Initializable {
    private int idUserConnecte;//  à changer avec intergration
    private String roleUser ; //  à changer avec intergration
     DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
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
    private ImageView pubImage1;
    private Label titirePub1;
    @FXML
    private Label idPub1;
    @FXML
    private ImageView pubImage2;
    @FXML
    private ImageView pubImage3;
    @FXML
    private Label titrePub1;
    @FXML
    private Label titrePub2;
    @FXML
    private Label idPub2;
    @FXML
    private Label titrePub3;
    @FXML
    private Label idPub3;
    @FXML
    private StackPane ajouterStackPane;
    @FXML
    private Label ajouterOfrreDemandeLabel;
    @FXML
    private TextField nbrePlatInput;
    @FXML
    private TextArea descpritionInput;
    @FXML
    private TextField titreInput;
    @FXML
    private Button ajouterPublicationDon;
    @FXML
    private StackPane ajouterStackPane1;
    @FXML
    private Label ajouterOfrreDemandeLabel1;
    @FXML
    private TextField nbrePlatInput1;
    @FXML
    private TextArea descpritionInput1;
    @FXML
    private TextField titreInput1;
    @FXML
    private Button ajouterPublicationDon1;
    @FXML
    private FlowPane FlowPanePublications;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flag = false ;
        
                   stackSide2.setStyle("-fx-background-color: #056F8B;");
                   afficherPublication();
        
                   idPub1.setVisible(false);
                   idPub2.setVisible(false);
                   idPub3.setVisible(false);
                   
                    roleUser = HomeFXMLController.isUserRole; 
                    System.out.println("roleeeeeee"+roleUser);
         idUserConnecte = UiLoginController.uh.getId(); // met 11 (user= oragnisation)
       
       ajouterStackPane1.setVisible(false);
        
        affichage();
        if(roleUser.equals("org")){
            ajouterOfrreDemandeLabel.setText("Appel au don");
            titreInput.setVisible(true);
            descpritionInput.setVisible(true);
            nbrePlatInput.setVisible(true);
            ajouterPublicationDon.setVisible(true);
        }
        else if(roleUser.equals("resto")){
        ajouterOfrreDemandeLabel.setText("Offre Don");
            titreInput.setVisible(true);
            descpritionInput.setVisible(true);
            nbrePlatInput.setVisible(false);
            ajouterPublicationDon.setVisible(true);
        }
        else{
          ajouterOfrreDemandeLabel.setVisible(false);
            titreInput.setVisible(false);
            descpritionInput.setVisible(false);
            nbrePlatInput.setVisible(false);
            ajouterPublicationDon.setVisible(false);  
        }
        
    }    

     @FXML
    private void OpenSidebar(MouseEvent event) {
        if(!flag){
            flag = true;
            stackSide.setPrefWidth(200);
            System.out.println("bye");
            paneSide.setVisible(true);
            paneSide.setStyle("-fx-background-color: #056F8B;");
            
            
        }

    }

    @FXML
    private void CloseSideBar(MouseEvent event) {
        if(flag){
            flag = false;
            paneSide.setVisible(false);
            System.out.println("Hye");
            stackSide.setPrefWidth(20);
            stackSide2.setStyle("-fx-background-color: #056F8B;");
          
        
        }
    }
    public void afficherPublication(){
        PubliciteService ps = new PubliciteService(); 
        List<Publicité> list = new ArrayList<>();
        list =ps.getAlea();
        System.out.println(list);
        titrePub1.setText(list.get(0).getTitre());
        idPub1.setText(Integer.toString(list.get(0).getId()));
        File file = new File("./src/images/"+list.get(0).getImage());
        System.out.println("./src/images/"+list.get(0).getImage());
        System.out.println("./src/images/"+list.get(1).getImage());
        System.out.println("./src/images/"+list.get(2).getImage());
        pubImage1.setImage(new Image(file.toURI().toString()));
        titrePub2.setText(list.get(1).getTitre());
        idPub2.setText(Integer.toString(list.get(1).getId()));
        File file2 = new File("./src/images/"+list.get(1).getImage());
        pubImage2.setImage(new Image(file2.toURI().toString()));
        
        
        idPub3.setText(Integer.toString(list.get(2).getId()));
            titrePub3.setText(list.get(2).getTitre());

        File file3 = new File("./src/images/"+list.get(2).getImage());
        pubImage3.setImage(new Image(file3.toURI().toString()));
        
    }

    @FXML
    private void traitementPublicite1(MouseEvent event) {
        PubliciteRegionService prs = new PubliciteRegionService();
        String city = prs.getIpAdressCity();
        String country = prs.getIpAdressCountry();
        
        System.out.println(city);
        System.out.println(country);
        prs.updateNbrClick(city, Integer.valueOf(idPub1.getText()));
        prs.updateNbrClickCountry(country, Integer.valueOf(idPub1.getText()));
        
        
    }

    @FXML
    private void traitementPublicite2(MouseEvent event) {
        PubliciteRegionService prs = new PubliciteRegionService();
        String city = prs.getIpAdressCity();
        String country = prs.getIpAdressCountry();
        System.out.println("2");
        System.out.println(city);
        prs.updateNbrClick(city, Integer.valueOf(idPub2.getText()));
         prs.updateNbrClickCountry(country, Integer.valueOf(idPub2.getText()));
    }

    @FXML
    private void traitementPublicite3(MouseEvent event) {
        PubliciteRegionService prs = new PubliciteRegionService();
        String city = prs.getIpAdressCity();
        String country = prs.getIpAdressCountry();
        System.out.println("3");
        System.out.println(city);
        prs.updateNbrClick(city, Integer.valueOf(idPub3.getText()));
                 prs.updateNbrClickCountry(country, Integer.valueOf(idPub3.getText()));

    }

    @FXML
    private void ajouterPublication(ActionEvent event) {
        
         
        PublicationDon p = new PublicationDon(titreInput.getText(), descpritionInput.getText(), sdf.format(date), 0, idUserConnecte);
        if(roleUser=="org" ){
            AppelAuDon ap = new AppelAuDon(titreInput.getText(), descpritionInput.getText(), sdf.format(date),0,idUserConnecte,Integer.parseInt(nbrePlatInput.getText()),1 );
            AppelAuDonService aps = new AppelAuDonService();
            aps.ajouter(ap);
        }
        else if(roleUser=="resto" )
        {
            OffreDon of = new OffreDon(titreInput.getText(), descpritionInput.getText(), sdf.format(date), 0,idUserConnecte, 1);
            
            OffreDonService os = new OffreDonService();
            os.ajouter(of);
         
        }
        
        
            FlowPanePublications.getChildren().remove(0, FlowPanePublications.getChildren().size());
        
        
        affichage();
    }

    @FXML
    private void modifierPublication(ActionEvent event) {
    }
     private void affichage() {
          FlowPanePublications.getChildren().remove(0, FlowPanePublications.getChildren().size());
           List<OffreDon> list;
       List<AppelAuDon> list2;
       
        ArrayList<PublicationDon> listX = new ArrayList<>();
       OffreDonService ods = new OffreDonService(); 
        AppelAuDonService x = new AppelAuDonService(); 
        list= ods.afficher();
        list2= x.afficher();
        listX.addAll(list);
        listX.addAll(list2);
        listX.sort((PublicationDon p1 , PublicationDon p2)->p2.getDatePublicaton().compareToIgnoreCase(p1.getDatePublicaton()));
//        System.out.println("taille listX"+ listX.size());
         for(int i=0 ; i<listX.size();i++){
             
             int etat; 
             if(listX.get(i).getClass()==OffreDon.class){
             OffreDon of = (OffreDon) listX.get(i); 
             etat = of.getEtat() ;
             }else{
             AppelAuDon of = (AppelAuDon) listX.get(i); 
             etat = of.getEtat() ;
             }
             
             if(etat==1){
        VBox vbox1 = new VBox() ; 
        vbox1.getStyleClass().add("vbox");
        vbox1.setSpacing(5);
            vbox1.setStyle("-fx-background-color : #DCDCDC;");
            vbox1.setOpacity(0.9);
            
//            vbox1.setAlignment(Pos.CENTER);
            vbox1.setPrefHeight(250);
            vbox1.setPrefWidth(500);
        HBox hbox1 = new HBox() ; 
            Circle c = new Circle(15);
            Label userName  = new Label() ;
            Label phone = new Label("29003723") ; // aporter module user 
            
                        hbox1.setAlignment(Pos.TOP_LEFT);

        Label titre  = new Label() ; 
        
        Label description  = new Label() ; 
                HBox hbox2 = new HBox() ;
//                                       hbox2.setAlignment(Pos.BOTTOM_LEFT);

                    //circle set image from data base
                userName.setText("@"+"Ahmed Fourati ");
                
                hbox1.getChildren().add(c);
                hbox1.getChildren().add(userName);
                hbox1.getChildren().add(phone);
                phone.setTranslateX(280);
                vbox1.getChildren().add(hbox1);
                titre.setText(listX.get(i).getTitre());
                titre.getStyleClass().add("titrePublication");
                description.setText(listX.get(i).getDescription());
                vbox1.getChildren().add(titre);
                vbox1.getChildren().add(description);
                Label dateAj = new Label(listX.get(i).getDatePublicaton());

                hbox2.getChildren().add(dateAj);
                
                
                if(listX.get(i).getAjoutePar()==idUserConnecte){
//                Button supprimerPublicationButton = new Button("Supprimer la publication") ; 
//                supprimerPublicationButton.setTranslateX(300);
//                hbox2.getChildren().add(supprimerPublicationButton);
                ComboBox<String> actions = new ComboBox<>();
                    actions.setPromptText("-");
                //ajouter une action 
                hbox2.getChildren().add(actions);
                actions.getItems().addAll("Modifer", "Supprimer");
                int id = listX.get(i).getId() ;
                Alert al = new  Alert(Alert.AlertType.INFORMATION);
         ButtonType Oui = new ButtonType("Oui");
         ButtonType Non = new ButtonType("Non");
         al.getButtonTypes().addAll(Oui,Non);
                actions.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        if(actions.getValue().equals("Supprimer")){
         System.out.println("id " + id  );
          al.setContentText("Vous Voulez vraiment désactiver le compte !");
         Optional<ButtonType> OuiNon = al.showAndWait();
         if(OuiNon.get() == Oui){
         AppelAuDon o = new AppelAuDon();
         o.setId(id);
         x.supprimer(o);
         affichage();
         }
         else
         System.out.println("good");
         
         }
                        if(actions.getValue().equals("Modifer")){
//                            ajouterStackPane.setVisible(false);
//                            ajouterStackPane1.setVisible(true);
//                            ajouterOfrreDemandeLabel1.setText("Modification");
//                            titreInput1.setText();
                            
                        }
                    }
                });
                
                
                
                }
                
                vbox1.getChildren().add(hbox2);
                FlowPanePublications.getChildren().add(vbox1);
                Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                    sepHoriz.setPrefWidth(500);
                    sepHoriz.setPrefHeight(35);
                    sepHoriz.setVisible(true);
                    FlowPanePublications.getChildren().add(sepHoriz);
         }
                }

        
        
    }
    
}
