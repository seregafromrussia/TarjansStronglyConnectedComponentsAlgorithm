package kurs.GraphComponents;

import java.util.List;

public interface DirectedGraph {
    List<Vertex> getVertexList();

    List<Edge<Integer>> getEdgeList();
}
