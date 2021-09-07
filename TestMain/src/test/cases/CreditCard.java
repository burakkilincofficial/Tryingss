package test.cases;

public class CreditCard {

    public String checkLuhn(String cardNo) {
        int cardNoLength = cardNo.length();

        int sum = 0;
        boolean isSecond = false;
        for (int i = cardNoLength - 1; i >= 0; i--) {
            int d = cardNo.charAt(i) - '0';

            if (isSecond) {
                d = d * 2;
            }
            sum += d / 10;
            sum += d % 10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0) ? "True" : "False";
    }

}
