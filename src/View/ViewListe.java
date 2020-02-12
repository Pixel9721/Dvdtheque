package View;

import Controller.ControllerListe;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewListe {
    private Group root;
    private ViewHandler vhListe;
    private Button btnBackMainP, btnEnvoyer;
    private Label libelle;
    private TextField Libelle_genre;
    private Text titreFilm;


    public ViewListe(ViewHandler vhListe, Group root) {
        this.root = root;
        this.vhListe = vhListe;

        btnEnvoyer = initButton("Envoyer",250,550);
        btnBackMainP = initButton("retour",280,600);

        titreFilm = iniTitre("Liste des Films",380, 200);

        libelle = initLabel("Libelle",250,350);
        Libelle_genre = initTextField(400,350);

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm, libelle,Libelle_genre);

    }

    private Button initButton(String texteButton, int largeur, int hauteur) {
        Button b = new Button();
        b.setText(texteButton);
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.setTextFill(Color.BLACK);
        b.setBackground(null);
        b.setStyle(" -fx-border-color: #000000; -fx-border-radius: 30;");
        b.setFont (Font.font ("Aclonica", 20));
        return b;
    }
    private Text iniTitre(String texteTitre, int largeur, int hauteur){
        Text ti = new Text();
        ti.setText(texteTitre);
        ti.setLayoutX(largeur);
        ti.setLayoutY(hauteur);
        ti.setFill(Color.BLACK);
        ti.setFont (Font.font ("Aclonica", 100));
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
        btnEnvoyer.setOnMouseClicked(cm);
        btnBackMainP.setOnMouseClicked(cm);
    }

    //setter
    public void setEventsBack(ControllerListe cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }

    public void setLibelle(Label libelle) { this.libelle = libelle; }
    public void setLibelle_genre(TextField libelle_genre) { Libelle_genre = libelle_genre; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }

    public Label getLibelle() { return libelle; }
    public TextField getLibelle_genre() { return Libelle_genre; }
}
