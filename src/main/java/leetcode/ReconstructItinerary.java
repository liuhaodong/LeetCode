package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by haodongl on 2/6/16.
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary test = new ReconstructItinerary();
        String[] itr1 = {"JFK", "ATL"}, itr2 = {"ORD", "PHL"}, itr3 = {"JFK", "ORD"}, itr4 = {"PHX", "LAX"}, iter5 = {"LAX", "JFK"}, iter6 = {"PHL", "ATL"}, itr7 = {"ATL", "PHX"};
        String[][] testData = {itr1, itr2, itr3, itr4, iter5, iter6, itr7};
        System.out.println(test.findItinerary(testData));

    }

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> itinerarys = new HashMap<String, PriorityQueue<String>>();
        Map<String, Integer> airportCount = new HashMap<String, Integer>();

        List<String> result = new ArrayList<String>();

        if (tickets == null || tickets.length == 0) {
            return result;
        }

        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            if (!airportCount.containsKey(start)) {
                airportCount.put(start, 1);
            } else {
                airportCount.put(start, airportCount.get(start) + 1);
            }

            if (!airportCount.containsKey(end)) {
                airportCount.put(end, -1);
            } else {
                airportCount.put(end, airportCount.get(end) - 1);
            }

            if (!itinerarys.containsKey(start)) {
                PriorityQueue<String> queue = new PriorityQueue<String>();
                queue.add(end);
                itinerarys.put(start, queue);
            } else {
                itinerarys.get(start).add(end);
            }

        }

        String startAirport = "";

        for (String start : itinerarys.keySet()) {
            if (airportCount.get(start) == 1) {
                startAirport = start;
            }
        }

        if (startAirport.equals("")) {
            for (String start : itinerarys.keySet()) {
                if (airportCount.get(start) == 0) {
                    startAirport = start;
                }
            }
        }

        String current = startAirport;

        while (current != null && !current.equals("")) {
            result.add(current);
            if (itinerarys.get(current) == null) {
                break;
            }
            String possible = null;

            String end = "";

            for (String tmp : itinerarys.get(current)) {
                if (airportCount.get(tmp) != -1 || airportCount.get(tmp) == -1 && (itinerarys.get(tmp) != null && itinerarys.get(tmp).size() > 0)) {
                    possible = tmp;
                    break;
                } else {
                    end = tmp;
                }
            }

            if (possible == null) {
                possible = end;
            }

            itinerarys.get(current).remove(possible);

            current = possible;
        }

        return result;
    }


}
