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
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.ArrayList;
import java.util.Collection;

public class Controller2 extends Calculations {

    @FXML
    public VBox vbox;
    public HBox hbox;

    int varco = variables;
    int consco = constraints;

    @FXML
    public TextArea TextArea;

    @FXML
    public ChoiceBox choiceBoxGoal;

    @FXML
    protected void initialize() {
        ObservableList<String> signs = FXCollections.observableArrayList("<=", "=", ">=");
        ObservableList<String> goals = FXCollections.observableArrayList("max", "min");

        for (int i = 1; i <= consco; i++) {
            HBox hb = new HBox();
            hb.setId(String.valueOf(i));
                for (int j = 1; j <= varco; j++) {
                    TextField tf = new TextField();
                    tf.setId(String.valueOf(i+j));
                    tf.setPrefWidth(60);
                    Label lab = new Label("x"+j);
                    hb.getChildren().addAll(tf,lab);
                    if(j < varco) {
                        Label labPlus2 = new Label("+");
                        hb.getChildren().add(labPlus2);
                    }
                    hb.setSpacing(5);

                    if(i==1) {
                        TextField tf2 = new TextField();
                        tf2.setPrefWidth(60);
                        Label lab2 = new Label("x" + j);
                        hbox.getChildren().addAll(tf2, lab2);
                        if(j < varco) {
                            Label labPlus = new Label("+");
                            hbox.getChildren().add(labPlus);
                        }
                    }
                }
            hbox.setSpacing(5);

            ChoiceBox chbox = new ChoiceBox();
            chbox.setPrefWidth(55);
            chbox.setItems(signs);
            chbox.setValue("<=");
            TextField tflast = new TextField();
            tflast.setPrefWidth(60);
            hb.getChildren().addAll(chbox,tflast);
            vbox.getChildren().add(hb);
        }
        choiceBoxGoal.setItems(goals);
        choiceBoxGoal.setValue("max");
    }

    @FXML
    private void solve(ActionEvent event) {
        Collection constrains = new ArrayList();
        LinearObjectiveFunction lof;
        ChoiceBox chbox2 = new ChoiceBox();
        TextField tf2 = new TextField();
        double[] variables = new double[varco];
        double[] objFunVars = new double[varco];

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
                if(i==1) {
                    ObservableList<Node> childsHB2 = hbox.getChildren();
                    TextField tf3 = (TextField)childsHB2.get(2*j);
//                    System.out.println(tf3.getText());
                    objFunVars[j] = Double.parseDouble(tf3.getText());
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
        lof = new LinearObjectiveFunction(objFunVars, 0);

        String goal = (String) choiceBoxGoal.getValue();
        GoalType goealType =  GoalType.MAXIMIZE;
        switch (goal) {
            case "max":
                goealType = GoalType.MAXIMIZE;
                break;
            case "min":
                goealType = GoalType.MINIMIZE;
                break;
        }

        String res = calculate(constrains, lof, goealType);
        TextArea.setText(res);
    }

}
