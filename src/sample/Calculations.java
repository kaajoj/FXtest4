package sample;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.SimplexSolver;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.sql.SQLOutput;
import java.util.Collection;

public class Calculations {
    public static int variables = 0;
    public static int constraints = 0;

    public static void prepareViewData(int var, int cons){
        variables = var;
        constraints = cons;
    }

    public static String calculate(Collection constrains, LinearObjectiveFunction lofInput, GoalType goalType) {
        String res = "Rozwiązania optymalne: ";
        double[] xVals = new double[variables];

        LinearObjectiveFunction lof = lofInput;
        Collection cons = constrains;

        LinearConstraintSet lcs = new LinearConstraintSet(cons);
        SimplexSolver simplexSolver = new SimplexSolver();

        PointValuePair result = simplexSolver.optimize(lof, lcs, goalType);

        for (int i = 0; i < variables; i++) {
            try {
                xVals[i] = Math.round(result.getPoint()[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        double minMax = Math.round(result.getValue());

        for (int i = 0; i < xVals.length; i++) {
            int j = i + 1;
            System.out.println("x"+j+""+xVals[i]);
            res += "x"+j+" = "+xVals[i]+"  ";
        }
        res += "\nFunkcja celu: "+minMax;
        System.out.println(minMax);
        System.out.println(res);

//        System.out.println("x1 ="+x1+"  x2 = "+x2+" x3 = "+x3+" "+minMax);
//        res = "Rozwiązania optymalne: x1 = "+x1+"  x2 = "+x2+ " x3 = "+x3+"\nFunkcja celu: "+minMax;
        return res;
    }

}
