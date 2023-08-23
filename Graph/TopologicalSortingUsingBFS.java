package Graph;

import java.util.*;

public class TopologicalSortingUsingBFS {
    // Topological Sorting Using BFS
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

    /// Calculate Indegree

    public static void calcIndegree(ArrayList<Edge>[] graph, int indegree[]) {
        // Iterate over graph
        for (int i = 0; i < graph.length; i++) {
            //// Iterate graph's first component vertex.
            // Find the neighbour
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                // Now increase indegree of vertex by one
                indegree[e.dest]++;
            }

        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();

        // Iterate over indegree array.
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Call BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            // Find curr value neighbour
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--; // decrease by one

                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }

            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        topSort(graph);
    }
}
