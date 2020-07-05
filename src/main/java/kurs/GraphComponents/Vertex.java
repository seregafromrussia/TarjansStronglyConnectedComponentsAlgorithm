package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public final class Vertex {
    private String name;
    private int index;
    private int number;
    private int lowLink;
    private List<Vertex> adjVertexes;
    private List<Edge> incidentEdges;
    private boolean onStack;

    /**
     * adds an edge to the vertex's list of incident edges
     *
     * @param edge - incident edge
     */
    public void addEdge(Edge edge) {
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
