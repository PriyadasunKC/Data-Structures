import java.util.*;

class Graph {
    int numVertices;
    int[][] adjacencyMatrix;

    // Constructor to initialize the graph with the number of vertices
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Method to add an edge between two vertices in the graph
    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1; // Mark the edge from vertex i to j
        adjacencyMatrix[j][i] = 1; // Mark the edge from vertex j to i for undirected graph
    }

    // Method to perform Breadth-First Search (BFS) starting from a given vertex
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>(); // Set to keep track of visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue to manage the BFS order

        visited.add(start); // Mark the start vertex as visited
        queue.add(start); // Enqueue the start vertex

        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex from the queue
            System.out.print(vertex + " "); // Print the visited vertex

            // Get all neighbors of the dequeued vertex
            List<Integer> neighbours = getNeighbours(vertex);
            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) { // If the neighbor has not been visited
                    visited.add(neighbour); // Mark it as visited
                    queue.add(neighbour); // Enqueue it
                }
            }
        }
    }

    // Helper method to get the neighbors of a vertex
    private List<Integer> getNeighbours(int vertex) {
        List<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) { // If there's an edge between vertex and i
                neighbours.add(i); // Add i to the list of neighbors
            }
        }
        return neighbours;
    }
}

public class BFS_Graph {
    public static void main(String[] args) {
        Graph g = new Graph(4); // Create a graph with 4 vertices

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");

        // Perform BFS starting from vertex 2
        g.bfs(2);
    }
}