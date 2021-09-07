package test.cases;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution2(9 ));
    }

    private static int solution(int N) {
        String binaryValue = convertIntegerToBinary(N);
        char[] charValues = binaryValue.toCharArray();
        int maxGap = 0;

        for (int i = 1; i < charValues.length; i++) {
            int i1 = charValues[i - 1] ^ charValues[i];
            if (i1 == 1) {
                maxGap++;
            } else {
                maxGap = 0;
            }
        }
        return maxGap;

    }

    private static String convertIntegerToBinary(int n) {
        return Integer.toBinaryString(n);
    }

    private static int solution2(int N) {
        int work = N;
        while (work > 0 && (work & 1) == 0) {
            work >>= 1;
        }
        work >>= 1;

        int max = 0;
        int zeros = 0;

        while (work > 0) {
            if ((work & 1) == 0) {
                zeros++;
            } else {
                max = Math.max(max, zeros);
                zeros = 0;
            }
            work >>= 1;
        }
        return max;
    }


}
