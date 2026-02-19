import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//Priority Queue + nonnegative weight edges + directed graph + weighted graph + shortest path from source to all vertices 
//Time Complexity: O(E log V) 
public class DijkstraAlgo {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 2));
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 3, 7));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 3, 4));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 5));
        graph[3].add(new Edge(3, 1, 2));
        graph[3].add(new Edge(3, 2, 1));
       
/*    (0) -----> (1)
     |  \        ^
    2|   \7      |1
     v    v      |
    (2) -----> (3)
       \   4     ^
        \        |
         \1      |2
          -----> (1)
*/


    }

    public static int[] dijkstra(ArrayList<Edge>[] graph, int src, int V) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new int[] { src, 0 });

        while (!pq.isEmpty()) {

            int[] curr = pq.remove();
            int node = curr[0];

            if (vis[node])
                continue;

            vis[node] = true;

            for (Edge e : graph[node]) {

                int u = node;
                int v = e.destination;

                if (dist[u] + e.weight < dist[v]) {
                    dist[v] = dist[u] + e.weight;
                    pq.add(new int[] { v, dist[v] });
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int[] result = dijkstra(graph, 0, V);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("0 -> " + i + " = " + result[i]);
        }
    }
}
