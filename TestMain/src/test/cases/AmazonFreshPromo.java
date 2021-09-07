package test.cases;

public class AmazonFreshPromo {
    public static void main(String[] args) {
        String[][] codeArray1 = {{"Banana", "anything", "apple"}, {"anything", "orange", "kiwi", "banana"}};
        String[][] codeArray2 = {{"anything", "anything"}, {"banana", "papaya", "anything", "blueberries"}};
        String[][] codeArray3 = {};
        String[][] codeArray4 = {{}};

        String[] cartArray1 = {"Banana", "mango", "apple", "cherry", "orange", "kiwi", "banana"};
        String[] cartArray2 = {"Banana", "mango", "banana", "papaya", "blueberries", "blueberries"};
        String[] cartArray3 = {"Banana", "mango", "pineapple", "papaya", "blueberries", "blueberries"};
        String[] cartArray4 = {"Banana", "mango", "banana", "papaya", "blackberries", "blueberries"};
        String[] cartArray5 = {"Banana", "Banana", "Banana", "mango", "apple", "cherry", "orange", "kiwi", "banana"};

        System.out.println(freshPromotion(codeArray1, cartArray1));
        System.out.println(freshPromotion(codeArray2, cartArray2));
        System.out.println(freshPromotion(codeArray3, cartArray3));
        System.out.println(freshPromotion(codeArray4, cartArray4));
        System.out.println(freshPromotion(codeArray1, cartArray5));

        System.out.println(freshPromotion(codeArray2, cartArray1));
        System.out.println(freshPromotion(codeArray1, cartArray2));
        System.out.println(freshPromotion(codeArray2, cartArray3));
        System.out.println(freshPromotion(codeArray1, cartArray4));
    }

    private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0, codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) && hasOrder(shoppingCart, cartIdx, codeList[codeIdx])){
                cartIdx += codeList[codeIdx++].length;
            }else{
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }
}
