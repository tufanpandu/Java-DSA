package Graph;

import java.util.*;

/// Dijkstra's Algorithms

public class DijkstrasAlgorithms {

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

    // Create Graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    // Create on pair class which short based on path
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // Sorting Based on Path
        }
    }

    // Create a Dijkstra's Fucition

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        // Create an distance array for storing sortest path
        int dist[] = new int[graph.length];
        // Run a loop for iterate on graph
        for (int i = 0; i < graph.length; i++) {
            // If "i" and src is equal then by default return "0" .
            // If not equal then initilize dist[i] as plus infinity || dist[i] mening src to
            // i distance.
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity.
            }
        }
        // Create an boolean visit array for tracking vertex is alredy visited or not.
        boolean visit[] = new boolean[graph.length];

        // Create an Priorityqueue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // Add the src first into the priorityQueue
        pq.add(new Pair(src, 0));

        // Now run a loop while priorityQueue is not empty
        while (!pq.isEmpty()) {
            // Remove value from pq
            Pair curr = pq.remove();
            // Check if curr.n is already visited or not.
            if (!visit[curr.n]) {
                // Do current node visited
                visit[curr.n] = true;
                // Find the current node neighbour
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // Main Algorithms of Dijkstra's Algorithms
                    if (dist[u] + wt < dist[v]) { // Update the dist[v] value.
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v])); // Add the value into the queue
                    }
                }
            }
        }

        // Print the all path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);

    }
}