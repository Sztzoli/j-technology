package jtech.firstTask;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Matrix {


    public static void main(String[] args) {
        BigDecimal max = BigDecimal.ZERO;
        for (String[] row : TestDataI.MATRIX) {
            BigDecimal sum = BigDecimal.ZERO;
            for (String number : row) {
                sum = sum.add(new BigDecimal(number));
            }
            sum = sum.divide(new BigDecimal(row.length),3, RoundingMode.HALF_UP);
            if (max.compareTo(sum) < 0) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
