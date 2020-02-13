package View;

import Controller.ControllerMenu;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;


public class ViewMainMenu {

    private ViewHandler vhMenu;
    private VBox vBox, vBox2;
    private HBox hBox;
    private Button btnQuit,btnFilm, btnListe, btnRecherche;
    private Group root;
    private Text titreM;

    public ViewMainMenu(ViewHandler vhMenu, Group root) {
        this.vhMenu = vhMenu;
        this.root = root;


        //initialisation des Vbox
        vBox = new VBox();
        vBox2 = new VBox();
        hBox = new HBox();
        vBox.setLayoutX(0);
        vBox.setLayoutY(0);
        vBox2.setLayoutX(0);
        vBox2.setLayoutY(0);

        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox.setMinHeight(Screen.getPrimary().getBounds().getHeight());

        vBox2.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox2.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        hBox.setMinHeight(Screen.getPrimary().getBounds().getHeight());

        vBox.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.TOP_CENTER);
        hBox.setAlignment(Pos.BASELINE_CENTER);

        vBox.setBackground(new Background(new BackgroundImage(
                new Image("Assets/images/bobine_cinema.png"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));

        //initialisation des bouttons et du titre
        btnFilm = initButton("Ajouter film", 100, 350);
        btnListe = initButton("Liste des films", 180,420);
        btnRecherche = initButton("Recherche",300,490);
        btnQuit = initButton("Quitter",1190,590);
        //VBox.setMargin(btnRealisateur,new Insets(0,50,0,50));
        //HBox.setMargin(btnFilm,new Insets(0,50,0,50));

        titreM = iniTitre("DVDTHEQUE");

        vBox.getChildren().addAll();
        vBox2.getChildren().addAll(titreM);
        hBox.getChildren().addAll();

        initView();
    }

     void initView() {
        root.getChildren().clear();
        root.getChildren().add(vBox);
        root.getChildren().add(vBox2);
        root.getChildren().add(hBox);
        root.getChildren().addAll(btnFilm, btnListe, btnRecherche, btnQuit);
    }

    private Text iniTitre(String texteTitre ){
        Text ti = new Text();
        ti.setText(texteTitre);
        ti.setFill(Color.BLACK);
        ti.setFont (Font.font ("Aclonica", 150));
        return ti;
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

    //setter
    public void setEvents(ControllerMenu cm) {
        btnQuit.setOnMouseClicked(cm);
        btnFilm.setOnMouseClicked(cm);
        btnListe.setOnMouseClicked(cm);
        btnRecherche.setOnMouseClicked(cm);
    }

    //getter
    public Button getBtnQuit() { return btnQuit; }
    public Button getBtnFilm() { return btnFilm; }
    public Button getBtnListe() { return btnListe; }
    public Button getBtnRecherche() { return btnRecherche; }
}
