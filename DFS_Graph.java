import java.util.HashSet;
import java.util.Set;

class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    // Initializes a graph with a specified number of vertices.
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Adds an edge between two vertices in the graph.
    public void addEdge(int source, int destination) {
        // Marks the edge from source to destination as present.
        adjacencyMatrix[source][destination] = 1;
        // For an undirected graph, also mark the edge from destination to source.
        adjacencyMatrix[destination][source] = 1;
    }

    // Initiates a Depth-First Search (DFS) starting from a given vertex.
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    // Recursively explores vertices, marking each as visited and exploring further.
    private void dfsHelper(int vertex, Set<Integer> visited) {
        // Marks the current vertex as visited and prints it.
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Iterates over all possible vertices to find all adjacent (directly connected)
        // vertices.
        for (int i = 0; i < numVertices; i++) {
            // If an edge exists and the vertex hasn't been visited, recurse with the new
            // vertex.
            if (adjacencyMatrix[vertex][i] == 1 && !visited.contains(i)) {
                dfsHelper(i, visited);
            }
        }
    }
}

public class DFS_Graph {
    public static void main(String[] args) {
        // Creates a graph instance with 5 vertices.
        Graph graph = new Graph(5);
        // Establishes edges between vertices to form the graph.
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // Begins a DFS starting from vertex 2, printing the order of traversal.
        System.out.println("Depth First Traversal starting from vertex 2:");
        graph.dfs(2);
    }
}
