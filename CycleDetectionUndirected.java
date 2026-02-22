import java.util.ArrayList;

// Cycle Detection for Undirected Graph 
public class CycleDetectionUndirected {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create UNDIRECTED Graph
    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected Graph (Add both directions)

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));
    }

    // Cycle Detection for Undirected Graph
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 1: Not visited → DFS
            if (!vis[e.dest]) {
                if (isCycleUndirected(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            // Case 2: Visited but not parent → Cycle
            else if (e.dest != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {

        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];

        boolean hasCycle = false;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycleUndirected(graph, vis, i, -1)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle exists: " + hasCycle);
    }
}
