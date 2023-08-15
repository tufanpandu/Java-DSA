import java.util.*;

// Prim's Algorithm
public class Graph12 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    // Creat Graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // add values in graph
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));

    }

    /// Create Pair class
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair c2) {
            return this.cost - c2.cost; // Assending order .
            // return c2.cost - this.cost ;// Desending order.
        }

    }

    // Create Prim's Algorithms function or MST or getMST
    public static void primAlgo(ArrayList<Edge> graph[]) {
        // step -1 Create boolean visit array for tracking node is already visit or not
        boolean vist[] = new boolean[graph.length];
        // Step-2 Create PriorityQueue for sort the pair as minimum value based on cost

        PriorityQueue<Pair> pq = new PriorityQueue();
        pq.add(new Pair(0, 0)); // add the source in to the pq.
        // Step -3 Initialize a variable finalcost for store the result
        int finalCost = 0;
        // Step -4 Run while loop while pq is empty
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vist[curr.v]) { // if current node is alredy not visited
                vist[curr.v] = true; // first make current node visited true.
                finalCost += curr.cost; // then add the weight or the current node into the finalcost variable.

                //// Find the neighbour
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);

                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.print(finalCost + " ");

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primAlgo(graph);
    }
}
