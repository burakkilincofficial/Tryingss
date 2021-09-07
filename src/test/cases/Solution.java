package test.cases;

public class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int result = 1;
        if (n < 3)
            return 0;

        int[] prefixSums = new int[n];
        for (int i = 1; i < n - 1; i++)
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                prefixSums[i] = prefixSums[i - 1] + 1;
            else
                prefixSums[i] = prefixSums[i - 1];
        prefixSums[n - 1] = prefixSums[n - 2];

        if (prefixSums[n - 1] <= 1)
            return prefixSums[n - 1];

        for (int i = 2; i <= prefixSums[n - 2]; i++) {
            if (n % i != 0)
                continue;
            int prev = 0;
            boolean containsPeak = true;
            for (int j = n / i - 1; j < n; j += n / i) {
                if (prefixSums[j] == prev) {
                    containsPeak = false;
                    break;
                }
                prev = prefixSums[j];
            }
            if (containsPeak)
                result = i;
        }

        return result;
    }

    public int solutionLikePyton(int[] A) {
        int sizeOfA = A.length;
        if (sizeOfA <= 1) return sizeOfA;
        if (sizeOfA == 2) return A[0] == A[1] ? 1 : 2;

        int hillNumber = 0;
        int valleyNumber = 0;
        int P = 0;
        int Q;
        for (int i = 0; i < sizeOfA; i++) {
            Q = i;
            if (A[P] != A[Q]) {
                P = Q;
            }
            if (Q < sizeOfA - 1) {
                if (A[Q] < A[Q + 1] && (P == 0 || A[P - 1] > A[P])) {
                    valleyNumber++;
                } else if (A[Q] > A[Q + 1] && A[P - 1] < A[P]) {
                    hillNumber++;
                }
            } else {
                if (A[P] > A[P - 1]) {
                    hillNumber++;
                }
            }
        }
        return hillNumber + valleyNumber;
    }

    public boolean solutionDifferBy1(int[] A) {
        boolean flagFirst = Boolean.FALSE;
        boolean flagEqual = Boolean.FALSE;
        boolean flagLength = Boolean.FALSE;
        boolean flagCasual = Boolean.FALSE;
        if (A.length < 2) {
            flagLength = false;
        } else if (A.length >= 2) {
            flagLength = true;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] == 1) {
                    flagFirst = false;
                }
                if (A[i] != 1) {
                    flagFirst = true;
                }
                if (A[i] == A[i + 1]) {
                    flagEqual = true;
                }
            }
        }
        if (flagFirst && flagLength && !flagEqual) {
            flagCasual = true;
        } else if (!flagFirst && !flagLength && flagEqual) {
            flagCasual = false;
        }
        return flagCasual;
    }


}
