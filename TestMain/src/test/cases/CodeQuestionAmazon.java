package test.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeQuestionAmazon {
    static long solution(List<Long> cars, int k) {
        Long[] itemsArray = new Long[cars.size()];
        itemsArray = cars.toArray(itemsArray);
        Arrays.sort(itemsArray);
        long windowStart = 0, windowEnd = k - 1, ans = Long.MAX_VALUE;
        for (;windowEnd < itemsArray.length; windowStart++, windowEnd++) {
            ans = (int) Math.min(ans, itemsArray[(int) windowEnd] - itemsArray[(int) windowStart] + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Long> cars = new ArrayList<>();
        cars.add(2l);
        cars.add(10l);
        cars.add(8l);
        cars.add(17l);
        int k =3;
        System.out.println(solution(cars, k)); // 5
    }
}
