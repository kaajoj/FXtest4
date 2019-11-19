package sample;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.Collection;

public class Calculations {
    public static int variables = 0;
    public static int constraints = 0;

    public static void prepareViewData(int var, int cons){
        variables = var;
        constraints = cons;
    }

    public static String test2(Collection constrains, LinearObjectiveFunction lofInput) {
        String res = "";

        LinearObjectiveFunction lof = lofInput;
        Collection cons = constrains;

        LinearConstraintSet lcs = new LinearConstraintSet(cons);
        SimplexSolver simplexSolver = new SimplexSolver();

        PointValuePair result = simplexSolver.optimize(lof, lcs, GoalType.MAXIMIZE);

        double x1 = result.getPoint()[0];
        double x2 = result.getPoint()[1];
//        double x3 = result.getPoint()[2];
//        double x4 = result.getPoint()[3];
        double minMax = result.getValue();

        System.out.println("x1 ="+x1+"  x2 = "+x2+" "+minMax);
        res = "Rozwiązania optymalne: x1 = "+x1+"  x2 = "+x2+"\nFunkcja celu: "+minMax;
        return res;
    }

}
