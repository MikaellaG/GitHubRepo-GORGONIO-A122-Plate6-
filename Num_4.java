import java.util.*;

public class Num_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices and edges
        System.out.println("\n-----------------------------------------\n");
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // Create an adjacency list to store the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Input the edges
        System.out.println("\nEnter the edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1); // for undirected graph
        }

        // Calculate and output the degree of each vertex
        System.out.println("\n-----------------------------------------");
        System.out.println("Vertex degrees:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + adjList.get(i).size());
        }
    }
}
