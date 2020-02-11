package View;

import Controller.ControllerFilm;
import Controller.ControllerRealisateur;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewRealisateur {
    private Group root;
    private ViewHandler vhRealisateur;
    private Button btnBackMainP, btnEnvoyer;
    private Label  nom_realisateur, prenom_realisateur;
    private TextField Nom_ReaLisateur, Prenom_Realisateur;
    private Text titreFilm;


    public ViewRealisateur(ViewHandler vhRealisateur, Group root) {
        this.root = root;
        this.vhRealisateur = vhRealisateur;
        btnEnvoyer = initButton("Envoyer",250,550);
        btnBackMainP = initButton("retour",280,600);

        titreFilm = iniTitre("Réalisateur",150, 200);

        nom_realisateur = initLabel("Réalisateur",250, 350);
        Nom_ReaLisateur = initTextField(400,350);
        prenom_realisateur = initLabel("Nom",250,380);
        Prenom_Realisateur = initTextField(400, 380);
    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm);
        root.getChildren().addAll(nom_realisateur,Nom_ReaLisateur);
        root.getChildren().addAll(Prenom_Realisateur, prenom_realisateur );

    }
    private Button initButton(String texteButton, int largeur, int hauteur) {
        Button b = new Button();
        b.setText(texteButton);
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.setTextFill(Color.BLACK);
        b.setBackground(null);
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
    public void setEvents(ControllerRealisateur cm) {
        btnEnvoyer.setOnMouseClicked(cm);
        btnBackMainP.setOnMouseClicked(cm);
    }

    //setter
    public void setEventsBack(ControllerRealisateur cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }
    public void setNom_realisateur(Label nom_realisateur) {
        this.nom_realisateur = nom_realisateur;
    }
    public void setPrenom_realisateur(Label prenom_realisateur) {
        this.prenom_realisateur = prenom_realisateur;
    }
    public void setNom_ReaLisateur(TextField nom_ReaLisateur) { Nom_ReaLisateur = nom_ReaLisateur; }
    public void setPrenom_Realisateur(TextField prenom_Realisateur) { Prenom_Realisateur = prenom_Realisateur; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }

    public Label getNom_realisateur() { return nom_realisateur; }
    public Label getPrenom_realisateur() { return prenom_realisateur; }
    public TextField getNom_ReaLisateur() { return Nom_ReaLisateur; }
    public TextField getPrenom_Realisateur() { return Prenom_Realisateur; }
}

