import java.util.*;

public class Num_5 {
    private int V;
    private List<List<Integer>> adj;

    public Num_5(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public boolean isNum_5() {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isNum_5(i, color))
                    return false;
            }
        }
        return true;
    }

    public boolean isNum_5(int src, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        Num_5 graph = new Num_5(V);
        System.out.println("\nEnter the edges (vertex1 vertex2):");
        for (int i = 0; i < E; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }

        System.out.println("\n-----------------------------------------");
        if (graph.isNum_5()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
