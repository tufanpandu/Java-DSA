import java.util.*;
import java.util.LinkedList;

/// - 👉👉👉Chepest Flights within K stops.🧑‍💻
///// - All values are positive.

public class Graph13 {
    // Edge Class
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    // create graph
    public static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        // Initilize every vertex of graph with empty arraylist.
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Iterarte over flight 2D array
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            // Create an empty Edge variabele
            Edge e = new Edge(src, dest, wt);
            // Now add to the graph
            graph[src].add(e); // In 2D array every index of first index is src .
        }
    }

    /// Create an Info class
    static class Info {
        int v;
        int cost;
        int stop;

        // constructor
        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    //// Create Chepest flights function
    public static int chepestFlights(int n, int flights[][], int src, int dest, int k) {
        // Create Graph
        ArrayList<Edge> graph[] = new ArrayList[n];
        // Call Create graph function
        createGraph(graph, flights);

        // Now start my original function

        // create dist array for store path or cost
        int dist[] = new int[n];

        // Initialize every vertex with +infinity
        for (int i = 0; i < dist.length; i++) {
            // Excluding src make all vertex infinity
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Create a Queue Data Structure for store Information .
        Queue<Info> q = new LinkedList<>();
        // add first vertex into the queue.
        q.add(new Info(src, 0, 0));

        /// Run while loop still Queue is not empty
        while (!q.isEmpty()) {
            // remove from queue and store into the Info variable .
            Info curr = q.remove();

            // Check condition if current stop is greater then "k" the break the while loop.
            if (curr.stop > k) {
                break;
            }

            // Now write a Dijkstre Algorighms like code.
            // find the neighbour of current vertex.
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relaxtion code
                // Method - 1️⃣
                /*
                 * - First if dist[u] is not equal to Integer.MAX_VALUE then do the process
                 * because if in java if infinit value is add with integer then it's return
                 * negetive value.
                 * - Second dist[u] + wt is less than dist[v]
                 * -Third if current stop is less than equal to k then do the process.
                 * 
                 * --👉🧑‍💻 if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] &&
                 * curr.stop <= k) {
                 * dist[v] = dist[u] + wt;
                 * q.add(new Info(v, dist[v], curr.stop + 1));
                 * }
                 * 
                 * 
                 */

                // Method -2️⃣ ✅ Correct way to write code !
                /*
                 * - Check condtion if current.cost + wt is less than dist[v].
                 * -- Using curr.cost ensures we're using the cost of the current path, avoiding
                 * outdated costs from previous paths. This way, we accurately track the current
                 * path's expense.
                 * 
                 */

                if (curr.cost + wt < dist[v] && curr.stop <= k) {
                    dist[v] = dist[u] + wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }

            }
        }

        /*
         * if (dist[dest] == Integer.MAX_VALUE): This condition checks if the value
         * stored in the dist array for the destination vertex is still the initial
         * value Integer.MAX_VALUE. If it is, it means that the destination vertex
         * hasn't been reached
         */
        if (dist[dest] == Integer.MAX_VALUE) { // if dist[dest] is still infinity that means still we don't reach the
                                               // destination.
            return -1;
        } else {
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 1, 3, 600 }, { 2, 0, 100 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;
        System.out.println(chepestFlights(n, flights, src, dest, k));
    }
}
