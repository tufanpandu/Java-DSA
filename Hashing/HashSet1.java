package Hashing;

import java.util.*;
public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(3);
        set.add(5);
        set.add(2);
        set.add(3);

        System.out.println(set);

        System.out.println(set.size());
        System.out.println(set.contains(4));

        set.clear();
        System.out.println(set.size());
   }
}
