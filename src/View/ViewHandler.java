package View;

import Controller.*;
import Model.*;
import Music.Music;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private Scene scene;
    private Group root;
    private ViewMainMenu vMenu;
    private ViewFilm vFilm;
    private ModelFilm modelFilm;
    private ModelMenu modelMenu;
    private ModelListe modelGenre;
    private ModelRecherche modelNationalite;
    private ControllerMenu controllerMenu;
    private ControllerFilm controllerFilm;
    private ControllerListe controllerListe;
    private ControllerRecherche controllerRecherche;
    private ViewListe vGenre;
    private ViewRecherche vRecherche;


    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root,1300,700);
        scene.getStylesheets().add("Assets/css/styles.css");

        modelFilm = new ModelFilm();
        modelGenre = new ModelListe();
        modelNationalite = new ModelRecherche();

        vMenu = new ViewMainMenu(this,root);
        vFilm = new ViewFilm(this,root);
        vGenre = new ViewListe(this, root);
        vRecherche = new ViewRecherche(this, root);

        controllerMenu = new ControllerMenu(this, modelMenu);
        controllerFilm = new ControllerFilm(this,modelFilm);
        controllerListe = new ControllerListe(this,modelGenre);
        controllerRecherche = new ControllerRecherche(this,modelNationalite);


        Music.startMainMenuMusic();
        primaryStage.setTitle("Dvdtheque");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    //setter
    public void setEventHandlerMenu(ControllerMenu cm) { vMenu.setEvents(cm); }
    public void setEventHandlerFilm(ControllerFilm cm) { vFilm.setEventsBack(cm); }
    public void setFilmInsert(ControllerFilm cm) { vFilm.setFilmInsert(cm);}
    public void setEventHandlerListe(ControllerListe cm) { vGenre.setEventsBack(cm);}
    public void setEventHandlerRecherche(ControllerRecherche cm) { vRecherche.setEventsBack(cm);}
    public void setSearch(ControllerRecherche cm) { vRecherche.setSearchFilm(cm);}


    public void setFilmView() { vFilm.initView(); }
    public void setListeView() { vGenre.initView(); }
    public void setRechercheView() { vRecherche.initView(); }
    public void setMenuView() { vMenu.initView(); }


    //getter
    public ViewMainMenu getvMenu() { return vMenu; }
    public ViewFilm getvFilm() { return vFilm; }
    public ViewListe getvGenre() { return vGenre; }
    public ViewRecherche getvRecherche() { return vRecherche; }
}

