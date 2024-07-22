import java.util.HashSet;
import java.util.Set;

class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;
    private int[] vertexValues;

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

    // Method to set a value for a vertex
    public void setVertexValue(int vertex, int value) {
        if (vertex >= 0 && vertex < numVertices) {
            vertexValues[vertex] = value;
        }
    }

    // Method to find the vertex with the maximum value
    public int findMaxValueVertex() {
        int maxValue = Integer.MIN_VALUE;
        int vertexWithMaxValue = -1;
        for (int i = 0; i < numVertices; i++) {
            if (vertexValues[i] > maxValue) {
                maxValue = vertexValues[i];
                vertexWithMaxValue = i;
            }
        }
        return vertexWithMaxValue;
    }

    // Method to find the vertex with the minimum value
    public int findMinValueVertex() {
        int minValue = Integer.MAX_VALUE;
        int vertexWithMinValue = -1;
        for (int i = 0; i < numVertices; i++) {
            if (vertexValues[i] < minValue) {
                minValue = vertexValues[i];
                vertexWithMinValue = i;
            }
        }
        return vertexWithMinValue;
    }
}

public class DFS_Find_Max_Min_Elements_of_Graph {
    public static void main(String[] args) {
        // Creates a graph instance with 5 vertices.
        Graph graph = new Graph(5);
        // Assume you've added edges here
        graph.setVertexValue(0, 10);
        graph.setVertexValue(1, 5);
        graph.setVertexValue(2, 20);
        graph.setVertexValue(3, 3);
        graph.setVertexValue(4, 15);

        int maxValVertex = graph.findMaxValueVertex();
        int minValVertex = graph.findMinValueVertex();

        System.out.println("Vertex with max value: " + maxValVertex);
        System.out.println("Vertex with min value: " + minValVertex);
    }
}