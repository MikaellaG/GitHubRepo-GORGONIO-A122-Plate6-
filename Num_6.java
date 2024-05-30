import java.util.*;

public class Num_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices and edges

        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        // Input the edges and construct the adjacency matrix
        System.out.println("\nEnter the edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            // Handle loops, multiple edges, or directed edges by incrementing the value
            adjacencyMatrix[vertex1][vertex2]++;
            adjacencyMatrix[vertex2][vertex1]++; // for undirected graph
        }

        // Output the adjacency matrix

        System.out.println("\n-----------------------------------------");
        System.out.println("Adjacency Matrix:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
