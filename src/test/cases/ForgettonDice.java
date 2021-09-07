package test.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForgettonDice {
    public static void main(String[] args) {
        int[] testArray = {3, 2, 4, 3};
        int[] solution = solution(testArray, 2, 4);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(" " + solution[i] + " ");
        }
    }

    static int[] solution(int[] A, int F, int M) {
        int sumOfArray = Arrays.stream(A).sum();
        int dividedValue = A.length + F;
        int shouldValue = dividedValue * M;
        int possibleValue = shouldValue - sumOfArray;
        double countValues = possibleValue / F;
        int mod = possibleValue % 6;
        int[] diceValues = {6, 5, 4, 3, 2, 1};

        List<Integer> resultArray = new ArrayList<>();
        List<Integer> newResultArray = new ArrayList<>();
        if (countValues > 6.0 || countValues <= 0) {
            return new int[]{0};
        }
        int sum = 0;
        int diceValue = 6;
        int sayac = 1;
        while (sum < possibleValue || diceValue > 0) {
            if ((sum + diceValue) <= possibleValue) {
                resultArray.add(diceValue);
                sum += diceValue;
            }
            diceValue--;
            sayac++;
        }

        return resultArray.stream().mapToInt(i -> i).toArray();
    }
}

