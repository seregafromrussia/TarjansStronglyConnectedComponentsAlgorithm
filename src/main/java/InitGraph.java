import java.util.ArrayList;
import java.util.List;


public class InitGraph {
    String nameOfVertex = "v";

    public DirectedGraph initDirectedGraphWithAdjMatrix(int[][] adjMatrix) {
        List<Vertex> vertexList = new ArrayList<Vertex>(0);
        List<Edge> edgeList = new ArrayList<Edge>(0);
        DirectedGraph directedGraph = new DirectedGraph(vertexList, edgeList);
        initVertexes(directedGraph, adjMatrix.length);
        initEdges(directedGraph, adjMatrix);
        return directedGraph;
    }

    public void initVertexes(DirectedGraph directedGraph, int NumberOfVertices) {
        for (int i = 0; i < NumberOfVertices; ++i) {
            directedGraph.addVertex("V",i+1);
        }
    }

    public void initEdges(DirectedGraph directedGraph, int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; ++i) {

            for (int j = 0; j < adjMatrix[0].length; ++j) {
                if (adjMatrix[i][j] != 0) {
                    directedGraph.addEdge(i+1,j+1,adjMatrix[i][j]);
                }
            }
        }
    }

}
