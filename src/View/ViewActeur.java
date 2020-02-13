package View;

import Controller.ControllerActeur;
import Controller.ControllerListe;
import Controller.ControllerMenu;
import Dvdtheque.BDDManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewActeur {
    private Group root;
    private ViewHandler vhActeur;
    private Button btnBackMainP;
    private Label nom, prenom, image;
    private Text titreActeur;
    private VBox vBox;

    public ViewActeur(ViewHandler vhActeur, Group root) {
        this.root = root;
        this.vhActeur = vhActeur;

        btnBackMainP = initButton("Retour", 80, 600);
        titreActeur = iniTitre("Acteur", 550,200);

    }
    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().addAll(titreActeur);
        viewListe();
    }

    public void viewListe(){
        vBox = new VBox();

        ScrollPane scroll = new ScrollPane();

        BDDManager bdd = new BDDManager();
        bdd.start();

        ArrayList<ArrayList<String>> ListeFilm = bdd.ask("SELECT * FROM Dvdtheque.acteur ORDER BY Id_Acteur DESC");

        for (int i = 0; i < ListeFilm.size(); i ++) {
            Label nomActeur = new Label(ListeFilm.get(i).get(1));
            Label prenomActeur = new Label(ListeFilm.get(i).get(2));

            ImageView imageActeur = new ImageView("Assets/images/vin.jpg");

            System.out.println(ListeFilm);
            bdd.stop();
            nom = initLabel("Nom :",250, 470);
            prenom = initLabel("Prenom:", 250, 380);
            image = initLabel("Photo :",250,350);

            vBox.setLayoutX(350);
            vBox.setLayoutY(450);
            vBox.setAlignment(Pos.CENTER);
            VBox.setMargin(image, new Insets(30,0,0,0));
            VBox.setMargin(imageActeur, new Insets(0,0,0,30));

            imageActeur.setFitWidth(350);
            imageActeur.setFitHeight(450);
            imageActeur.setLayoutX(100);
            imageActeur.setLayoutY(100);
            image.setLayoutY(100);


            vBox.getChildren().addAll(nom,nomActeur, prenom,prenomActeur, image,imageActeur);

        }
        scroll.setContent(vBox);
        scroll.setPrefHeight(650);
        scroll.setPrefWidth(420);
        scroll.setLayoutX(550);
        scroll.setLayoutY(250);

        root.getChildren().add(scroll);
    }



    private Button initButton(String texteButton, int largeur, int hauteur) {
        Button b = new Button();
        b.setText(texteButton);
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.getStyleClass().add("btnStyle");
        b.setFont (Font.font ("Aclonica", 20));
        return b;
    }

    private Text iniTitre(String texteTitre, int largeur, int hauteur){
        Text ti = new Text();
        ti.setText(texteTitre);
        ti.setLayoutX(largeur);
        ti.setLayoutY(hauteur);
        ti.setFill(Color.BLACK);
        ti.setFont (Font.font ("Aclonica", 190));
        return ti;
    }
    private TextField initTextField(int largeur, int hauteur){
        TextField f = new TextField();
        f.setLayoutX(largeur);
        f.setLayoutY(hauteur);
        return f;
    }
    private Label initLabel(String texteLabel, int largeur, int hauteur  ){
        Label l = new Label();
        l.setLayoutX(largeur);
        l.setLayoutY(hauteur);
        l.setTextFill(Color.BLACK);
        l.setText(texteLabel);
        l.setFont (Font.font ("Aclonica", 20));
        return l;
    }

    public void setEvents(ControllerListe cm) {
        btnBackMainP.setOnMouseClicked(cm);
    }

    public void setEventsBack(ControllerActeur cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }

    //setter
    public void setNom(Label nom) { this.nom = nom; }
    public void setPrenom(Label prenom) { this.prenom = prenom; }
    public void setImage(Label image) { this.image = image; }


    //getter
    public Button getBtnBackMainP() { return btnBackMainP; }

    public Label getNom() { return nom; }
    public Label getPrenom() { return prenom; }
    public Label getImage() { return image; }



}
