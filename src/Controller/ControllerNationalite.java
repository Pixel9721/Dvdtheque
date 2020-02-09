package Controller;

import Model.ModelNationalite;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerNationalite implements EventHandler<MouseEvent> {

        private ViewHandler launcher;
        private ModelNationalite model;

    public ControllerNationalite(ViewHandler viewHandler, ModelNationalite model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerNationalite(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
