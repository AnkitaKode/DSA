import java.util.*;

//Depth First Search (DFS) + Undirected Graph + Adjacency List + O(V + E)
class DFS {

    public void dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {

        visited[curr] = true;
        result.add(curr);

        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, result);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();

        dfs(0, visited, adj, result);

        return result;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        DFS result = new DFS();
        System.out.println(result.dfsOfGraph(V, adj));
    }
}
