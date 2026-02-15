import java.util.ArrayList;
//Time Complexity: O(V + E)
public class ArticulationPoint {
    static class Edge {
        int src;
        int dest;

        Edge(int u, int v) {
            src = u;
            dest = v;
        }

    }

    public static void createGraph(ArrayList<Edge>[] graph) {

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

    public static void dfs(ArrayList<Edge>[] graph, int curr, int parent, boolean[] vis, int[] dt, int[] low, int time,
            boolean isArticulation[]) {
        vis[curr] = true;

        dt[curr] = low[curr] = time++;

        int childCount = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == parent) {
                continue; // Ignore the edge to parent
            }
            if (!vis[e.dest]) {
                childCount++;
                dfs(graph, e.dest, curr, vis, dt, low, time, isArticulation);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // Check if the current node is an articulation point
                if (parent != -1 && dt[curr] <= low[e.dest]) {
                    isArticulation[curr] = true;
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
                if (dt[curr] <= low[e.dest] && parent != -1) {
                    isArticulation[curr] = true;
                }
                childCount++;

            }
        }

        // If the current node is the root of DFS and has more than one child, it's an
        // articulation point
        if (parent == -1 && childCount > 1) {
            isArticulation[curr] = true;
        }

    }

    public static void getArticulationP(ArrayList<Edge>[] graph, int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean vis[] = new boolean[v];
        boolean isArticulation[] = new boolean[v];
        int time = 0;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time, isArticulation);
            }
        }

        for (int i = 0; i < v; i++) {
            if (isArticulation[i]) {
                System.out.println("Articulation Point found: " + i);
            }
        }

    }

    public static void main(String[] args) {

        int v = 6;

        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        getArticulationP(graph, v);

    }
}
