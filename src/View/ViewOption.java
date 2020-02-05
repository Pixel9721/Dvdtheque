package View;

import Controller.ControllerOption;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class ViewOption {
    private Group root;
    private Button btnBackMainP2, btnFilm, btnGenre, btnRealisateur, btnActeur;
    private ViewHandler vhOption;


    ViewOption(ViewHandler vhOption, Group root){
        this.vhOption = vhOption;
        this.root = root;

        btnBackMainP2 = initButton(940,750,"Back");
        btnActeur = initButton(350,270,"Acteur");
        btnRealisateur = initButton(350,370,"Réalisateur");
        btnFilm = initButton(350,470,"Film");
        btnGenre = initButton(350,570,"Genre");

    }

    void initView(){
        root.getChildren().clear();
        root.getChildren().addAll(btnBackMainP2);
        root.getChildren().add(btnActeur);
        root.getChildren().add(btnRealisateur);
        root.getChildren().add(btnFilm);
        root.getChildren().add(btnGenre);

    }

    private Button initButton(int largeur, int hauteur, String texteButton) {
        Button b = new Button();
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.setText(texteButton);
        return b;
    }

    //setter
    public void setEventsBack(ControllerOption cm){ btnBackMainP2.setOnMouseClicked(cm); }
    public void setBtnBackMainP2(Button btnBackMainP2) { this.btnBackMainP2 = btnBackMainP2; }
    public void setBtnFilm(Button btnFilm) { this.btnFilm = btnFilm; }
    public void setBtnGenre(Button btnGenre) { this.btnGenre = btnGenre; }
    public void setBtnRealisateur(Button btnRealisateur) { this.btnRealisateur = btnRealisateur; }
    public void setBtnActeur(Button btnActeur) { this.btnActeur = btnActeur; }

    //getter
    public Button getBtnBackMainP2(){ return btnBackMainP2;}
    public Button getBtnFilm() { return btnFilm; }
    public Button getBtnGenre() { return btnGenre; }
    public Button getBtnRealisateur() { return btnRealisateur; }
    public Button getBtnActeur() { return btnActeur; }


}
