import java.util.*;

public class Num_1 {
    private int V;
    private LinkedList<Integer> adj[];

    Num_1(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        DFS(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    void DFS(int v, boolean visited[]) {
        visited[v] = true;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    int countConnectedComponents() {
        boolean visited[] = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                DFS(i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        Num_1 graph = new Num_1(V);
        System.out.println("\nEnter the edges (vertex1 vertex2):");
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to);
        }

        if (graph.isConnected()) {
            System.out.println("\n-----------------------------------------");
            System.out.println("The graph is connected.");
        } else {
            int components = graph.countConnectedComponents();
            System.out.println("\n-----------------------------------------");
            System.out.println("The graph is not connected. It has " + components + " connected components.");
        }
    }
}
