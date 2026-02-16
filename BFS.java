import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//Level order traversal using Queue. O(V + E)
public  class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> result = new ArrayList<>();

        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }

        }
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

        BFS result  = new BFS();
        System.out.println(result.bfsOfGraph(V, adj));

    }

}
