package Graph;

import java.util.*;

public class IsCycle {
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
        // Have Cycle
        // graph[1].add(new Edge(1, 0));

        // graph[0].add(new Edge(0, 2));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 0));

        // Not Cycle
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));
    }

    // isCycle
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        // Create boolean visited array for track vertex true or false.
        boolean vist[] = new boolean[graph.length];
        // create boolean stack
        boolean[] stack = new boolean[graph.length];

        // Run a loop on graphs all components.
        for (int i = 0; i < graph.length; i++) {
            // Check first component of graphs and check first vertex of graph is it
            // visited.
            if (!vist[i]) { // Not visited.
                if (isCycleUtil(graph, i, vist, stack)) { // if isCycleUtil function return true.
                    return true;
                }
            }
        }

        return false; // if Cycle not exists.
    }

    // Create isCycleUtil function
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vist[], boolean stack[]) {
        // First make vertex first visit and stack true.
        vist[curr] = true;
        stack[curr] = true;

        // find neighbour
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { // if inside the stack is neighbour is already present.
                return true; // cycle exist.
            }
            // Else if still we are not visiting in neighbour and then call recursively
            // isCycleUtil function and if this function return true . then cycle exisit.
            else if (!vist[e.dest] && isCycleUtil(graph, e.dest, vist, stack)) {
                return true;
            }
        }
        stack[curr] = false; // recursively return false.
        return false; // its return false if cycle is not exsit.
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
