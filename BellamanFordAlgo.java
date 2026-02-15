import java.util.ArrayList;

// Negative weights + Detects negative cycle + Time Complexity: O(V * E) + O(E) for negative cycle check
//The algorithm works by relaxing all edges repeatedly for V-1 times.If we can still relax any edge after V-1 iterations, it means there is a negative weight cycle in the graph.
public class BellamanFordAlgo {

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

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));// -10 for negative cycle
    }

    public static void bellamanFord(ArrayList<Edge> graph[], int src, int V) {
        int dist[] = new int[V];

        // Step 1: Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 2: Relax edges V-1 times
        for (int k = 0; k < V - 1; k++) {

            for (int i = 0; i < V; i++) {

                for (int j = 0; j < graph[i].size(); j++) {

                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;

                    if (dist[u] != Integer.MAX_VALUE &&
                            dist[u] + e.weight < dist[v]) {

                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        // negative cycle (nested code of bellamanFord)
        for (int i = 0; i < V; i++) {

            for (int j = 0; j < graph[i].size(); j++) {

                Edge e = graph[i].get(j);
                int u = e.source;
                int v = e.destination;

                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + e.weight < dist[v]) {

                    System.out.println("Negative Cycle Exists");

                }
            }
        }

        // // Step 3: Check Negative Cycle
        // for (int i = 0; i < V; i++) {
        // for (Edge e : graph[i]) {

        // int u = e.source;
        // int v = e.destination;

        // if (dist[u] != Integer.MAX_VALUE &&
        // dist[u] + e.weight < dist[v]) {

        // System.out.println("Negative Cycle Exists");
        // return;
        // }
        // }
        // }

        // Step 4: Print shortest distances
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bellamanFord(graph, 0, V);
    }
}
