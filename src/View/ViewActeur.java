package View;

import javafx.scene.Group;

public class ViewActeur {
    private Group root;
    private ViewHandler vhActeur;



    public ViewActeur(ViewHandler vhActeur, Group root) {
        this.root = root;
        this.vhActeur = vhActeur;


    }

     void initView() {
        root.getChildren().clear();
    }
}
