package Graph;

import java.util.*;

public class Graph11 {
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
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    // Create Bellman Ford Function
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        // Create a distance array
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                /// Initialize vertex with infinity
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }
        // Store graph length in variable
        int V = graph.length;

        // Algorithm --> Run a loop i< v-1
        for (int i = 0; i < V - 1; i++) {
            // Find the Edges
            for (int j = 0; j < graph.length; j++) {
                // neighbour
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxtation
                    // dist[u] != Intege.MAX_VALUE mening if infinity is addition with any value
                    // then that become Negetive. It's not work like math in java and C++ like
                    // programming language it's work differently.
                    //
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        // print the path or distance array
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        bellmanFord(graph, 0);
    }
}
