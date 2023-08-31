import java.util.*;

///============ Tarjans Algorithms (Bridge in Graph) ===============================
public class TarjansBridgeAlgorithms {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    // (Depth first search) DFS function
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean visit[], int time) {
        // 1st - Visit the current node
        visit[curr] = true; // make current node is visited.
        // Update current node low and DT
        low[curr] = dt[curr] = ++time; // Assign discovery time and low value for the current node

        // iterate over graph and find the neighbour of current node
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest; // neighbour
            // Condition 1st - if parent and neighbour is equal then contineue to next
            // line.because we don't no their bridge is present or not
            if (neigh == par) {
                continue; // skip the parent node.
            } else if (!visit[neigh]) { // if neighbour is not visited
                dfs(graph, neigh, curr, dt, low, visit, time); // visit the unvisited neighbour
                // After complete dfs() when backtrack we update the current node lowest
                // Discovery time
                low[curr] = Math.min(low[curr], low[neigh]); // update the low value.

                // Print the bridge
                if (dt[curr] < low[neigh]) {
                    System.out.print("Bridge is " + curr + " ----- " + neigh);
                }
            } else {// if neighbour is alredy visited
                // update lowest discovery time
                low[curr] = Math.min(low[curr], dt[neigh]); // Update the low value using the neighbour discovery time.
            }

        }

    }

    // Tarjan's Bridge finding Algorithms (Bridge in Graph)
    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        // Create an called Discovery Time (dt)
        int dt[] = new int[V];
        // Lowest Discovery Time
        int low[] = new int[V];
        // Visit array for track node is visited or note
        boolean visit[] = new boolean[V];
        // time variable
        int time = 0; // time counter for discovery or visti

        // Iterate over node
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                dfs(graph, i, -1, dt, low, visit, time); // Start dfs from unvisited node
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);

    }

}
