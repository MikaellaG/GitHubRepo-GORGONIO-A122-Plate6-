import java.util.*;

public class Num_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices and edges
        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Initialize the incidence matrix
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        // Input the edges and the number of times each edge appears
        System.out.println("\nEnter the edges and the number of times each edge appears (vertex1 vertex2 count):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int count = scanner.nextInt();
            // Update the incidence matrix with the count for the current edge
            incidenceMatrix[vertex1][i] = count;
            incidenceMatrix[vertex2][i] = count;
        }

        // Output the incidence matrix
        System.out.println("\n-----------------------------------------");
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
