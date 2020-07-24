package kurs.GraphComponents;

import kurs.MatrixComponents.AdjacencyMatrix;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Log
@AllArgsConstructor
@Component
@DependsOn({"matrixReaderFromTextFile"})
public final class DirectedGraphInitialization {
    @Autowired
    private final DirectedGraph directedGraph;
    @Autowired
    private final AdjacencyMatrix adjacencyMatrix;

    @PostConstruct
    private void initDirectedGraph() {
        initVertexes(adjacencyMatrix.getAdjacencyMatrix().size());
        initEdges(adjacencyMatrix.getAdjacencyMatrix());
        log.info(directedGraph.toString());
    }

    private void initVertexes(int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; ++i) {
            addVertex(i + 1);
        }
    }

    private void initEdges(List<List<Integer>> adjMatrix) {
        int i = 0;
        for (List<Integer> list : adjMatrix) {
            int j = 0;
            for (Integer number : list) {
                if (number != 0) {
                    addEdge(i + 1, j + 1, number);
                }
                ++j;
            }
            ++i;
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

    public void addEdge(int numberSourceVertex, int numberTargetVertex, int weight) {
        Vertex sourceVertex = directedGraph.getVertexList().get(numberSourceVertex - 1);
        Vertex targetVertex = directedGraph.getVertexList().get(numberTargetVertex - 1);
        directedGraph.getVertexList().get(numberSourceVertex - 1).addAdjVertex(targetVertex);
        Edge<Integer> edge = new Edge<>(sourceVertex, targetVertex, weight);
        directedGraph.getVertexList().get(numberSourceVertex - 1).addEdge(edge);
        directedGraph.getEdgeList().add(edge);
    }
}
