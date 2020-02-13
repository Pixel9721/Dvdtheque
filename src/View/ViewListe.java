package View;

import Controller.ControllerFilm;
import Controller.ControllerListe;
import Controller.ControllerMenu;
import Dvdtheque.BDDManager;
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

        Titre = initLabel("Titre film",250, 470);
        annee = initLabel("Année ", 250, 380);
        image = initLabel("Image",250,350);
        resume = initLabel("Résumé", 250,410);
        note = initLabel("Note",250,440);

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

        ArrayList<ArrayList<String>> ListeFilm = bdd.ask("SELECT * FROM Dvdtheque.film");

        for (int i = 0; i < ListeFilm.size(); i ++) {
            Label nomFilm = new Label(ListeFilm.get(i).get(1));
            Label anneeFilm = new Label(ListeFilm.get(i).get(2));
            Label noteFilm = new Label(ListeFilm.get(i).get(3));
            TextArea resumeFilm = new TextArea(ListeFilm.get(i).get(4));
            ImageView imageFilm = new ImageView("Assets/images/30couleur.jpg");

            System.out.println(ListeFilm);
            bdd.stop();

            vBox.setLayoutX(350);
            vBox.setLayoutY(250);

            vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
            vBox.setMinHeight(Screen.getPrimary().getBounds().getHeight());

            imageFilm.setFitWidth(250);
            imageFilm.setFitHeight(350);
            //resumeFilm.setPrefWidth(200);
            //resumeFilm.setPrefHeight(300);



            vBox.getChildren().addAll(imageFilm, nomFilm, anneeFilm, resumeFilm,noteFilm);

        }
            scroll.setContent(vBox);
            scroll.setMaxHeight(1920);
            scroll.setMaxWidth(1920);
            scroll.setLayoutX(500);
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
