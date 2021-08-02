package jtech.firstTask;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MatrixMaxRowAvg {

    private List<MatrixRowAvg> rowAvgs = new ArrayList<>();

    public MatrixMaxRowAvg(String[][] matrix) {
        this.rowAvgs = Arrays.stream(matrix).map(MatrixRowAvg::new).collect(Collectors.toList());
    }

    public BigDecimal calculateMaxRowAvg() {
        return rowAvgs.stream().max(Comparator.comparing(MatrixRowAvg::getRowAvg)).get().getRowAvg();
    }
}
