package test.cases;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(8);
        array.add(5);
        array.add(94);
        array.add(6);
        array.add(44);
        array.add(77);
        array.add(4);
        array.add(11);
        array.add(10);
        array.add(-3);
        System.out.println(findMinimistSecondValue(array));

    }

    private static int findMinimistSecondValue(List<Integer> array) {
        int MIN_VALUE = Integer.MAX_VALUE;
        int MIN_VALUE2 = Integer.MAX_VALUE;
        for (Integer number : array) {
            if (number < MIN_VALUE) {
                MIN_VALUE2 = MIN_VALUE;
                MIN_VALUE = number;
            } else if (number < MIN_VALUE2 && number != MIN_VALUE) {
                MIN_VALUE2 = number;
            }

        }
        return MIN_VALUE2;
    }
}
