package test.cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonCustomerReviews {
    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i < customerQuery.length(); i++) {
            String s = customerQuery.substring(0, i + 1).toLowerCase();
            List<String> temp = new ArrayList<>();
            int a = 0;
            for (String value : repository) {
                if (value.toLowerCase().startsWith(s)) {
                    temp.add(value.toLowerCase());
                    a++;
                }
            }
            Collections.sort(temp);
            List<String> v = new ArrayList<String>();
            for (int p = 0; p <= 2 && p < temp.size(); p++) {
                v.add(temp.get(p));
            }
            res.add(v);
        }
        return res;

    }

    public static void main(String[] args) throws IOException {
        List<String> testArray = new ArrayList<>();
        testArray.add("mobile");
        testArray.add("mouse");
        testArray.add("moneypot");
        testArray.add("monitor");
        testArray.add("mousepad");
        String customerQuery = "mouse";
        System.out.println(searchSuggestions(testArray, customerQuery));
    }

}
