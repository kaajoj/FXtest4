package sample;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.ArrayList;
import java.util.Collection;

public class Calculations {
    public static int variables = 0;
    public static int constraints = 0;

//    public static void test() {
//        LinearObjectiveFunction lof = new LinearObjectiveFunction(new double[] { 340, 404}, 0);
//        Collection cons = new ArrayList();
//        cons.add(new LinearConstraint(new double[] { 420, 760 }, Relationship.LEQ, 5480));
//        cons.add(new LinearConstraint(new double[] { 9, 5 }, Relationship.LEQ, 61));
//
//        LinearConstraintSet lcs = new LinearConstraintSet(cons);
//        SimplexSolver simplexSolver = new SimplexSolver();
//
//        PointValuePair result = simplexSolver.optimize(lof, lcs, GoalType.MAXIMIZE);
//
//        double x = result.getPoint()[0];
//        double y = result.getPoint()[1];
//        double min = result.getValue();
//
//        System.out.println("x ="+x+" y = "+y+" min="+min);
//    }

    public static void prepareViewData(int var, int cons){
        variables = var;
        constraints = cons;
    }

    public static String test2(Collection constrains) {
        String res = "";

        LinearObjectiveFunction lof = new LinearObjectiveFunction(new double[] { f1, f2}, 0);
        Collection cons = constrains;

        LinearConstraintSet lcs = new LinearConstraintSet(cons);
        SimplexSolver simplexSolver = new SimplexSolver();

        PointValuePair result = simplexSolver.optimize(lof, lcs, GoalType.MAXIMIZE);

        double x = result.getPoint()[0];
        double y = result.getPoint()[1];
        double min = result.getValue();

        System.out.println("x ="+x+" y = "+y+" min="+min);
        res = x + " " + " " + y + " " + min;
        return res;
    }

}
