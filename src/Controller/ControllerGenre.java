package Controller;

import Model.ModelGenre;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerGenre  implements EventHandler<MouseEvent> {
   private ViewHandler launcher;
   private ModelGenre model;

    public ControllerGenre(ViewHandler viewHandler, ModelGenre model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerGenre(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvGenre().getBtnBackMainP())){
            launcher.setMenuView();
        }
    }
}
