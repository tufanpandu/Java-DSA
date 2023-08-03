import java.util.*;

// Bellman Ford Algorithm
class Main {
    // Inner class representing an edge in the graph
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

    // Function to create the graph with sample edges and weights
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

    // Bellman Ford Algorithm to find the shortest distances from the source vertex
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        // Create distance array to store shortest distances from the source
        int dist[] = new int[graph.length];

        // Initialize all distances to "infinity" (represented by Integer.MAX_VALUE)
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // Run V-1 iterations to find the shortest distances
        for (int i = 0; i < V - 1; i++) {
            // Traverse all edges in the graph
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    // Get the current edge
                    Edge e = graph[j].get(k);

                    // Relaxation step: Update the distance to the destination vertex if a shorter
                    // path is found
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Print the shortest distances from the source vertex to all other vertices
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph); // Create the sample graph
        bellmanFord(graph, 0); // Find the shortest distances from vertex 0 (source)
    }
}
