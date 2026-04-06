import java.util.Arrays;
class KruskalsAlgo {
    // Inner class for Union-Find (DSU)
    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        // Find with Path Compression
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        // Union by connecting roots
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }

    public int kruskal(int V, int[][] edges) {
        // 1. Sort edges by weight (index 2)
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        UnionFind uf = new UnionFind(V);
        int sum = 0;
        int edgesCount = 0;

        // 2. Iterate through sorted edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];

            // 3. If u and v are not in the same set, add edge to MST
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                sum += wt;
                edgesCount++;
                
                // Optimization: MST has exactly V-1 edges
                if (edgesCount == V - 1) break;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        KruskalsAlgo kruskal = new KruskalsAlgo();
        int V = 4;
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };
        System.out.println("Weight of MST is " + kruskal.kruskal(V, edges));
    }
}