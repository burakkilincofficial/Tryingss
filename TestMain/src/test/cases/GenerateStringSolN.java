package test.cases;

public class GenerateStringSolN {
    public static void main(String[] args) {

        System.out.println(generateTheString(7));
    }

    private static String generateTheString(int n) {
        StringBuilder str = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                str.append("a");
            }
            str.append("b");
        } else {
            for (int i = 0; i < n; i++)
                str.append("c");
        }

        return str.toString();
    }
}

