import java.util.*;


public class graph {

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

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();

        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 3, 4));
        graph[2].add(new Edge(2, 1, 1));

    }

    public static void main(String[] args) {
        int v = 4;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        for (int i = 0; i < graph[1].size(); i++) {
            Edge e = graph[1].get(i);
            System.out.println(e.destination + ", " + e.weight);

        }

    }
}
