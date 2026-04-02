import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class kahn {

    static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int next : adj.get(i)) {
                indegree[next]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Kahn’s Algorithm (BFS)
        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);
            for (int next : adj.get(top)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return result;
    }


    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 1);
        addEdge(adj, 5, 2);

        ArrayList<Integer> res = topoSort(adj);
        for (int vertex : res) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}
