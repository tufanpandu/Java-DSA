package Graph;

import java.util.*;

public class TopologicalSortingUsingDFS {
    // Topological Sorting using DFS
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0)) & graph[1].add(new Edge(0)) No destination

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        // Create boolean vist and Stack
        boolean vist[] = new boolean[graph.length];
        Stack<Integer> s = new Stack();

        // Iterate graph component
        for (int i = 0; i < graph.length; i++) {
            if (!vist[i]) {
                // Call the topSortUtility function
                topSortUtil(graph, i, vist, s);
            }
        }

        /// Print the stack stored element.
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vist[], Stack<Integer> s) {
        vist[curr] = true;

        // find current neighbour
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vist[e.dest]) {
                topSortUtil(graph, e.dest, vist, s);
                ;
            }
        }

        // push values in stack

        s.push(curr);
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        topSort(graph);
    }
}
