package Controller;

import Dvdtheque.BDDManager;
import Model.ModelRecherche;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControllerRecherche implements EventHandler<MouseEvent> {

        private ViewHandler launcher;
        private ModelRecherche model;
        private BDDManager bdd;

    public ControllerRecherche(ViewHandler viewHandler, ModelRecherche model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerRecherche(this);
        this.launcher.setSearch(this);
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvRecherche().getBtnBackMainP())){
            launcher.setMenuView();
        }else if(event.getSource().equals(launcher.getvRecherche().getBtnEnvoyer())){
            String nomF = launcher.getvRecherche().getNom_FilmR().getText();
            String anneeF = launcher.getvRecherche().getAnnee_FilmR().getText();

            String querySearch = " SELECT * from film WHERE Nom_Film = '" +nomF+ "' OR Annee_Film = '"+anneeF+"' ;";

        }
    }
}
