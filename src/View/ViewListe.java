package View;

import Controller.ControllerFilm;
import Controller.ControllerListe;
import Controller.ControllerMenu;
import Dvdtheque.BDDManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

import java.util.ArrayList;

public class ViewListe {
    private Group root;
    private ViewHandler vhListe;
    private Button btnBackMainP;
    private Label  Titre, annee, image,resume, note;
    private Text titreFilm;
    private VBox vBox;


    public ViewListe(ViewHandler vhListe, Group root) {
        this.root = root;
        this.vhListe = vhListe;

        btnBackMainP = initButton("retour",80,800);

        titreFilm = iniTitre("Film",550, 200);



    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().addAll(titreFilm);
        viewListe();
    }
    public void viewListe(){
            vBox = new VBox();
            ScrollPane scroll = new ScrollPane();
            BDDManager bdd = new BDDManager();
            bdd.start();

        ArrayList<ArrayList<String>> ListeFilm = bdd.ask("SELECT * FROM Dvdtheque.film ORDER BY Id_Film DESC");

        for (int i = 0; i < ListeFilm.size(); i ++) {
            Label nomFilm = new Label(ListeFilm.get(i).get(1));
            Label anneeFilm = new Label(ListeFilm.get(i).get(2));
            Label noteFilm = new Label(ListeFilm.get(i).get(3));
            TextArea resumeFilm = new TextArea(ListeFilm.get(i).get(4));
            ImageView imageFilm = new ImageView("Assets/images/Films/30couleur.jpg");

            System.out.println(ListeFilm);
            bdd.stop();
            Titre = initLabel("Titre film :",250, 470);

            annee = initLabel("Année :", 250, 380);
            image = initLabel("Affiche :",250,350);
            resume = initLabel("Résumé :", 250,410);
            note = initLabel("Note :",250,440);

            vBox.setLayoutX(250);
            vBox.setLayoutY(450);
            vBox.setAlignment(Pos.CENTER);
            VBox.setMargin(image, new Insets(30,0,0,0));
            VBox.setMargin(imageFilm, new Insets(0,0,0,30));

            imageFilm.setFitWidth(350);
            imageFilm.setFitHeight(450);
            imageFilm.setLayoutX(100);
            imageFilm.setLayoutY(100);
            image.setLayoutY(100);


            resumeFilm.setMaxWidth(300);
            resumeFilm.setWrapText(true);


            vBox.getChildren().addAll(image,imageFilm, Titre,nomFilm,annee, anneeFilm, note,  noteFilm, resume , resumeFilm);

        }
            scroll.setContent(vBox);
            scroll.setPrefHeight(550);
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
    private TextField initTextField( int largeur, int hauteur){
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

    //setter
    public void setEventsBack(ControllerListe cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }

    public void setTitre(Label titre) { Titre = titre; }
    public void setAnnee(Label annee) { this.annee = annee; }
    public void setImage(Label image) { this.image = image; }
    public void setResume(Label resume) { this.resume = resume; }
    public void setNote(Label note) { this.note = note; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Label getTitre() { return Titre; }
    public Label getAnnee() { return annee; }
    public Label getImage() { return image; }
    public Label getResume() { return resume; }
    public Label getNote() { return note; }
}
