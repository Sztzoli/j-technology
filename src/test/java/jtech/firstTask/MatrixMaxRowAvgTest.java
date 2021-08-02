package jtech.firstTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMaxRowAvgTest {

    MatrixMaxRowAvg matrixMaxRowAvg = new MatrixMaxRowAvg(TestDataI.MATRIX);

    @Test
    void test() {
        System.out.println(matrixMaxRowAvg.getRowAvgs());
        System.out.println(matrixMaxRowAvg.calculateMaxRowAvg());
    }
}