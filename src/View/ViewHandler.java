package View;

import Controller.ControllerFilm;
import Controller.ControllerMenu;
import Controller.ControllerOption;
import Model.ModelFilm;
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
    private ViewOption vOption;
    private ModelFilm modelFilm;
    private ControllerFilm controllerFilm;
    private ViewActeur vActeur;
    private ViewRealisateur vRealisateur;
    private ViewGenre vGenre;
    private ViewNationalite vNationalite;


    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        root = new Group();
        scene = new Scene(root);

        modelFilm = new ModelFilm();
        vMenu = new ViewMainMenu(this,root);
        vFilm = new ViewFilm(this,root);
        vActeur = new ViewActeur(this, root);
        vOption = new ViewOption(this,root);
        controllerFilm = new ControllerFilm(this,modelFilm);


        primaryStage.setTitle("Dvdtheque");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    //setter
    public void setEventHandlerMenu(ControllerMenu cm) { vMenu.setEvents(cm); }
    public void setEventHandlerFilm(ControllerFilm cm) { vFilm.setEventsBack(cm); }
    public void setEventHandlerOption(ControllerOption cm){ vOption.setEventsBack(cm); }
    public void setFilmView() { vFilm.initView(); }
    public void setActeurView() { vActeur.initView(); }
    public void setRealisateurView() { vRealisateur.initView(); }
    public void setGenreView() { vGenre.initView(); }
    public void setNationaliteView() { vNationalite.initView(); }


    public void setMenuView() { vMenu.initView(); }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    //getter
    public ViewOption getvOption() {return vOption; }
    public ViewMainMenu getvMenu() { return vMenu; }




















}
