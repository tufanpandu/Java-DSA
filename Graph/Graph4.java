package Graph;
///////////////////// ✅👉Cycle Detection in Undirected graph 😍//////
import java.util.*;

public class Graph4 {
    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;

        }
    }

    public static void createGraphs(ArrayList<Edge>[] graph) {

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

        graph[4].add(new Edge(4, 3));
    }
    
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            // If First component vertex is not visit then call detectCycleUtil function.
            if (!visit[i]) {
                if (detectCycleUtil(graph, visit, i, -1)) {
                    return true;
                } // Parent is -1 because 0 don't have parent.
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visit[], int curr, int par) {
        //First Visti the Vertex and make true.
        visit[curr] = true;

        // Find Neighbour 
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // Case 1 -  Check if neighbour is not visited .
            if (!visit[e.des]) {
                //  and Detect Cycle then return true.
                if (detectCycleUtil(graph, visit, e.des, curr)) {
                    return true;
                }
            }
            // Case -2 If Neighbour is visited and not a parent.

            else if (visit[e.des] && e.des != par) {
                return true;
            }

            // Case - 3 If Neighbour visited and also Parent. then simple conteneue.
        }
       
        // If Cycle is not detect then return false .
        return false;
    }

    public static void main(String[] args) {
        
        
      int v = 5;
    @SuppressWarnings("unchecked")
     ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];
      createGraphs(graph);
       System.out.print(detectCycle(graph));
    }
}
