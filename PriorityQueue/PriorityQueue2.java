import java.util.*;

public class PriorityQueue2 {
    static class Rows implements Comparable<Rows> {
        int soldier;
        int idx;

        public Rows(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Rows r2) {
            if (this.soldier == r2.soldier) { ///  if row one soldier count is equal with row two soldier count then sort based on Index.
                return this.idx - r2.idx; // Assending order sort

            } else {
                return this.soldier - r2.soldier; // Other weise sort based on Soldier coumt.
            }
        }
    }
    public static void main(String[] args) {
    int army[][] = {{ 1, 0, 0, 0 },
                    { 1, 1, 1, 1 },
                    { 1, 0, 0, 0 },
                    { 1, 0, 0, 0 }
                  };
    int k = 2;
    PriorityQueue<Rows> pq = new PriorityQueue<>();

    for (int i = 0; i < army.length; i++) {
        int count = 0;
        for (int j = 0; j < army[0].length; j++) {
            count += army[i][j] == 1 ? 1 : 0; // Ternary Method
        }
        pq.add(new Rows(count, i));
    }
    
    for (int i = 0; i < k ; i++) {
    System.out.println("R" + pq.remove().idx);
   }

   }
}
