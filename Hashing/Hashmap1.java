package Hashing;
import java.util.*;
public class Hashmap1 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        //Put in HashMap - O(1)
        hm.put("India", 125);
        hm.put("China", 200);
        hm.put("Indonesia", 50);

        System.out.println(hm);

        //get form HashMap - O(1)
        int population = hm.get("China");
        System.out.println(population);

        //// containKey(key) -- O(1)  it's always return boolean value 
        System.out.println(hm.containsKey("India")); // It's avilable inside the HashMap so it's return true.
        System.out.println(hm.containsKey("Nepal")); // It's not avilabe inside the HashMap so it's return false.


        //remove(key) -- O(1)
        // System.out.println(hm.remove("India"));
        // System.out.println(hm);

        //isEmpty()
        System.out.println(hm.isEmpty());

        //size()
        System.out.println(hm.size());

        //clear()
        hm.clear();
    }
}
