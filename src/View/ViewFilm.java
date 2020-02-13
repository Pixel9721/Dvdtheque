package View;

import Controller.ControllerFilm;
import Dvdtheque.BDDManager;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewFilm  {

    private Group root;
    private ViewHandler VhFilm;
    private Button btnBackMainP, btnEnvoyer;
    private Label  Titre, annee, image,resume, note;
    private TextField nom_Film, annee_Film, note_Film, image_Film ;
    private TextArea resume_Film;
    private Text titreFilm;
    private BDDManager bdd;

    public ViewFilm( ViewHandler vhFilm,Group root) {
        this.root = root;
        this.VhFilm = vhFilm;

        btnEnvoyer = initButton("Envoyer",1190,550);
        btnBackMainP = initButton("Retour",1190,600);

        titreFilm = iniTitre("Film",550, 200);

        Titre = initLabel("Titre film",490, 300);
        nom_Film = initTextField(600,300);
        annee = initLabel("Année ", 490, 350);
        annee_Film = initTextField(600,350);
        resume = initLabel("Résumé", 490,410);
        resume_Film = initTextArea(600, 410);
        image = initLabel("Image",490,630);
        image_Film = initTextField(600,630);
        note = initLabel("Note",490,660);
        note_Film = initTextField(600, 660);

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().addAll(titreFilm);
        root.getChildren().addAll(Titre, nom_Film, annee, annee_Film,image, image_Film, note, note_Film);
        root.getChildren().add(resume);
        root.getChildren().add(resume_Film);
    }

    private  TextArea initTextArea(int largeur, int hauteur) {
        TextArea te = new TextArea();
        te.setLayoutX(largeur);
        te.setLayoutY(hauteur);
        return te;
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
    public void setEvents(ControllerFilm cm) {
        btnEnvoyer.setOnMouseClicked(cm);
        btnBackMainP.setOnMouseClicked(cm);
    }

    //setter
    public void setEventsBack(ControllerFilm cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }

    public void setTitre(Label titre) { Titre = titre; }
    public void setAnnee(Label annee) { this.annee = annee; }
    public void setImage(Label image) { this.image = image; }
    public void setResume(Label resume) { this.resume = resume; }
    public void setNote(Label note) { this.note = note; }
    public void setNom_Film(TextField nom_Film) { this.nom_Film = nom_Film; }
    public void setAnnee_Film(TextField annee_Film) { this.annee_Film = annee_Film; }
    public void setNote_Film(TextField note_Film) { this.note_Film = note_Film; }
    public void setImage_Film(TextField image_Film) { this.image_Film = image_Film; }
    public void setResume_Film(TextArea resume_Film) { this.resume_Film = resume_Film; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public TextField getNom_Film() { return nom_Film; }
    public TextField getAnnee_Film() { return annee_Film; }
    public TextField getNote_Film() { return note_Film; }
    public TextField getImage_Film() { return image_Film; }
    public TextArea getResume_Film() { return resume_Film; }
}
