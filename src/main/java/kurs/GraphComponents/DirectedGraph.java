package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Component
public class DirectedGraph {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    @Autowired
    private void initDirectedGraph(DirectedGraph directedGraph, AdjMatrix adjMatrix) {
        initVertexes(directedGraph,
                adjMatrix.getAdjMatrix().length);
        initEdges(directedGraph,
                adjMatrix.getAdjMatrix());
    }

    private void initVertexes(DirectedGraph directedGraph, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; ++i) {
            directedGraph.addVertex("V",
                    i + 1);
        }
    }

    private void initEdges(DirectedGraph directedGraph, int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; ++i) {
            for (int j = 0; j < adjMatrix[0].length; ++j) {
                if (adjMatrix[i][j] != 0) {
                    directedGraph.addEdge(
                            i + 1,
                            j + 1,
                            adjMatrix[i][j]);
                }
            }
        }
    }


    private void addVertex(String vertexName, int numberVertex) {
        Vertex vertex = new Vertex(
                vertexName,
                StronglyConnectedComponents.UNDEFINED_INDEX,
                numberVertex,
                0,
                new ArrayList<Vertex>(0),
                new ArrayList<Edge>(0),
                false);
        vertexList.add(vertex);
    }

    private void addEdge(int numberSourceVertex, int numberTargetVertex, double weight) {
        Vertex sourceVertex = vertexList.get(numberSourceVertex - 1);
        Vertex targetVertex = vertexList.get(numberTargetVertex - 1);
        vertexList.get(numberSourceVertex - 1).addAdjVertex(targetVertex);
        Edge edge = new Edge(sourceVertex, targetVertex, weight);
        vertexList.get(numberSourceVertex - 1).addEdge(edge);
        edgeList.add(edge);
    }


    /**
     * @return string representation of list of adjacent vertexes
     */
    public String printAdjList() {
        String strAdjList = "AdjList";
        for (Vertex vertexes : vertexList) {
            strAdjList += "\n"
                    + vertexes.toString()
                    + vertexes.printAdjacentVertexes();
        }
        strAdjList += "\n";
        return strAdjList;
    }

}
