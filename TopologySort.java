import java.util.ArrayList;
import java.util.Stack;

//DAG
public class TopologySort {

    static class Edge {
        int source;
        int destination;

        public Edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 4));

    }

    static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {

        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.destination]) {
                topSortUtil(graph, e.destination, vis, stack);
            }
        }

        stack.push(curr);
    }

    static void topSort(ArrayList<Edge>[] graph, int v) {

        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        topSort(graph, v);
    }
}
