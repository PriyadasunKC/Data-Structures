import java.util.HashSet;
import java.util.Set;

class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited.contains(i)) {
                dfsHelper(i, visited);
            }
        }
    }

    // Check if a vertex exists in the graph
    public boolean vertexExists(int vertex) {
        return vertex >= 0 && vertex < numVertices;
    }
}

public class DFS_Search_Given_Vertex {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // Search for a vertex and start DFS from it
        System.out.println("Vertex 2 exists: " + graph.vertexExists(2)); // Should return true
        System.out.println("Vertex 5 exists: " + graph.vertexExists(5)); // Should return false
    }
}