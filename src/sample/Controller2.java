package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.Relationship;

import java.util.ArrayList;
import java.util.Collection;

public class Controller2 extends Calculations {

    @FXML
    public VBox vbox;

    int varco = variables;
    int consco = constraints;

    @FXML
    public TextArea TextArea;

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
        ObservableList<String> signs = FXCollections.observableArrayList("<=", "=", ">=");

        for (int i = 1; i <= consco; i++) {
            HBox hb = new HBox();
            hb.setId(String.valueOf(i));
                for (int j = 1; j <= varco; j++) {
                    TextField tf = new TextField();
                    tf.setId(String.valueOf(i+j));
                    tf.setPrefWidth(55);
                    Label lab = new Label("x"+j);
                    hb.getChildren().addAll(tf,lab);
                    hb.setSpacing(5);
                }
//            Label labempty = new Label();
//            labempty.setPrefWidth(50);
            ChoiceBox chbox = new ChoiceBox();
            chbox.setPrefWidth(55);
            chbox.setItems(signs);
            chbox.setValue("<=");
            TextField tflast = new TextField();
            tflast.setPrefWidth(55);
            hb.getChildren().addAll(chbox,tflast);
            vbox.getChildren().add(hb);
        }

    }

    @FXML
    private void solve(ActionEvent event) {
        Collection constrains = new ArrayList();
        ChoiceBox chbox2 = new ChoiceBox();
        TextField tf2 = new TextField();
        double[] variables = new double[varco];

        for (int i = 0; i < consco; i++) {
//            String idvbox = vbox.getChildren().get(i).getId();
//            System.out.println(idvbox);
            for (int j = 0; j < varco; j++) {
                ObservableList<Node> childsVB = vbox.getChildren();
                HBox hb2 = (HBox)childsVB.get(i);
                ObservableList<Node> childsHB = hb2.getChildren();
                TextField tf = (TextField)childsHB.get(2*j);
                System.out.println(tf.getText());
                variables[j] = Double.parseDouble(tf.getText());
//                System.out.println(variables[j]);
                if(j==(varco-1)) {
                    chbox2 = (ChoiceBox)childsHB.get((2*j)+2);
                    System.out.println(chbox2.getValue());
                    tf2 = (TextField)childsHB.get((2*j)+3);
                    System.out.println(tf2.getText());
                }
            }
            String relation = (String) chbox2.getValue();
            Relationship rel = Relationship.LEQ;
            switch (relation) {
                case "<=":
                    rel = Relationship.LEQ;
                    break;
                case "=":
                    rel = Relationship.EQ;
                    break;
                case ">=":
                    rel = Relationship.GEQ;
                    break;
            }
            constrains.add(new LinearConstraint(variables, rel, Double.parseDouble(tf2.getText())));
        }
        String res = test2(constrains);
        TextArea.setText(res);
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
//            TextArea.setText(res);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }

}
