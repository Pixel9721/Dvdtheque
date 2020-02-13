package Controller;

import Model.ModelActeur;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerActeur implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private ModelActeur model;

    public ControllerActeur(ViewHandler viewHandler, ModelActeur model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerActeur(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvActeur().getBtnBackMainP())){
            launcher.setActeurView();
        }
    }
}
