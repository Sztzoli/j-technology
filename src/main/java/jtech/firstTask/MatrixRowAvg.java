package jtech.firstTask;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Data
public class MatrixRowAvg {

    private final BigDecimal rowAvg;

    public MatrixRowAvg(String[] line) {

        BigDecimal sum = Arrays.stream(line)
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO,
                        BigDecimal::add);
        this.rowAvg = sum.divide(new BigDecimal(line.length), 3, RoundingMode.HALF_UP);
    }
}
