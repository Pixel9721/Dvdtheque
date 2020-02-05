package Controller;

import Model.ModelFilm;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerFilm implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelFilm model;

    public ControllerFilm(ViewHandler viewHandler, ModelFilm model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerFilm(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource().equals(launcher.getvFilm().getBtnBackMainP())){
            launcher.setMenuView();
        }

    }
}
