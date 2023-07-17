package Hashing;

import java.util.*;

public class HashingQ1 {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // Get the Starting point.
            }
        }

        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        // System.out.print(start); // Starting point
        for (String key : tickets.keySet()) {
            System.out.print( start + " -> " + tickets.get(start) + " ,"); // this line give key value of tickets. // ye return karta hai key mumbai ki value Delhi.
            start = tickets.get(start); // Update the next starting point.

        }
        System.out.println();



    }
    
}
