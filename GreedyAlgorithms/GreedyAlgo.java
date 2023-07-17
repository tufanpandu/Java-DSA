import java.util.*;
public class GreedyAlgo {
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
         ///Sorting
         int activity[][] = new int[start.length][3]; // create an 2d array
         for (int i = 0; i < start.length; i++) {
             activity[i][0] = i;  // index
             activity[i][1] = start[i]; // Start
             activity[i][2] = end[i]; // end

         }

         //Lambda Function -> Sortfrom
         Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

        //// End time base sorted
        int maxAct = 0; 
        ArrayList<Integer> ans = new ArrayList<Integer>(); // Create a ArrayList for stor Answear

        //// 1st activity -> Max activity is one which already pickup as a first work(1st Activity)
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2]; // Store the last index
        for (int i = 1; i < end.length; i++) {
            if (activity[i][1] >= lastEnd) { // if start of i th index  is grater then lastEnd 
                maxAct++;
                ans.add(activity[i][0]); // add the i th activity  on ans arraylist 
                lastEnd = activity[i][2];  /// update the last end 
            }
        }

        System.out.println("Max Activity = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();

    }
}
