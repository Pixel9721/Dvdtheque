package View;

import Controller.ControllerFilm;
import Controller.ControllerMenu;
import Controller.ControllerRecherche;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewRecherche {
    private Group root;
    private ViewHandler VhRecherche;
    private Button btnBackMainP, btnEnvoyer;
    private Label  Titre, annee;
    private TextField nom_Film, annee_Film;
    private Text titreFilm;


    public ViewRecherche(ViewHandler vhRecherche, Group root) {
        this.root = root;
        this.VhRecherche = vhRecherche;

        btnEnvoyer = initButton("Envoyer",250,550);
        btnBackMainP = initButton("retour",280,600);

        titreFilm = iniTitre("Film",550, 200);

        Titre = initLabel("Titre film",250, 350);
        nom_Film = initTextField(400,350);
        annee = initLabel("Année ", 250, 380);
        annee_Film = initTextField(400,380);

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm);
        root.getChildren().addAll(Titre, nom_Film, annee, annee_Film);
    }

    private Button initButton(String texteButton, int largeur, int hauteur) {
        Button b = new Button();
        b.setText(texteButton);
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        //b.setBackground(null);
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
    public void setEvents(ControllerRecherche cm) {
        btnEnvoyer.setOnMouseClicked(cm);
        btnBackMainP.setOnMouseClicked(cm);
    }

    //setter
    public void setEventsBack(ControllerRecherche cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setSearchFilm(ControllerRecherche cm) { btnEnvoyer.setOnMouseClicked(cm);}

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public TextField getNom_FilmR() { return nom_Film; }
    public TextField getAnnee_FilmR() { return annee_Film; }
}