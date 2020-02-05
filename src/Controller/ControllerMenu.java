package Controller;

import Model.ModelMenu;
import View.ViewHandler;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerMenu implements EventHandler {

    private ViewHandler launcher;
    private ModelMenu model;

    public ControllerMenu(ViewHandler launcher, ModelMenu model) {
        this.launcher = launcher;
        this.model = model;
        this.launcher.setEventHandlerMenu(this);
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(launcher.getvMenu().getBtnOption())) {
            launcher.setOptionView();
        } else if (event.getSource().equals(launcher.getvMenu().getBtnQuit())) {
            System.exit(0);
        }
    }
}

