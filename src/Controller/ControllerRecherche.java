package Controller;

import Dvdtheque.BDDManager;
import Model.ModelRecherche;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ControllerRecherche implements EventHandler<MouseEvent> {

        private ViewHandler launcher;
        private ModelRecherche model;
        private BDDManager bdd;
        private VBox vBox;

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
            vBox = new VBox();

            ScrollPane scroll = new ScrollPane();
            String nomF = launcher.getvRecherche().getNom_FilmR().getText();
            String anneeF = launcher.getvRecherche().getAnnee_FilmR().getText();

            String querySearch = " SELECT * from film WHERE Nom_Film = '" +nomF+ "' OR Annee_Film = '"+anneeF+"' ;";

            bdd.start();
            ArrayList<ArrayList<String>> ListeRecherche = bdd.ask(querySearch);
            System.out.println(bdd.ask(querySearch));
            if(querySearch == null){
                showAlertNullSearch();
            }
            for (int i = 0; i < ListeRecherche.size(); i ++) {
                Label nomFilm = new Label(ListeRecherche.get(i).get(1));
                Label anneeFilm = new Label(ListeRecherche.get(i).get(2));
                Label noteFilm = new Label(ListeRecherche.get(i).get(3));
                TextArea resumeFilm = new TextArea(ListeRecherche.get(i).get(5));
                ImageView imageFilm = new ImageView("Assets/images/30couleur.jpg");

                System.out.println(ListeRecherche);
                bdd.stop();

                vBox.setLayoutX(350);
                vBox.setLayoutY(450);
                vBox.setAlignment(Pos.CENTER);
                VBox.setMargin(imageFilm, new Insets(0, 0, 0, 30));

                imageFilm.setFitWidth(350);
                imageFilm.setFitHeight(450);
                imageFilm.setLayoutX(100);
                imageFilm.setLayoutY(100);

                resumeFilm.setMaxWidth(300);
                resumeFilm.setWrapText(true);


                vBox.getChildren().addAll(imageFilm, nomFilm, anneeFilm, noteFilm, resumeFilm);

            }
        }
    }
}
