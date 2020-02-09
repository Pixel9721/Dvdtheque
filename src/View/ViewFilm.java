package View;

import Controller.ControllerFilm;
import Controller.ControllerMenu;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ViewFilm  {

    private Group root;
    private ViewHandler VhFilm;
    private Button btnBackMainP, btnEnvoyer, btnQuit;
    private TextField tTitreF, tActeur,tRealisateur,tNationnalite,tGenre;
    private Label acteur, titreF, realisateur, nationnalite, genre;
    private ChoiceBox nationalite, geNre, Realisateur,Titre,Acteur;



    public ViewFilm( ViewHandler vhFilm,Group root) {
        this.root = root;
        this.VhFilm = vhFilm;

        btnBackMainP = initButton(940,750,"retour");
        btnEnvoyer = initButton(650,300,"Envoyer");
        btnQuit = initButton(650,330,"Quitter");

        acteur = initLabel(150, 100,"Acteur");
        //tActeur = initTextField(150,220);
        Acteur = initChoice(150,220);
        titreF = initLabel(250, 100,"Titre film");
        //tTitreF = initTextField(250,220);
        Titre = initChoice(250,220);
        realisateur = initLabel(350,100,"Réalisateur");
        //tRealisateur = initTextField(350,220);
        Realisateur = initChoice(350,220);
        genre = initLabel(450,100,"Genre");
        //tGenre = initTextField(450,220);
        geNre = initChoice(450,220);
        nationnalite = initLabel(550,100,"Nationnalité");
        //tNationnalite = initTextField(550,220);
        nationalite= initChoice(550,220);

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP);
        root.getChildren().add(btnEnvoyer);
        root.getChildren().add(btnQuit);
        //root.getChildren().add(tActeur);
        //root.getChildren().add(tRealisateur);
        //root.getChildren().add(tTitreF);
        //root.getChildren().add(tGenre);
        //root.getChildren().add(tNationnalite);
        root.getChildren().add(Acteur);
        root.getChildren().add(Titre);
        root.getChildren().add(Realisateur);
        root.getChildren().add(geNre);
        root.getChildren().add(nationalite);
        root.getChildren().add(acteur);
        root.getChildren().add(titreF);
        root.getChildren().add(realisateur);
        root.getChildren().add(genre);
        root.getChildren().add(nationnalite);

    }
    private ChoiceBox initChoice(int hauteur, int largeur){
        ChoiceBox c = new ChoiceBox();
        c.setLayoutX(largeur);
        c.setLayoutY(hauteur);
        return c;
    }
    private Button initButton(int hauteur, int largeur, String texteButton) {
        Button b = new Button();
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.setText(texteButton);
        return b;
    }
    private TextField initTextField(int hauteur, int largeur){
        TextField f = new TextField();
        f.setLayoutX(largeur);
        f.setLayoutY(hauteur);
        return f;
    }
    private Label initLabel(int hauteur, int largeur, String texteLabel){
        Label l = new Label();
        l.setLayoutX(largeur);
        l.setLayoutY(hauteur);
        l.setTextFill(Color.BLACK);
        l.setText(texteLabel);
        l.setFont (Font.font ("Aclonica", 20));
        return l;
    }
    private Text iniTitre(String texteTitre ){
        Text ti = new Text();
        ti.setText(texteTitre);
        ti.setFill(Color.BLACK);
        ti.setFont (Font.font ("Aclonica", 190));
        return ti;
    }

    //setter
    public void setEventsBack(ControllerFilm cm) { btnBackMainP.setOnMouseClicked(cm); }
    public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }
    public void setBtnEnvoyer(Button btnEnvoyer) { this.btnEnvoyer = btnEnvoyer; }
    public void setBtnQuit(Button btnQuit) { this.btnQuit = btnQuit; }
    public void setActeur(Label acteur) { this.acteur = acteur; }
    public void setTitreF(Label titreF) { this.titreF = titreF; }
    public void setRealisateur(Label realisateur) { this.realisateur = realisateur; }
    public void setNationnalite(Label nationnalite) { this.nationnalite = nationnalite; }
    public void setGenre(Label genre) { this.genre = genre; }
    public void setNationalite(ChoiceBox nationalite) { this.nationalite = nationalite; }
    public void setGeNre(ChoiceBox geNre) { this.geNre = geNre; }
    public void setRealisateur(ChoiceBox realisateur) { Realisateur = realisateur; }
    public void setTitre(ChoiceBox titre) { Titre = titre; }
    public void setActeur(ChoiceBox acteur) { Acteur = acteur; }

    //getter
    public Button getBtnBackMainP(){ return btnBackMainP; }
    public Button getBtnEnvoyer() { return btnEnvoyer; }
    public Button getBtnQuit() { return btnQuit; }
    public Label getActeur() { return acteur; }
    public Label getTitreF() { return titreF; }
    public Label getRealisateur() { return realisateur; }
    public ChoiceBox getTitre() { return Titre; }
    public Label getNationnalite() { return nationnalite; }
    public Label getGenre() { return genre; }
    public ChoiceBox getNationalite() { return nationalite; }
    public ChoiceBox getGeNre() { return geNre; }
}
