package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.SQLOutput;

public class Controller2 extends Calculations {

    @FXML
    public VBox vbox;

    int varco = variables;
    int consco = constraints;

    @FXML
    public TextArea testTextArea;

    @FXML
    public TextField zx1;
    public TextField zx2;
    public TextField ox1;
    public TextField ox2;
    public TextField ox11;
    public TextField ox22;
    public TextField oc1;
    public TextField oc2;


    @FXML
    protected void initialize() {
        for (int i = 1; i <= consco; i++) {
            HBox hb = new HBox();
            hb.setId(String.valueOf(i));
                for (int j = 1; j <= varco; j++) {
                    TextField tf = new TextField();
                    tf.setId(String.valueOf(i+j));
                    Label lab = new Label("x"+j);
                    hb.getChildren().addAll(tf,lab);
                    hb.setSpacing(5);
                }
            vbox.getChildren().add(hb);
        }

    }

    @FXML
    private void solve(ActionEvent event) {
        for (int i = 0; i < consco; i++) {
//            String idvbox = vbox.getChildren().get(i).getId();
//            System.out.println(idvbox);
            for (int j = 0; j < varco; j++) {
                ObservableList<Node> childsVB = vbox.getChildren();
                HBox hb2 = (HBox)childsVB.get(i);
                ObservableList<Node> childsHB = hb2.getChildren();
                TextField tf = (TextField)childsHB.get(2*j);
                System.out.println(tf.getText());

            }
        }
    }


//        @FXML
//    private void testButtonAction(ActionEvent event) {
//
//        try {
//            double rzx1 = Double.parseDouble(zx1.getText());
//            double rzx2 = Double.parseDouble(zx2.getText());
//            double rox1 = Double.parseDouble(ox1.getText());
//            double rox2 = Double.parseDouble(ox2.getText());
//            double rox11 = Double.parseDouble(ox11.getText());
//            double rox22 = Double.parseDouble(ox22.getText());
//            double roc1 = Double.parseDouble(oc1.getText());
//            double roc2 = Double.parseDouble(oc2.getText());
//            String res = test2(rzx1, rzx2, rox1, rox2, rox11, rox22, roc1, roc2);
//            testTextArea.setText(res);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }

}
