package View;

import Controller.ControllerActeur;
import Controller.ControllerFilm;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewActeur {
    private Group root;
    private ViewHandler vhActeur;
    private Button btnBackMainP, btnEnvoyer;
    private Label Nom, Prenom;
    private TextField nom_Acteur, prenom_Acteur;
    private Text titreFilm;


    public ViewActeur(ViewHandler vhActeur, Group root) {
        this.root = root;
        this.vhActeur = vhActeur;
        btnEnvoyer = initButton("Envoyer", 250, 550);
        btnBackMainP = initButton("retour", 280, 600);

        titreFilm = iniTitre("Acteur", 550, 200);

        Nom = initLabel("Nom", 250, 350);
        nom_Acteur = initTextField(400, 350);
        Prenom = initLabel("Prénom ", 250, 380);
        prenom_Acteur = initTextField(400, 380);

    }

    void initView() {
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm);
        root.getChildren().addAll(Nom, nom_Acteur,prenom_Acteur, Prenom);
    }

    private Button initButton(String texteButton, int largeur, int hauteur) {
        Button b = new Button();
        b.setText(texteButton);
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.setTextFill(Color.BLACK);
        b.setBackground(null);
        b.setFont(Font.font("Aclonica", 20));
        return b;
    }

    private Text iniTitre(String texteTitre, int largeur, int hauteur) {
        Text ti = new Text();
        ti.setText(texteTitre);
        ti.setLayoutX(largeur);
        ti.setLayoutY(hauteur);
        ti.setFill(Color.BLACK);
        ti.setFont(Font.font("Aclonica", 190));
        return ti;
    }

    private TextField initTextField(int largeur, int hauteur) {
        TextField f = new TextField();
        f.setLayoutX(largeur);
        f.setLayoutY(hauteur);
        return f;
    }

    private Label initLabel(String texteLabel, int largeur, int hauteur) {
        Label l = new Label();
        l.setLayoutX(largeur);
        l.setLayoutY(hauteur);
        l.setTextFill(Color.BLACK);
        l.setText(texteLabel);
        l.setFont(Font.font("Aclonica", 20));
        return l;
    }
    public void setEvents(ControllerActeur cm) {
        btnEnvoyer.setOnMouseClicked(cm);
        btnBackMainP.setOnMouseClicked(cm);
    }

    //setter
    public void setEventsBack(ControllerActeur cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }
    public void setNom(Label nom) { Nom = nom; }
    public void setPrenom(Label prenom) { Prenom = prenom; }
    public void setNom_Acteur(TextField nom_Acteur) { this.nom_Acteur = nom_Acteur; }
    public void setPrenom_Acteur(TextField prenom_Acteur) { this.prenom_Acteur = prenom_Acteur; }


    //getter
    public Button getBtnBackMainP() { return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public Label getNom() { return Nom; }
    public Label getPrenom() { return Prenom; }
    public TextField getNom_Acteur() { return nom_Acteur; }
    public TextField getPrenom_Acteur() { return prenom_Acteur; }
}

