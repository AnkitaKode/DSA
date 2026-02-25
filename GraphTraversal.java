import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

    // Graph using adjacency list
    static class Graph {
        int vertices;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            vertices = v;
            adj = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // Add edge
        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // remove if directed graph
        }

        // BFS
        void BFS(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            System.out.print("BFS Traversal: ");

            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println();
        }

        // DFS
        void DFS(int start) {
            boolean[] visited = new boolean[vertices];
            System.out.print("DFS Traversal: ");
            dfsHelper(start, visited);
            System.out.println();
        }

        void dfsHelper(int node, boolean[] visited) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        g.BFS(0);
        g.DFS(0);
    }
}
