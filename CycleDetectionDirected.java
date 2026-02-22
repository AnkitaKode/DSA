import java.util.ArrayList;

// Directed Graph + Cycle Detection
public class CycleDetectionDirected {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed Graph
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

 
    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]) {

        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // Case 1: Node already in recursion stack
            if (rec[e.dest]) {
                return true;
            }

            // Case 2: Visit unvisited node
            else if (!vis[e.dest]) {
                if (isCycleDirected(graph, vis, e.dest, rec)) {
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static void main(String args[]) {

        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];

        boolean hasCycle = false;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean isCycle = isCycleDirected(graph, vis, i, rec);
                if (isCycle) {
                    hasCycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle exists: " + hasCycle);
    }
}
