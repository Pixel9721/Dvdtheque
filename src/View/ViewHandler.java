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
    private ViewActeur vActeur;
    private ViewListe vListe;
    private ViewRecherche vRecherche;
    private ViewRealisateur vRealisateur;

    private ModelFilm modelFilm;
    private ModelMenu modelMenu;
    private ModelListe modelListe;
    private ModelRecherche modelRecherche;
    private ModelActeur modelActeur;
    private ModelRealisateur modelRealisateur;

    private ControllerMenu controllerMenu;
    private ControllerFilm controllerFilm;
    private ControllerListe controllerListe;
    private ControllerRecherche controllerRecherche;
    private ControllerActeur controllerActeur;
    private ControllerRealisateur controllerRealisateur;


    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root);
        scene.getStylesheets().add("Assets/css/styles.css");

        //modelFilm = new ModelFilm();
        modelListe = new ModelListe();
        modelRecherche = new ModelRecherche();

        vMenu = new ViewMainMenu(this,root);
        vFilm = new ViewFilm(this,root);
        vListe = new ViewListe(this, root);
        vRecherche = new ViewRecherche(this, root);
        vActeur = new ViewActeur(this, root);
        vRealisateur = new ViewRealisateur(this, root);

        controllerMenu = new ControllerMenu(this, modelMenu);
        controllerFilm = new ControllerFilm(this,modelFilm);
        controllerListe = new ControllerListe(this, modelListe);
        controllerRecherche = new ControllerRecherche(this, modelRecherche);
        controllerActeur = new ControllerActeur(this, modelActeur);
        controllerRealisateur = new ControllerRealisateur(this, modelRealisateur);

        Music.startMainMenuMusic();
        primaryStage.setTitle("Dvdtheque");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    //setter
    public void setEventHandlerMenu(ControllerMenu cm) { vMenu.setEvents(cm); }
    public void setEventHandlerFilm(ControllerFilm cm) { vFilm.setEventsBack(cm); }
    public void setFilmInsert(ControllerFilm cm) { vFilm.setFilmInsert(cm);}
    public void setEventHandlerListe(ControllerListe cm) { vListe.setEventsBack(cm);}
    public void setEventHandlerRecherche(ControllerRecherche cm) { vRecherche.setEventsBack(cm);}
    public void setEventHandlerActeur(ControllerActeur cm){vActeur.setEventsBack(cm); }
    public void setEventHandlerRealisateur(ControllerRealisateur cm){vRealisateur.setEventsBack(cm);}

    public void setSearch(ControllerRecherche cm) { vRecherche.setSearchFilm(cm);}

    public void setFilmView() { vFilm.initView(); }
    public void setListeView() { vListe.initView(); }

    public void setActeurView(){vActeur.initView(); }

    public void setRechercheView() { vRecherche.initView(); }
    public void setMenuView() { vMenu.initView(); }
    public void setvRealisateurView(){ vRealisateur.initView();}


    //getter
    public ViewMainMenu getvMenu() { return vMenu; }
    public ViewFilm getvFilm() { return vFilm; }
    public ViewActeur getvActeur() { return vActeur; }
    public ViewRealisateur getvRealisateur() { return vRealisateur; }

    public ViewListe getvListe() { return vListe; }
    public ViewRecherche getvRecherche() { return vRecherche; }
}

