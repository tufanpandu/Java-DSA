package Hashing;

import java.util.*;

public class HashingQ2 {
    public static int largestSubarray(int arr[] ) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0, -1);
        int prifixSum = 0; 
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {// Run for loop on array
            prifixSum += arr[i]; // calculate the prifixSum
            if (!map.containsKey(prifixSum)) { // Map not contains key
                map.put(prifixSum, i); //  put ps as key and "i" index as value  on map

            } else { // map contains key 
                // int length = i - map.get(prifixSum) ;
                // maxLength = Math.max(maxLength, length);
                maxLength = Math.max(maxLength, i - map.get(prifixSum));  // calculate the maxlength
            }
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int ans = largestSubarray(arr);
        System.out.println(ans);
    }
}
