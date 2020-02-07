package View;

import Controller.ControllerMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;


public class ViewMainMenu {
    
    private ViewHandler vhMenu;
    private VBox vBox, vBox2;
    private Button btnOption, btnQuit;
    private Group root;
    private Text titreM;

    public ViewMainMenu(ViewHandler vhMenu, Group root) {
        this.vhMenu = vhMenu;
        this.root = root;

        vBox = new VBox();
        vBox.setLayoutX(0);
        vBox.setLayoutY(0);
        vBox.setMinWidth(Screen.getPrimary().getBounds().getWidth());
        vBox.setMinHeight(Screen.getPrimary().getBounds().getHeight());
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setBackground(new Background(new BackgroundImage(
                new Image("Assets/images/bobine_cinema.png"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));


        btnOption = initButton("Option");
        VBox.setMargin(btnOption,new Insets(150,0,30,0));
        btnQuit = initButton("Quitter");
        titreM = iniTitre("DVDTEHQUE",90);
        vBox.getChildren().addAll(btnOption, btnQuit);

        initView();
    }

     void initView() {
        root.getChildren().clear();
        root.getChildren().add(vBox);
    }

    private Text iniTitre(String texteTitre, int size){
        Text ti = new Text();
        ti.setFont(Font.font(size));
        ti.setText(texteTitre);
        return ti;
    }

    private Button initButton(String texteButton) {
        Button b = new Button();
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
