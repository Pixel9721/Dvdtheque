package View;

import Controller.ControllerRealisateur;
import Dvdtheque.BDDManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewRealisateur {

        private Group root;
        private ViewHandler vhActeur;
        private Button btnBackMainP;
        private Label nom, prenom, image;
        private Text titreActeur;
        private VBox vBox;

        public ViewRealisateur(ViewHandler vhActeur, Group root) {
            this.root = root;
            this.vhActeur = vhActeur;

            btnBackMainP = initButton("Retour", 80, 800);
            titreActeur = iniTitre("Réalisateur", 150,200);

        }
        void initView(){
            root.getChildren().clear();
            root.getChildren().addAll(btnBackMainP);
            root.getChildren().addAll(titreActeur);
            viewListe();
        }

        public void viewListe(){
            vBox = new VBox();

            ScrollPane scroll = new ScrollPane();

            BDDManager bdd = new BDDManager();
            bdd.start();

            ArrayList<ArrayList<String>> ListeActeur = bdd.ask("SELECT * FROM Dvdtheque.realisateur ORDER BY Id_Realisateur DESC");

            for (int i = 0; i < ListeActeur.size(); i ++) {
                Label nomActeur = new Label(ListeActeur.get(i).get(1));
                Label prenomActeur = new Label(ListeActeur.get(i).get(2));

                //ImageView imageActeur = new ImageView("Assets/images/Realisateurs/vin.jpg");

                System.out.println(ListeActeur);
                bdd.stop();
                nom = initLabel("Nom :",250, 470);
                prenom = initLabel("Prenom:", 250, 380);
                image = initLabel("Photo :",250,350);

                vBox.setLayoutX(350);
                vBox.setLayoutY(450);
                vBox.setAlignment(Pos.CENTER);
                VBox.setMargin(nom, new Insets(30,0,0,0));
                //VBox.setMargin(imageActeur, new Insets(0,0,0,30));

                //imageActeur.setFitWidth(250);
                //imageActeur.setFitHeight(250);
                //imageActeur.setLayoutX(100);
                //imageActeur.setLayoutY(100);
                image.setLayoutY(100);


                vBox.getChildren().addAll(nom,nomActeur, prenom,prenomActeur, image/*,imageActeur*/);

            }
            scroll.setContent(vBox);
            scroll.setPrefHeight(550);
            scroll.setPrefWidth(420);
            scroll.setLayoutX(550);
            scroll.setLayoutY(250);

            root.getChildren().add(scroll);
        }



        private Button initButton(String texteButton, int largeur, int hauteur) {
            Button b = new Button();
            b.setText(texteButton);
            b.setLayoutX(largeur);
            b.setLayoutY(hauteur);
            b.getStyleClass().add("btnStyle");
            b.setFont (Font.font ("Aclonica", 20));
            return b;
        }

        private Text iniTitre(String texteTitre, int largeur, int hauteur){
            Text ti = new Text();
            ti.setText(texteTitre);
            ti.setLayoutX(largeur);
            ti.setLayoutY(hauteur);
            ti.setFill(Color.BLACK);
            ti.setFont (Font.font ("Aclonica", 180));
            return ti;
        }
        private TextField initTextField(int largeur, int hauteur){
            TextField f = new TextField();
            f.setLayoutX(largeur);
            f.setLayoutY(hauteur);
            return f;
        }
        private Label initLabel(String texteLabel, int largeur, int hauteur  ){
            Label l = new Label();
            l.setLayoutX(largeur);
            l.setLayoutY(hauteur);
            l.setTextFill(Color.BLACK);
            l.setText(texteLabel);
            l.setFont (Font.font ("Aclonica", 20));
            return l;
        }

        public void setEvents(ControllerRealisateur cm) {
            btnBackMainP.setOnMouseClicked(cm);
        }

        public void setEventsBack(ControllerRealisateur cm) { btnBackMainP.setOnMouseClicked(cm); }
        public void setBtnBackMainP(Button btnBackMainP) { this.btnBackMainP = btnBackMainP; }

        //setter
        public void setNom(Label nom) { this.nom = nom; }
        public void setPrenom(Label prenom) { this.prenom = prenom; }
        public void setImage(Label image) { this.image = image; }


        //getter
        public Button getBtnBackMainP() { return btnBackMainP; }

        public Label getNom() { return nom; }
        public Label getPrenom() { return prenom; }
        public Label getImage() { return image; }



    }

