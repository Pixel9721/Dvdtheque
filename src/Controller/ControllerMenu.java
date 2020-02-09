package Controller;

import Model.ModelMenu;
import View.ViewHandler;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private ModelMenu model;

    public ControllerMenu(ViewHandler launcher, ModelMenu model) {
        this.launcher = launcher;
        this.model = model;
        this.launcher.setEventHandlerMenu(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnFilm())) {
            launcher.setFilmView();
        } else if (event.getSource().equals(launcher.getvMenu().getBtnActeur())){
            launcher.setActeurView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnGenre())){
            launcher.setGenreView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnRealisateur())){
            launcher.setRealisateurView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnNationalite())){
            launcher.setNationaliteView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnQuit())) {
            System.exit(0);
        }

    }
}


