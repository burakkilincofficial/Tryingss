package test.cases;

import java.util.*;

public class ArrivalAndDuration {
    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        int companies = arrival.size();

        if (companies < 2) {
            return companies;
        }
        int max = 0;
        int nextAvailableTime = arrival.get(0);

        Map<Integer, PriorityQueue<Integer>> arrivalDurationMap = getArrivalDurationMap(arrival, duration);

        for (int c = 0; c < companies; c++) {
            Integer arrivalTime = arrival.get(c);
            Integer eventDuration = arrivalDurationMap.get(arrivalTime).poll();

            if (arrivalTime >= nextAvailableTime) {
                max++;
                nextAvailableTime = arrivalTime + eventDuration;
            } else if (thereIsTimeToAddThisEvent(arrival, nextAvailableTime, c, eventDuration)) {
                max++;
                nextAvailableTime += eventDuration;
            }
        }
        return max;
    }

    private static boolean thereIsTimeToAddThisEvent(List<Integer> arrival, int nextAvailableTime, int c,
                                                     Integer eventDuration) {

        List<Integer> distinctArrivals = new ArrayList<>(new HashSet<>(arrival));
        int index = distinctArrivals.indexOf(arrival.get(c));

        if (index + 1 < distinctArrivals.size()) {
            return nextAvailableTime + eventDuration <= distinctArrivals.get(index + 1);
        }

        return index == distinctArrivals.size() - 1;
    }

    private static Map<Integer, PriorityQueue<Integer>> getArrivalDurationMap(List<Integer> arrival,
                                                                              List<Integer> duration) {

        Map<Integer, PriorityQueue<Integer>> durationByArrival = new HashMap<>();

        for (int i = 0; i < arrival.size(); i++) {
            Integer arrivalTime = arrival.get(i);
            Integer durationValue = duration.get(i);

            if (!durationByArrival.containsKey(arrivalTime)) {
                durationByArrival.put(arrivalTime, new PriorityQueue<>(Arrays.asList(durationValue)));
            } else {
                durationByArrival.get(arrivalTime).add(durationValue);
            }
        }

        return durationByArrival;
    }

    public static void main(String[] args) {
        List<Integer> arrivals = new ArrayList<>();
        List<Integer> durations = new ArrayList<>();
        arrivals.add(1);
        arrivals.add(3);
        arrivals.add(5);
        durations.add(2);
        durations.add(2);
        durations.add(2);
        System.out.println(maxEvents(arrivals, durations));
    }
}
