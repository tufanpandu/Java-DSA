package Graph;

// /////////////////👉👉 Bipartite Graph 😍 ////////////////////////////////////
import java.util.*;

public class BipartiteGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        // 1st Created new colour array
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // add No colour
        }
        // 2nd Create a queue
        Queue<Integer> q = new LinkedList<>();

        // 3rd Traverse whole component of graph .
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // no colour
                q.add(i); // add 0 to querue
                color[i] = 0; // yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    // find neighbour
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        // if neighbour have no colour
                        if (color[e.dest] == -1) { // no colour is exist
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextCol;
                            q.add(e.dest); // Now add destination in queue
                        }
                        // if neighbour have same colour
                        else if (color[e.dest] == color[curr]) {
                            return false;
                        }
                        // if neighbour have oppesite colour then do nothing continue.

                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        System.out.print(isBipartite(graph));

    }
}
