package kurs.GraphComponents;

import kurs.MatrixComponents.AdjMatrix;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Log
@AllArgsConstructor
@Component
public final class DirectedGraphInitialization {
    @Autowired
    private final DirectedGraph directedGraph;
    @Autowired
    private final AdjMatrix adjMatrix;

    @PostConstruct
    private void initDirectedGraph() {
        initVertexes(adjMatrix.getAdjMatrix().length);
        initEdges(adjMatrix.getAdjMatrix());
        log.info(directedGraph.toString());
    }

    private void initVertexes(int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; ++i) {
            addVertex(i + 1);
        }
    }

    private void initEdges(int[][] adjMatrix) {
        for (int i = 0; i < adjMatrix.length; ++i) {
            for (int j = 0; j < adjMatrix[0].length; ++j) {
                if (adjMatrix[i][j] != 0) {
                    addEdge(
                            i + 1,
                            j + 1,
                            adjMatrix[i][j]);
                }
            }
        }
    }

    public void addVertex(int numberVertex) {
        Vertex vertex = new Vertex(
                "V",
                numberVertex,
                new ArrayList<>(0),
                new ArrayList<>(0),
                StronglyConnectedComponents.UNDEFINED_INDEX,
                0,
                false);
        directedGraph.getVertexList().add(vertex);
    }

    public void addEdge(int numberSourceVertex, int numberTargetVertex, double weight) {
        Vertex sourceVertex = directedGraph.getVertexList().get(numberSourceVertex - 1);
        Vertex targetVertex = directedGraph.getVertexList().get(numberTargetVertex - 1);
        directedGraph.getVertexList().get(numberSourceVertex - 1).addAdjVertex(targetVertex);
        Edge edge = new Edge(sourceVertex, targetVertex, weight);
        directedGraph.getVertexList().get(numberSourceVertex - 1).addEdge(edge);
        directedGraph.getEdgeList().add(edge);
    }
}
