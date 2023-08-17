import java.util.*;

public class MD_ArrayList {
    //// ✅✅✅👉 Container with most Water step 2:
    // public static int storeWater(ArrayList<Integer> height) {
    // int maxWater = 0;
    // for (int i = 0; i < height.size(); i++) {
    // for (int j = i + 1; j < height.size(); j++) {
    // int ht = Math.min(height.get(i), height.get(j));
    // int width = j - i;
    // int currWater = ht * width;
    // maxWater = Math.max(maxWater, currWater);
    // }
    // }
    // return maxWater;
    // }

    ///// ✅✅✅✅👉 2 Pointer Approch

    // public static int storeWater(ArrayList<Integer> height) {
    // int maxWater = 0;
    // int lp = 0;
    // int rp = height.size() - 1;
    // // Loop
    // while (lp < rp) {
    // // Calculat water area
    // int ht = Math.min(height.get(lp), height.get(rp));
    // int width = rp - lp;
    // int currWater = ht * width;
    // maxWater = Math.max(maxWater, currWater);
    // // Update Pointer
    // if (height.get(lp) < height.get(rp)) {
    // lp++;
    // } else {
    // rp--;
    // }
    // }
    // return maxWater;

    // }

    ////// 👉👉👉👉✅ Pair sum 1 Brute Force Approch

    // public static boolean pairSum(ArrayList<Integer> list, int target) {

    // for (int i = 0; i < list.size(); i++) {
    // for (int j = i + 1; j < list.size(); j++) {
    // if (list.get(i) + list.get(j) == target) {
    // return true;
    // }

    // }
    // }
    // return false;
    // }

    ////// 👉👉👉👉✅ Pair sum 1 Brute Force Approch
    // public static boolean pairSum1(ArrayList<Integer> list, int target) {
    // int lp = 0;
    // int rp = list.size() - 1;
    // while (list.get(lp) != list.get(rp)) {
    // // Case 1
    // if (list.get(lp) + list.get(rp) == target) {
    // return true;
    // }
    // // Case 2
    // if (list.get(lp) + list.get(rp) < target) {
    // lp++;
    // } else {
    // // Case 3
    // rp--;
    // }
    // }
    // return false;
    // }

    ////// 👉👉👉👉✅ Pair sum 2 Brute Force Approch

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;
        while (lp != rp) {
            // Case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp = (n + 1) % n;

            } else {
                // Case 3
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ///// ✅✅✅ Multi Dimensional ArrayList

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(2);
        // list.add(2);
        // list.add(2);
        // mainList.add(list);

        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(3);
        // list1.add(3);
        // list1.add(3);
        // mainList.add(list1);

        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);
        // for (int j = 0; j < currList.size(); j++) {
        // System.out.print(currList.get(j) + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(mainList);

        //// _______________________________________________________________________________________________________
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for (int i = 1; i <= 5; i++) {
        // list1.add(i * 1); // 1,2,3,4,5
        // list2.add(i * 2); // 2,4,6,8,10
        // list3.add(i * 3); // 3,,6 ,9,12,15

        // }
        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);
        // System.out.println(mainList);
        // //// Nested Loop
        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);
        // for (int j = 0; j < currList.size(); j++) {
        // System.out.print(currList.get(j) + " ");

        // }
        // System.out.println();
        // }

        //// ✅✅✅👉 Container with most Water step 1:
        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        // System.out.println(height);
        // System.out.print(storeWater(height));

        ////// 👉👉👉👉✅ Pair sum 1 Brute Force Approch
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // int target = 5;

        // System.out.println(pairSum1(list, target));

        ////// 👉👉👉👉✅ Pair sum 2 Brute Force Approch

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSum2(list, target));
    }
}