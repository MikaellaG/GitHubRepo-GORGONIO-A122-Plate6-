import java.util.*;

public class Num_8 {

    private static boolean areIsomorphic(int[][] graph1, int[][] graph2, int V) {
        if (V != graph2.length) // If the number of vertices are different, then graphs cannot be isomorphic
            return false;

        // Create an array to mark visited vertices in the second graph
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Compare each vertex of graph1 with a vertex of graph2
        for (int i = 0; i < V; i++) {
            boolean flag = false;
            for (int j = 0; j < V; j++) {
                // If graph1 has an edge from i to j, then graph2 must also have an edge from
                // the corresponding vertices
                if (graph1[i][j] != graph1[j][i] || graph2[i][j] != graph2[j][i])
                    return false;

                // If graph1 has an edge from i to j, then the degree of vertex i must be equal
                // to the degree of vertex j
                if (graph1[i][j] != 0 && graph2[i][j] != 0 && graph1[i][j] != graph2[i][j])
                    return false;

                // If the vertex j in graph2 is not visited yet and the degree of vertex i in
                // graph1 is equal to the degree of vertex j in graph2
                if (!visited[j] && graph1[i][j] == graph2[i][j]) {
                    visited[j] = true; // Mark vertex j as visited
                    flag = true; // Set flag to true indicating that the corresponding vertex is found
                    break;
                }
            }
            if (!flag) // If no corresponding vertex is found in graph2 for vertex i in graph1
                return false;
        }

        return true; // If all conditions are satisfied, graphs are isomorphic
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices in both graphs (vertix1 vertix2): ");
        int V = scanner.nextInt();

        int[][] graph1 = new int[V][V];
        int[][] graph2 = new int[V][V];

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nEnter the adjacency matrix for the second graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        System.out.println("\n-----------------------------------------");
        if (areIsomorphic(graph1, graph2, V))
            System.out.println("Graphs are isomorphic.");
        else
            System.out.println("Graphs are not isomorphic.");
    }
}
