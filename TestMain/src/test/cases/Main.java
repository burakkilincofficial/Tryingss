package test.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        fizzBuzz(n);
//
//        bufferedReader.close()

//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(3);
//        arr.add(6);
//        arr.add(9);
//        arr.add(3);
//
//        System.out.println("Sum = " + sumOfMinAbsDifferences(arr));

//        int[] sample = {5,5,5,5,5};
//        Solution solution = new Solution();
//        System.out.println(solution.solutionDifferBy1(sample));

//        AcademicSchedule academicSchedule = new AcademicSchedule();
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        String line;
//        List<String> input = new ArrayList<>();
//        input.add("7");
//        input.add("0 1 2");
//        input.add("1 3");
//        input.add("2 3");
//        input.add("3 4 5");
//        input.add("4 6");
//        input.add("5 6");
//        while ((line = in.readLine()) != null) {
//            input.add(line);
//        }
//        System.out.println(academicSchedule.schedule(input));

        TestMain testMain1 = new TestMain();
        System.out.println(testMain1.getStatusByAge(-1));
    }

    private static void test() {
        System.out.println("Test is successful");
    }

    private static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            if (i % 3 == 0 && i % 5 != 0) System.out.println("Fizz");
            if (i % 3 != 0 && i % 5 == 0) System.out.println("Buzz");
            if (i % 3 != 0 && i % 5 != 0) System.out.println(i);
        }

    }

    static int sumOfMinAbsDifferences(List<Integer> arr) {
        int[] array = arr.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);
        int sum = 0;
        int n = array.length;
        sum += Math.abs(array[0] - array[1]);
        sum += Math.abs(array[n - 1] - array[n - 2]);

        for (int i = 1; i < n - 1; i++) {
            sum +=
                    Math.min(Math.abs(array[i] - array[i - 1]),
                            Math.abs(array[i] - array[i + 1]));
        }

        return sum;
    }

    private static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
        int[][] arrays = after.stream()
                .map(list -> list.stream().mapToInt(i -> i).toArray())
                .toArray(int[][]::new);

        Integer[][] resultArray = new Integer[arrays[0].length][arrays[1].length];

        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays[1].length; i++) {
                if (arrays[i][0] == arrays[j][0]) {
                    resultArray[i][0] = arrays[i][0];
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (Integer[] ints : resultArray) {
            lists.add(Arrays.asList(ints));
        }
        return lists;

    }

    public static long modifyArray(List<Integer> arr) {
        int[] array = arr.stream().mapToInt(i -> i).toArray();
        int[] beforeSorted = array;
        boolean isDesc = true;
        if (array[0] > array[1]) isDesc = false;
        int violateInteger = 0;
        int indis = 0;
        for (int i = 0; i < array.length; i++) {
            if (isDesc && array[i] < array[i + 1]) {
                violateInteger = array[i + 1];
                indis = i;
            } else if (!isDesc && array[i + 1] > array[i]) {
                violateInteger = array[i];
                indis = i;
            }
        }
        Arrays.sort(array);
        int[] afterSorted = array;
        if (beforeSorted == afterSorted) return 0L;

        return beforeSorted[indis] - afterSorted[indis];
    }


}
