package View;

import Controller.ControllerFilm;
import Dvdtheque.BDDManager;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewFilm  {

    private Group root;
    private ViewHandler VhFilm;
    private Button btnBackMainP, btnEnvoyer;
    private Label  Titre, annee, image,resume, note;
    private TextField nom_Film, annee_Film, note_Film, image_Film, resume_Film ;
    private Text titreFilm;

    public ViewFilm( ViewHandler vhFilm,Group root) {
        this.root = root;
        this.VhFilm = vhFilm;

        btnEnvoyer = initButton("Envoyer",250,550);
        btnBackMainP = initButton("retour",280,600);

        titreFilm = iniTitre("Film",550, 200);

        Titre = initLabel("Titre film",250, 350);
        nom_Film = initTextField(400,350);
        annee = initLabel("Année ", 250, 380);
        annee_Film = initTextField(400,380);
        image = initLabel("Image",250,470);
        image_Film = initTextField(400,470);
        resume = initLabel("Résumé", 250,410);
        resume_Film = initTextField(400,410);
        note = initLabel("Note",250,440);
        note_Film = initTextField(400, 440);

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

    public void insertFilm(){
        try{
            BDDManager bdd = new BDDManager();
            bdd.start();
            String queryNomF = "INSERT INTO 'film' ('Nom_Film') VALUES ('"+nom_Film.getText()+"')";
            String queryAnnee = "INSERT INTO 'film' ('Annee_Film') VALUES ('"+annee_Film.getText()+"')";
            String queryNote = "INSERT INTO 'film' ('Note_Film') VALUES ('"+note_Film.getText()+"')";
            String queryImg = "INSERT INTO 'film' ('Image_Film') VALUES ('"+image_Film.getText()+"')";
            String queryResume = "INSERT INTO 'film' ('Resume_Film') VALUES ('"+resume_Film.getText()+"')";
            System.out.println("Reussite");
            bdd.stop();
        }catch (Exception e){
            System.out.println("Echoue");
        }
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
    public void setResume_Film(TextField resume_Film) { this.resume_Film = resume_Film; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public Label getTitre() { return Titre; }
    public Label getAnnee() { return annee; }
    public Label getImage() { return image; }
    public Label getResume() { return resume; }
    public Label getNote() { return note; }
    public TextField getNom_Film() { return nom_Film; }
    public TextField getAnnee_Film() { return annee_Film; }
    public TextField getNote_Film() { return note_Film; }
    public TextField getImage_Film() { return image_Film; }
    public TextField getResume_Film() { return resume_Film; }
}
