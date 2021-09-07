package test.cases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AcademicSchedule {
    public String schedule(List<String> generalInput) {
        if (generalInput.isEmpty()) {
            return "";
        }
        int nCourse = Integer.parseInt(generalInput.get(0));
        generalInput.remove(0);
        List<String> lastDigits = new ArrayList<>();
        List<String> otherDigits = new ArrayList<>();
        for (String s : generalInput) {
            String[] sArray = s.split(" ");
            lastDigits.add(sArray[0]);
            for (int i = 1; i < sArray.length; i++) {
                otherDigits.add(sArray[i]);
            }
            Collections.sort(otherDigits, Collections.reverseOrder());

        }
        otherDigits.addAll(lastDigits);
        List<String> deduped = otherDigits.stream().distinct().collect(Collectors.toList());

        return deduped.toString();
    }
}
