import java.util.*;

public class KosarajuAlgorrithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create Graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    // topSort
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean visit[], Stack<Integer> s) {
        visit[curr] = true;

        // find neighbour
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!visit[e.dest]) {
                topSort(graph, e.dest, visit, s);
            }
        }

        s.push(curr);
    }

    // dfs
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visit[]) {
        visit[curr] = true;
        // print the result
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {
                dfs(graph, e.dest, visit);
            }
        }
    }

    // Kosaraju Algorithms
    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        // Step - 1
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                topSort(graph, i, visit, s);
            }
        }

        // Steip -2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        // First iterate over graph
        for (int i = 0; i < graph.length; i++) {
            visit[i] = false; // Intilaze the visit
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); // Reverse Edge
            }
        }

        // Step - 3
        while (!s.isEmpty()) {
            int curr = s.pop();

            if (!visit[curr]) {
                System.out.print("SCC ->");
                // call dfs on transpose graph
                dfs(transpose, curr, visit);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
