package Hashing;

import java.util.*;
public class HashSet3 {
    public static void main(String[] args) {
        // Count Distinct Element
        // int num[] = { 48, 3, 2, 55, 6, 7, 3, 48, 2, 1 };

        // HashSet<Integer> set = new HashSet<>();

        // for (int i = 0; i < num.length; i++) {
        //     set.add(num[i]);
        // }

        // System.out.println(set.size());
        // System.out.println(set);


        // 👉✅Union & Intersection of 2 arrays.

        // Union
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);

        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
         System.out.println(set);
        
         /// Intersection 
         set.clear();
       
         for (int i = 0; i < arr1.length; i++) {
             set.add(arr1[i]);
         }

         int count = 0;
         for (int i = 0; i < arr2.length; i++) {
             if (set.contains(arr2[i])) {
                 count++;
                 set.remove(arr2[i]);
                System.out.print(arr2[i]+" ");
             }
         }
         System.out.println();
         System.out.println(count);

    }
}
