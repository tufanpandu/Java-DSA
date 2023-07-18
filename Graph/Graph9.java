package Graph;
import java.util.*;
//////All Path From Source to Target ////
public class Graph9 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    
    // Create Graph
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void findAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        // Check if the source is equal to the destination
        if (src == dest) {
            // If so, we have reached the destination, so we print the current path
            System.out.println(path + dest);
        }
        
        // Find the neighbors of the source node
        for (int i = 0; i < graph[src].size(); i++) {
            // Get the i-th neighbor of the source node
            Edge e = graph[src].get(i);
            
            // Recursively call the findAllPath method with the destination as the current neighbor
            // and the updated path as the current path concatenated with the source node
            findAllPath(graph, e.dest, dest, path + src);
        }
    }
    

    public static void main(String [] args){
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
      findAllPath(graph, 5, 1, "");
        
    }
}