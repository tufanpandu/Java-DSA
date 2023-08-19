import java.util.*;

public class Graph16 {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge w2) {
            return this.wt - w2.wt;
        }
    }

    /// Create Graph
    public static void createGraph(ArrayList<Edge> edges) {
        // Edge - not a adjocent list
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    //
    static int n = 4;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    // Intialize the parent array
    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Create Find() mehtod
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        // call find() method recursively
        // compresed code
        return parent[x] = find(parent[x]);
    }

    /// Create union function
    public static void union(int a, int b) {
        // First find parA and ParB
        int parA = find(a);
        int parB = find(b);

        // Check condition
        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }

    // =================== Kruskal's Algorithm ======================
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        // 1st -call the initialize function
        init();
        // 2nd - Sort the edges
        Collections.sort(edges);
        // 3rd- intialize the finalCost and count variable for store the Answere.
        int finalCost = 0;
        int count = 0;

        // 4th - run a for loop still v-1 condition satisfie.
        // find minimum edge.
        for (int i = 0; count < V - 1; i++) {
            Edge e = edges.get(i);
            // This Edge e have (src ,dest ,wt)
            int parA = find(e.src); // src = a
            int parB = find(e.dest); // dest = b
            // if parA == parB then cycle is detect and if not
            if (parA != parB) { // Not cycle
                union(parA, parB); // make union if not cycle .
                finalCost += e.wt; // add e.wt to the finalCost.
                count++; // now update the count.
            }
        }
        // Print the finalCost
        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);
    }
}
