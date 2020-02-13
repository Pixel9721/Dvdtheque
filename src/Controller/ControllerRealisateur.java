package Controller;

import Model.ModelActeur;
import Model.ModelRealisateur;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerRealisateur implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelRealisateur model;

    public ControllerRealisateur(ViewHandler viewHandler, ModelRealisateur model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerRealisateur(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvRealisateur().getBtnBackMainP())){
            launcher.setMenuView();
        }
    }
}
