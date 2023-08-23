package Graph;

import java.util.*;

//// Graphs Traversal
/// (a) Breadth First Search (BFS)
public class BFS {

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

    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>(); // Create a queue
        boolean visited[] = new boolean[graph.length]; // Create boolean array which size is same with graph length.
        q.add(0); // Starting Point

        while (!q.isEmpty()) {// while Queue is not empty
            int curr = q.remove(); // 1st- remove frome queue

            if (!visited[curr]) { /// If curr vertex is not visited (Means visit false) 2nd - check not visit
                System.out.print(curr + " "); // 3rd - print curr
                visited[curr] = true; // 4th - difine visit of curr is now true.
                for (int i = 0; i < graph[curr].size(); i++) { // iterate the graphs curr size
                    Edge e = graph[curr].get(i);
                    q.add(e.des); // 5th - add the negibours of curr in queue
                }
            }
        }
    }

    public static void main(String[] args) {

        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraphs(graph);
        bfs(graph);
    }
}
