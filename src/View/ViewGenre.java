package View;

import javafx.scene.Group;

public class ViewGenre {
    private Group root;
    private ViewHandler vhGenre;


    public ViewGenre( ViewHandler vhGenre, Group root) {
        this.root = root;
        this.vhGenre =vhGenre;

    }

    void initView() {
    }
}
