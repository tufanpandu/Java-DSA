package Hashing;

import java.util.*;

public class HashingQ3 {
    
     //////////////////  Subarray Sum equal to K //////////////////
    public static void main(String[] args) {
        // int arr[] = { 10, 2, -2, -20, 10 };
        // int arr[] = { 1, 1, 1 };
        int arr[] = { 9, 4, 20, 3, 10, 5 };
        int k = 33;
        int prifixSum = 0; //Initilize a prifix sum with zero value.
        int ans = 0; // Number of sub array

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //First put (0,1 ) as key value pair for handle where prifixSum is equal to "K" in that case we get zero value .
        for (int i = 0; i < arr.length; i++) {
            prifixSum += arr[i]; // calculate the prifixSub
            if (map.containsKey(prifixSum - k)) { // Check if map is alredy have prifixSum- k vlaue key. then update the ans.
                ans += map.get(prifixSum - k); //Get the key value and add it on  ans 
            }

            map.put(prifixSum, map.getOrDefault(prifixSum, 0) + 1); //Put key as prifixSum  and value as check if map have prifixSum  then update the value by 1 and if not then assign the value 1.
        }
        System.out.println(ans);
    }
        

    }

