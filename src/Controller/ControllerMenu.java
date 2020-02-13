package Controller;

import Model.ModelMenu;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler<MouseEvent> {

    private ViewHandler launcher;
    private ModelMenu model;

    public ControllerMenu(ViewHandler viewHandler, ModelMenu model) {
        this.launcher = viewHandler;
        this.model = model;
        this.launcher.setEventHandlerMenu(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnAjout())) {
            launcher.setFilmView();
        }else if(event.getSource().equals(launcher.getvMenu().getBtnActeur())){
            launcher.setActeurView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnListe())){
            launcher.setListeView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnRecherche())){
            launcher.setRechercheView();
        }else if (event.getSource().equals(launcher.getvMenu().getBtnRealisateur())){
            launcher.setvRealisateurView();

        }else if (event.getSource().equals(launcher.getvMenu().getBtnQuit())) {
            System.exit(0);
        }

    }
}


