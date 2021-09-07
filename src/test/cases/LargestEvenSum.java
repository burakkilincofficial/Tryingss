package test.cases;

import java.util.ArrayList;
import java.util.Collections;

public class LargestEvenSum {
    static int evenSumK(int A[], int K) {
        if (A == null) {
            return -1;
        }
        int N = A.length;

        // for 4. requirement
        if (K > N) {
            return -1;
        }

        int maxSum = 0;
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        // mix the array
        for (int j : A) {
            if (j % 2 == 1) {
                oddNumbers.add(j);
            } else {
                evenNumbers.add(j);
            }
        }
        //sorts
        Collections.sort(oddNumbers);
        Collections.sort(evenNumbers);

        int currentIndexForEven = evenNumbers.size() - 1;
        int currentIndexForOdd = oddNumbers.size() - 1;

        while (K > 0) {
            if (K % 2 == 1) {
                if (currentIndexForEven >= 0) {
                    maxSum += evenNumbers.get(currentIndexForEven);
                    currentIndexForEven--;
                } else {
                    return -1;
                }
                K--;
            } else if (currentIndexForEven >= 1 && currentIndexForOdd >= 1) {
                if (evenNumbers.get(currentIndexForEven) + evenNumbers.get(currentIndexForEven - 1)
                        <= oddNumbers.get(currentIndexForOdd) + oddNumbers.get(currentIndexForOdd - 1)) {

                    maxSum += oddNumbers.get(currentIndexForOdd) + oddNumbers.get(currentIndexForOdd - 1);
                    currentIndexForOdd -= 2;
                } else {
                    maxSum += evenNumbers.get(currentIndexForEven) + evenNumbers.get(currentIndexForEven - 1);
                    currentIndexForEven -= 2;
                }
                K -= 2;
            } else if (currentIndexForEven >= 1) {

                maxSum += evenNumbers.get(currentIndexForEven) + evenNumbers.get(currentIndexForEven - 1);
                currentIndexForEven -= 2;
                K -= 2;
            } else if (currentIndexForOdd >= 1) {
                maxSum += oddNumbers.get(currentIndexForOdd) + oddNumbers.get(currentIndexForOdd - 1);
                currentIndexForOdd -= 2;
                K -= 2;
            }
        }
        return maxSum;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {4, 9, 2, 8, 6};
        int arr2[] = {5, 6, 3, 4, 2};
        int K = 5;

        System.out.println(evenSumK(arr, K));
//        System.out.println(evenSumK(arr2, K));
    }
}
