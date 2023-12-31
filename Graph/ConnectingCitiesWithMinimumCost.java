import java.util.*;

///======= Connecting Cities with Minimum Cost ====================
public class ConnectingCitiesWithMinimumCost {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge c2) {
            return this.cost - c2.cost; // assendign order sort
        }
    }

    public static int connectingCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // for track vertex visited or not.
        boolean visit[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!visit[curr.dest]) { // Check condition if current vertex is visited or not
                visit[curr.dest] = true; // 1at - Make current vertex vistied true.
                finalCost += curr.cost; // add to the fina cost

                for (int i = 0; i < cities[curr.dest].length; i++) { // Iterate over cities array length.
                    if (cities[curr.dest][i] != 0) { // if cost is 0 then do nothing else add the destination and cost
                                                     // to the pq.
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        // return the final cost which is chepest cost or connected cities.
        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };

        System.out.println(connectingCities(cities));

    }
}
