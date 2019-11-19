package sample;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.Collection;

public class Calculations {
    public static int variables = 0;
    public static int constraints = 0;

    public static void prepareViewData(int var, int cons){
        variables = var;
        constraints = cons;
    }

    public static String calculate(Collection constrains, LinearObjectiveFunction lofInput, GoalType goalType) {
        String res;
        double x1=0;
        double x2=0;
        double x3=0;
        double x4=0;

        LinearObjectiveFunction lof = lofInput;
        Collection cons = constrains;

        LinearConstraintSet lcs = new LinearConstraintSet(cons);
        SimplexSolver simplexSolver = new SimplexSolver();

        PointValuePair result = simplexSolver.optimize(lof, lcs, goalType);

        try {
            x1 = Math.round(result.getPoint()[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            x2 = Math.round(result.getPoint()[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            x3 = result.getPoint()[2];
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            x4 = result.getPoint()[3];
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        double minMax = Math.round(result.getValue());
        System.out.println("x1 ="+x1+"  x2 = "+x2+" "+minMax);
        res = "Rozwiązania optymalne: x1 = "+x1+"  x2 = "+x2+"\nFunkcja celu: "+minMax;
        return res;
    }

}
