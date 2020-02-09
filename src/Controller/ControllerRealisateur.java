package Controller;

import Model.ModelRealisateur;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerRealisateur  implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelRealisateur model;

    public ControllerRealisateur(ViewHandler viewHandler, ModelRealisateur model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandleRealisateur(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
