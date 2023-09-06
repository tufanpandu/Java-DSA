import java.util.*;

///======== Find Articulation Point (Tarjans Algorithms) ======================================
public class TarjansArticulationPoint {
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

  // Dfs
  public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], boolean ap[],
      int time) {
    // Visit current node
    vis[curr] = true;
    // Initialze bt and low
    dt[curr] = low[curr] = ++time;
    // cildren or disconnected node or unvisited node
    int children = 0;

    // finc neighbour
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      int neigh = e.dest;// neighbour
      // Check condition
      // par == neigh
      if (par == neigh) {
        continue; // do nothing
      } else if (vis[neigh]) { // allready visited neighbour.
        // update low[curr]
        low[curr] = Math.min(low[curr], dt[neigh]);
      } else {// not visited neighbour
        // Call dfs method recursiverly
        dfs(graph, neigh, curr, dt, low, vis, ap, time);
        // When backtrack we update the low[]
        low[curr] = Math.min(low[curr], low[neigh]);
        // Check AP conditon (2nd inner loop condition)
        if (par != -1 && dt[curr] <= low[neigh]) {
          ap[curr] = true; // geting the AP point
        }
        // update the cildren for current node
        children++;
      }
    }

    // Check AP (1st outer loop condition)
    if (par == -1 && children > 1) {
      ap[curr] = true;
    }
  }

  // Tarjan Algo for Articulation point

  public static void getAP(ArrayList<Edge> graph[], int V) {
    // Create Discovery time array for visiting track of node
    int dt[] = new int[V];
    // lowest Discovery Time
    int low[] = new int[V];
    // visit Array to track node for not enter into loop
    boolean vis[] = new boolean[V];
    // AP array for not print Articulation Point repetedly
    boolean ap[] = new boolean[V];
    // time variable for counter of discovery
    int time = 0;

    // Iterate over all node
    for (int i = 0; i < V; i++) {
      // not visite of vertex
      if (!vis[i]) {
        // dfs
        dfs(graph, i, -1, dt, low, vis, ap, time);
      }
    }

    // print ap
    for (int i = 0; i < V; i++) {
      if (ap[i]) { // ap of current visited true
        System.out.println("AP : " + i); // Print Articulation point
      }
    }
  }

  public static void main(String[] args) {

    int V = 6;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    getAP(graph, V);

  }
}