package Controller;

import Model.ModelListe;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerListe implements EventHandler<MouseEvent> {
   private ViewHandler launcher;
   private ModelListe model;

    public ControllerListe(ViewHandler viewHandler, ModelListe model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerListe(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvGenre().getBtnBackMainP())){
            launcher.setMenuView();
        }
    }
}
