import java.util.*;

public class Num_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adjacency matrix
        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        int[][] adjacencyMatrix = new int[n][n];

        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge exists):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // List the edges and count the occurrences
        Map<String, Integer> edgeCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    String edge = i + " " + j;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + 1);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("\n-----------------------------------------");
        System.out.println("Edges and their occurrences:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }
}
