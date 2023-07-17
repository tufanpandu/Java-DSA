import java.util.*;

public class Heap5 {

    ////// Nearby Cars Problem //////
    static class Point implements Comparable<Point> {
        int x; // X - Cordenator
        int y;  //Y - cordenator
        int disSqr; // Store distance squer
        int idx; // Store index 

        public Point(int x, int y, int disSqr, int idx) {
            this.x = x;
            this.y = y;
            this.disSqr = disSqr;
            this.idx = idx;
        }


        @Override
        public int compareTo(Point s2) {
            return this.disSqr - s2.disSqr;  // Asending order sort
        }
       }
    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;


        PriorityQueue1<Point> pq = new PriorityQueue1<>(); // create a priority queue

        for (int i = 0; i < pts.length; i++) {
            int disSqr = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], disSqr, i));
        }
      
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }

    }
}
