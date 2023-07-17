package Hashing;

import java.util.*;

public class HashMap4 {
    public static boolean validAnagram(String s , String t) {
        HashMap<Character, Integer> map = new HashMap<>(); // Create a hashmap

        for (int i = 0; i < s.length(); i++) { // Run the loop first on s string .
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1); // put character and update frequency
        }

        for (int i = 0; i < t.length(); i++) { // Second loop run on t string.
            char ch = t.charAt(i);
            if (map.get(ch) != null) { // if have valid value/frequency
                if (map.get(ch) == 1) { //  if key have frequency one.
                    map.remove(ch); // remove from map
                } else { // if frequency is more then one.
                    map.put(ch, map.get(ch) - 1); // if key have more then one frequency then get ch and decrease by one  and put ch on map.
                }
            } else {// if Not valid value or frequency which is not present in map.
                return false; // after remove the char if some char are avilable on map then that is not valid valid char .
            }
        }
        return map.isEmpty(); // if map is empty return true.
       
    }

    public static void main(String[] args) {
        String s = "KEEN";
        String t = "KENL";

        System.out.println(validAnagram(s, t));
      

   }
}
