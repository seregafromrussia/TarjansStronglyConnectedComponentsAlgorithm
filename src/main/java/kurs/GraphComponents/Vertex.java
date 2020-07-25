package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public final class Vertex {
    private final String name;
    private final int number;
    private final List<Vertex> adjVertexes;
    private final List<Edge<Integer>> incidentEdges;

    private int index;
    private int lowLink;
    private boolean onStack;

    /**
     * adds an edge to the vertex's list of incident edges
     *
     * @param edge - incident edge
     */
    public void addEdge(Edge<Integer> edge) {
        incidentEdges.add(edge);
    }

    /**
     * adds an vertex to the vertex's list of adjacent vertexes
     *
     * @param adjVertex - adjacent vertex
     */
    public void addAdjVertex(Vertex adjVertex) {
        adjVertexes.add(adjVertex);
    }

    @Override
    public String toString() {
        return "{" + name + number + "}";
    }

    public String toStringAdjacentVertexes() {
        StringBuilder stringAdjVertexes = new StringBuilder("  : ");
        for (Vertex Vertexes : adjVertexes) {
            stringAdjVertexes.append(Vertexes.toString()).append(" ");
        }
        return stringAdjVertexes.toString();
    }
}
