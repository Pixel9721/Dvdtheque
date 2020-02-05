package View;

import Controller.ControllerMenu;
import View.ViewHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class ViewMainMenu {
    
    private ViewHandler vhMenu;
    private Button btnOption, btnQuit;
    private Group root;

    public ViewMainMenu(ViewHandler vhMenu, Group root) {
        this.vhMenu = vhMenu;
        this.root = root;

        btnOption = initButton(850,170,"Option");
        btnQuit = initButton(850,270,"Quitter");
        initView();
    }

     void initView() {
        root.getChildren().clear();
        root.getChildren().add(btnOption);
        root.getChildren().add(btnQuit);
    }

    private Button initButton(int largeur, int hauteur, String texteButton) {
        Button b = new Button();
        b.setLayoutX(largeur);
        b.setLayoutY(hauteur);
        b.setText(texteButton);
        return b;
    }

    //setter
    public void setEvents(ControllerMenu cm) {
        btnOption.setOnMouseClicked(cm);
        btnQuit.setOnMouseClicked(cm);
    }

    //getter
    public Button getBtnOption() {
        return btnOption;
    }
    public Button getBtnQuit() { return btnQuit; }
}
