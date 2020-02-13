package Controller;

import Dvdtheque.BDDManager;
import Model.ModelRecherche;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
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
        bdd = new BDDManager();

    }

    private void showAlertNullSearch(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Recherche resultat");
        alert.setHeaderText(null);
        alert.setContentText("Votre recherche n'a été trouvé dans la Dvdtheque.");
        alert.showAndWait();
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvRecherche().getBtnBackMainP())){
            launcher.setMenuView();
        }else if(event.getSource().equals(launcher.getvRecherche().getBtnEnvoyer())){
            String nomF = launcher.getvRecherche().getNom_FilmR().getText();
            String anneeF = launcher.getvRecherche().getAnnee_FilmR().getText();

            String querySearch = " SELECT * from film WHERE Nom_Film = '" +nomF+ "' OR Annee_Film = '"+anneeF+"' ;";

            bdd.start();
            bdd.ask(querySearch);
            if(querySearch == null){
                showAlertNullSearch();
            }


            bdd.stop();
        }
    }
}
