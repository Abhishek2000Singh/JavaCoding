package Part9_Hashing;

import java.util.*;;

public class Pq3_FindItinerary {

    public static String getStart(HashMap<String, String> tick) {

        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tick.keySet()) {
            // key -> key; val -> tick.get(Key)
            revMap.put(tick.get(key), key);
        }

        for (String key : tick.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; //start
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}