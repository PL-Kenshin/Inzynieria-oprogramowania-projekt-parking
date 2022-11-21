package pl.deniskurek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import java.util.Arrays;

class WeightedMaxSatSolverTest {
    @Test
    void MaxSatSolver(){
        WeightedMaxSatSolver solver = new WeightedMaxSatSolver(3,4);
        try {
            solver.addClause(4,new int[] {1,2,-3});
            solver.addClause(7,new int[]{-1,2,3});
            solver.addClause(11,new int[]{-1,-2,-3});
            solver.addClause(9,new int[]{1,-2,3});

            var result = solver.model();
            Assertions.assertTrue(result.isPresent());
            System.out.println(Arrays.toString(solver.model().get().toArray()));
        }catch (ContradictionException | TimeoutException e) {
            e.printStackTrace();
        }
    }


}