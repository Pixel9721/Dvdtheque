package Controller;

import Model.ModelRecherche;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerRecherche implements EventHandler<MouseEvent> {

        private ViewHandler launcher;
        private ModelRecherche model;

    public ControllerRecherche(ViewHandler viewHandler, ModelRecherche model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerRecherche(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvNationalite().getBtnBackMainP())){
            launcher.setMenuView();
        }
    }
}
