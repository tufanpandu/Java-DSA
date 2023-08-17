import java.util.*;

public class ArrayListBasic {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();

        // Operations
        // 1️⃣Add Element
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        int idx1 = 1;
        int idx2 = 3;
        // System.out.println(list);

        // 2️⃣ Get Element
        // int element = list.get(2);
        // System.out.println(element);
        // 3️⃣ Remove Element
        // list.remove(2);
        // System.out.println(list);

        // 4️⃣ Set Element at Index
        // list.set(2, 9);
        // System.out.println(list);

        // 5️⃣ Contains Element
        // System.out.println(list.contains(2));

        // 👉👉👉👉 Size of Array List
        // System.out.println(list.size());
        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        /// 👉👉👉👉 Print Reverse of an ArrayList
        // for (int i = list.size() - 1; i >= 0; i--) {
        // System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        //// 👉👉👉 Find Maximum in an Array List

        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        // if (max < list.get(i)) {
        // max = list.get(i);
        // }
        // }
        // System.out.println("max number is " + max);

        //// 👉👉👉👉👉 Swap 2 Numbers
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        ///// 👉👉👉👉👉👉Sorting an ArrayList
        //// Assending Order sort
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //// Decnedin Order sort
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }

}
