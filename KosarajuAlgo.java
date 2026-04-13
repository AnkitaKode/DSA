//Strongly Connected Components (SCC) in Directed Graph O(V + E)
//Reverse DFS + Backtracking

// 1.Store nodes in stack(Topological Sort)
// 2. Transpose the graph (Reverse all edges)
// 3. Do DFS according  to transposed graph and stack order

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {

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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {

        vis[curr] = true;
        System.out.print(curr + " ");

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

   
    public static void topoSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {

        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                topoSort(graph, vis, s, e.dest);
            }
        }

        s.push(curr);
    }

    public static void kosarajuSCC(ArrayList<Edge>[] graph, int v) {

        // STEP 1 → Topological Order
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topoSort(graph, vis, s, i);
            }
        }

        // STEP 2 → Transpose Graph
        ArrayList<Edge>[] transpose = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            transpose[i] = new ArrayList<>();
            vis[i] = false;
        }

        for (int i = 0; i < v; i++) {
            for (Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // STEP 3 → DFS Using Stack Order
        while (!s.isEmpty()) {
            int curr = s.pop();

            if (!vis[curr]) {
                System.out.print("SCC: ");
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        kosarajuSCC(graph, v);
    }
}
