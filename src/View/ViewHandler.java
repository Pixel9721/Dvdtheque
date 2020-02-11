package View;

import Controller.*;
import Model.*;
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
    private ModelActeur modelActeur;
    private ModelRealisateur modelRealisateur;
    private ModelGenre modelGenre;
    private ModelNationalite modelNationalite;
    private ControllerMenu controllerMenu;
    private ControllerFilm controllerFilm;
    private ControllerActeur controllerActeur;
    private ControllerRealisateur controllerRealisateur;
    private ControllerGenre controllerGenre;
    private ControllerNationalite controllerNationalite;
    private ViewActeur vActeur;
    private ViewRealisateur vRealisateur;
    private ViewGenre vGenre;
    private ViewNationalite vNationalite;


    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root);

        modelFilm = new ModelFilm();
        modelActeur = new ModelActeur();
        modelRealisateur = new ModelRealisateur();
        modelGenre = new ModelGenre();
        modelNationalite = new ModelNationalite();

        vMenu = new ViewMainMenu(this,root);
        vFilm = new ViewFilm(this,root);
        vActeur = new ViewActeur(this, root);
        vRealisateur = new ViewRealisateur(this, root);
        vGenre = new ViewGenre(this, root);
        vNationalite = new ViewNationalite(this, root);

        controllerMenu = new ControllerMenu(this, modelMenu);
        controllerFilm = new ControllerFilm(this,modelFilm);
        controllerActeur = new ControllerActeur(this,modelActeur);
        controllerRealisateur = new ControllerRealisateur(this,modelRealisateur);
        controllerGenre = new ControllerGenre(this,modelGenre);
        controllerNationalite = new ControllerNationalite(this,modelNationalite);


        primaryStage.setTitle("Dvdtheque");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
    //setter
    public void setEventHandlerMenu(ControllerMenu cm) { vMenu.setEvents(cm); }
    public void setEventHandlerFilm(ControllerFilm cm) { vFilm.setEventsBack(cm); }
    public void setEventHandlerGenre(ControllerGenre cm) {vGenre.setEventsBack(cm);}
    public void setEventHandleRealisateur(ControllerRealisateur cm) {vRealisateur.setEventsBack(cm);}
    public void setEventHandlerNationalite(ControllerNationalite cm) {vNationalite.setEventsBack(cm);}
    public void setEventHandlerActeur(ControllerActeur cm) {vActeur.setEventsBack(cm);}


    public void setFilmView() { vFilm.initView(); }
    public void setActeurView() { vActeur.initView(); }
    public void setRealisateurView() { vRealisateur.initView(); }
    public void setGenreView() { vGenre.initView(); }
    public void setNationaliteView() { vNationalite.initView(); }
    public void setMenuView() { vMenu.initView(); }


    //getter
    public ViewMainMenu getvMenu() { return vMenu; }
    public ViewFilm getvFilm() { return vFilm; }
    public ViewActeur getvActeur() { return vActeur; }
    public ViewRealisateur getvRealisateur() { return vRealisateur; }
    public ViewGenre getvGenre() { return vGenre; }
    public ViewNationalite getvNationalite() { return vNationalite; }
}

