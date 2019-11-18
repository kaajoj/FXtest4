package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Controller2 extends Calculations {

    @FXML
    public HBox hbox1;
    
    @FXML
    protected void initialize() {
        int varco = variables;
        int consco = constraints;
        for (int i = 0; i < varco; i++) {
            hbox1.getChildren().add(new Button("Click me!"));
            //        TextField tf1 = new TextField ();
            //        Label lab1 = new Label("x:");
            //        hbox1.getChildren().addAll(lab1, tf1);
            //        ((Group) viewScene.getRoot()).getChildren().addAll(hbox1);
            //        hbox1.setSpacing(10);

//            varco;
//            consco
        }

    }


}
