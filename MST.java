//Prim's Algorithm Greedy + Priority Queue.
//All nodes connected + undirected graph + weighted graph + min weight + no cycle 
//Time complexity: O(E log V)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
 
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 3, 50));
    }

record Pair(int node, int cost) {}

public static void PrimsAlgo(ArrayList<Edge>[] graph, int V) {

    PriorityQueue<Pair> pq =new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

    boolean[] vis = new boolean[V];

    pq.add(new Pair(0, 0));

    int mstCost = 0;

    // Store selected nodes + cost
    ArrayList<Pair> ans = new ArrayList<>();

    while (!pq.isEmpty()) {

        Pair curr = pq.remove();

        if (!vis[curr.node()]) {

            vis[curr.node()] = true;
            mstCost += curr.cost();

            //Store node and cost
            ans.add(curr);

            for (Edge e : graph[curr.node()]) {

                if (!vis[e.destination]) {
                    pq.add(new Pair(e.destination, e.weight));
                }
            }
        }
    }

    System.out.println("Minimum Spanning Tree Cost: " + mstCost);

    // Print stored nodes and cost
    System.out.println("Nodes included in MST:");
    for (Pair p : ans) {
        System.out.println("Node: " + p.node() + " Cost: " + p.cost());
    }
}


    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        PrimsAlgo(graph, V);
    }

}
