package View;

import Controller.ControllerFilm;
import Controller.ControllerListe;
import Controller.ControllerMenu;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewListe {
    private Group root;
    private ViewHandler vhListe;
    private Button btnBackMainP, btnEnvoyer;
    private Label  Titre, annee, image,resume, note;
    private Text titreFilm;


    public ViewListe(ViewHandler vhListe, Group root) {
        this.root = root;
        this.vhListe = vhListe;

        btnEnvoyer = initButton("Envoyer",250,550);
        btnBackMainP = initButton("retour",280,600);

        titreFilm = iniTitre("Film",550, 200);

        Titre = initLabel("Titre film",250, 350);
        annee = initLabel("Année ", 250, 380);
        image = initLabel("Image",250,470);
        resume = initLabel("Résumé", 250,410);
        note = initLabel("Note",250,440);

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm);
        root.getChildren().addAll(Titre,annee,image, note);
        root.getChildren().add(resume);
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
    public void setEvents(ControllerListe cm) {
        btnEnvoyer.setOnMouseClicked(cm);
        btnBackMainP.setOnMouseClicked(cm);
    }

    //setter
    public void setEventsBack(ControllerListe cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }

    public void setTitre(Label titre) { Titre = titre; }
    public void setAnnee(Label annee) { this.annee = annee; }
    public void setImage(Label image) { this.image = image; }
    public void setResume(Label resume) { this.resume = resume; }
    public void setNote(Label note) { this.note = note; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public Label getTitre() { return Titre; }
    public Label getAnnee() { return annee; }
    public Label getImage() { return image; }
    public Label getResume() { return resume; }
    public Label getNote() { return note; }
}
