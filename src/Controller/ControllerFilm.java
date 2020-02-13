package Controller;

import Dvdtheque.BDDManager;
import Model.ModelFilm;
import View.ViewHandler;
import javafx.event.EventHandler;
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

            String queryAddFilm = "INSERT INTO film (Nom_Film, Annee_Film, Note_Film, Image_Film, Resume_Film) VALUES ('" + nomF + "'," + anneeF + "," + noteF + ",'" + resumeF + "','" + imgF + "');";

            bdd.start();
            bdd.edit(queryAddFilm);
            bdd.stop();

        }
    }
}
