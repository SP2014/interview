import java.util.LinkedList;
import java.util.List;

class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    LinkedList<Integer> getAdj(int n) {
        return adj[n];
    }
}