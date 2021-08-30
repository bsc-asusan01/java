import java.util.Arrays;
import java.util.stream.Stream;

public class Matrix {
    private int[][] rows;

    public Matrix(String matrixAsString) {
        rows =
            Stream.of(matrixAsString.split("\n"))
                .map(
                    s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()
                )
            .toArray(int[][]::new);
    }

    public int[] getRow(int rowNumber) {
        return rows[rowNumber -1].clone();
    }

    public int[] getColumn(int columnNumber) {
        return Arrays.stream(rows).map(row -> row[columnNumber-1]).mapToInt(i -> i).toArray().clone();
    }

}