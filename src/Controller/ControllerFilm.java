package Controller;

import Dvdtheque.BDDManager;
import Model.ModelFilm;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class ControllerFilm implements EventHandler<MouseEvent> {
    private ViewHandler launcher;
    private BDDManager bdd;
    private ModelFilm model;

    public ControllerFilm(ViewHandler viewHandler, ModelFilm model) {
        this.launcher = viewHandler;
        this.launcher.setEventHandlerFilm(this);
        this.launcher.setFilmInsert(this);
        this.model = model;
        bdd = new BDDManager();
    }

    private void showAlertAjoutReussi(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout d'un nouveau Film");
        alert.setHeaderText(null);
        alert.setContentText("Votre film a bien été ajouté dans la Dvdtheque.");
        alert.showAndWait();
    }

    private void showAlertVide(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur ajout");
        alert.setHeaderText(null);
        alert.setContentText("Vous ne devez pas laisser un champ vide !");
        alert.showAndWait();
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource().equals(launcher.getvFilm().getBtnBackMainP())){
            launcher.setMenuView();
        }else if(event.getSource().equals(launcher.getvFilm().getBtnEnvoyer())){
            String nomF = launcher.getvFilm().getNom_Film().getText();
            String anneeF = launcher.getvFilm().getAnnee_Film().getText();
            String noteF = launcher.getvFilm().getNote_Film().getText();
            String imgF = launcher.getvFilm().getImage_Film().getText();
            String resumeF = launcher.getvFilm().getResume_Film().getText();

            String queryAddFilm = "INSERT INTO film (Nom_Film, Annee_Film, Note_Film, Image_Film, Resume_Film) VALUES ('" + nomF + "','" + anneeF + "','" + noteF + "','" + resumeF + "','" + imgF + "');";

            bdd.start();
            bdd.edit(queryAddFilm);
            if(nomF .equals("") || anneeF .equals("") || noteF .equals("") || resumeF .equals("") || imgF .equals("")){
                showAlertVide();
                bdd.stop();
                return;
            }else{
                showAlertAjoutReussi();
            }
            bdd.stop();

        }
    }
}
