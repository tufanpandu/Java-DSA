import java.util.*;

public class PriorityQueue3 {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = val;
        }

        @Override

        public int compareTo(Pair p2) {
            // For dessending order sort
            return p2.val- this.val;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
       int res[] = new int[arr.length -k +1]; // store the result
       PriorityQueue<Pair> pq = new PriorityQueue<>();

       // Add first window in pq
       for (int i = 0; i < k; i++) { // store the window
           pq.add(new Pair(arr[i], i));
       }
      
       res[0] = pq.peek().val;

       for (int i = k; i < arr.length; i++) {
           while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
               pq.remove();
           }
           pq.add(new Pair(arr[i], i));
           res[i - k + 1] = pq.peek().val; /// Update the index with i  like  now i = 3 and k =3 (3-3+1) =1, (4-3+1) =2, (5-3 +1)=3

       }

       // Now print the result
       for (int i = 0; i < res.length; i++) {
        System.out.print(res[i] + " ");
       }

    }
}
