package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.ArrayList;
import java.util.Collection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void test() {
        LinearObjectiveFunction lof = new LinearObjectiveFunction(new double[] { 340, 404}, 0);
        Collection cons = new ArrayList();
        cons.add(new LinearConstraint(new double[] { 420, 760 }, Relationship.LEQ, 5480));
        cons.add(new LinearConstraint(new double[] { 9, 5 }, Relationship.LEQ, 61));

        LinearConstraintSet lcs = new LinearConstraintSet(cons);
        SimplexSolver simplexSolver = new SimplexSolver();

        PointValuePair result = simplexSolver.optimize(lof, lcs, GoalType.MAXIMIZE);

        double x = result.getPoint()[0];
        double y = result.getPoint()[1];
        double min = result.getValue();

        System.out.println("x ="+x+" y = "+y+" min="+min);
    }

}
