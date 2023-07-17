package Hashing;

import java.util.*;
public class HashSet2 {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Koraput");
        cities.add("Rayagada");
        cities.add("Jeyopre");
        cities.add("Kalahandi");

        ///// Using Iterator interface and method

        Iterator it = cities.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //// Using Advanced for loop

        for (String city : cities) {
            System.out.println(city);
        }

    


        /////LinkedHashSet -> it follow the inserstion order which order we insert the element in that order print the element


        LinkedHashSet<String> lhs = new LinkedHashSet<>();
    
        lhs.add("Koraput");
        lhs.add("Rayagada");
        lhs.add("Jeyopre");
        lhs.add("Kalahandi");

        System.out.println(lhs);


        //// TreeSet -> it return 👉Sorted in assending order and not allowed👉 null value as key.

        TreeSet<String> ts = new TreeSet<>();

        ts.add("Koraput");
        ts.add("Rayagada");
        ts.add("Jeyopre");
        ts.add("Kalahandi");

        System.out.println(ts);

        TreeSet<Integer> ts1 = new TreeSet<>();

        ts1.add(24);
        ts1.add(12);
        ts1.add(45);
        ts1.add(78);
        ts1.add(55);

        System.out.println(ts);
    }
}
