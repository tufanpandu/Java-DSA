package Graph;

import java.util.*;

public class DFS {
    static class Edge {
        int src;
        int des;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.weight = w;
        }
    }

    static void createGraphs(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) { // iterate whole graph length
            graph[i] = new ArrayList<>();// cerate new arraylist on every index of graph.
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

    }

    //// BFS - Breadth First Search
    public static void bfs(ArrayList<Edge> graph[]) {
        // Create a Queue for track Numbers.
        Queue<Integer> q = new LinkedList<>();
        // Create a Boolean array for track visited true or false.
        boolean visit[] = new boolean[graph.length];
        q.add(0); // Starting point or source code.

        while (!q.isEmpty()) {// While queue is not empty
            int curr = q.remove(); // temove number from queue and store it on .

            if (!visit[curr]) {
                // Print and visit
                System.out.print(curr + " ");
                visit[curr] = true;
                // find the Neighbours.
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    // DFS - Defth first search
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visit[]) {
        // Visit and print
        System.out.print(curr + " ");
        visit[curr] = true;
        // Find Neighbours and call dfs() function recursively.
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); // It give me neighbours of curr
            // Now check visited is true or false if true then call dfs recursively.
            if (!visit[e.des]) {
                dfs(graph, e.des, visit);
            }

        }
    }

    // ///Q.1️⃣ Has Path ?
    // For given src and des .tell if a path exists from src to dest.
    // src =0; , dest =5;.

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean visit[]) {
        // Check if src is equal to dest or not
        if (src == des) {
            return true;
        }
        // Update visit
        visit[src] = true;

        // Fint Neighbour of src
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            // check if src is visited or not and call recursively hasPath() function.
            if (!visit[e.des] && hasPath(graph, e.des, des, visit)) {
                return true;
            }
        }
        return false; // if any edge is not found.
    }

    public static void main(String[] args) {
        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

        // ArrayList<Edge> graph[] = new ArrayList[v];
        createGraphs(graph);
        System.out.print(hasPath(graph, 0, 5, new boolean[v]));
    }
}
