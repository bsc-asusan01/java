import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Triangle {
    private List<Double> sides;
    private int sideUniqueCount = 0;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        /*
        Type         UniqueCount    Note
        equilateral: 1              - all 3 sides equal length
        isosceles:   1~2            - 2 or 3 sides equal length
        scalene:     3              - all 3 sides Not equal length
        */
        sides = Arrays.asList(side1, side2, side3);
        if (valid(sides)) {
            sideUniqueCount = sides.stream()
                .collect(
                    Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .size();
        } else {
            throw new TriangleException();
        }
    }

    private static boolean valid(List<Double> sides) {
        Collections.sort(sides);
        return sides.get(0) + sides.get(1) > sides.get(2);
    }

    boolean isEquilateral() { return sideUniqueCount == 1; }

    boolean isIsosceles() { return sideUniqueCount <= 2; }

    boolean isScalene() { return sideUniqueCount == 3;   }

}
