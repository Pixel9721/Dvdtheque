package View;

import Controller.ControllerRecherche;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewRecherche {
    private Group root;
    private ViewHandler vhNationalite;
    private Button btnBackMainP, btnEnvoyer;
    private Label  nationnalite ;
    private TextField Libelle_nationalite;

    private Text titreFilm;


    public ViewRecherche(ViewHandler vhNationalite, Group root) {
        this.root = root;
        this.vhNationalite = vhNationalite;

        btnEnvoyer = initButton("Envoyer",250,550);
        btnBackMainP = initButton("retour",280,600);

        titreFilm = iniTitre("Recherche",150, 200);

        nationnalite = initLabel("Nationalité",250, 350);
        Libelle_nationalite = initTextField(400,350);


    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm);
        root.getChildren().add(Libelle_nationalite);
        root.getChildren().add(nationnalite);

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
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }
    public void setNationnalite(Label nationnalite) { this.nationnalite = nationnalite; }
    public void setLibelle_nationalite(TextField libelle_nationalite) { Libelle_nationalite = libelle_nationalite; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public Label getNationnalite() { return nationnalite; }
    public TextField  getNationalite() { return Libelle_nationalite; }
}

