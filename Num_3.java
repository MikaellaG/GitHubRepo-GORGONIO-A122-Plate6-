import java.util.*;

public class Num_3 {
    private int V;
    private LinkedList<Integer>[] adj;

    public Num_3(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (isCyclicUtil(n, visited, recStack))
                return true;
        }

        recStack[v] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        Num_3 graph = new Num_3(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("\nEnter the edges (vertex1 vertex2):");
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to);
        }

        System.out.println("\n-----------------------------------------");
        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
