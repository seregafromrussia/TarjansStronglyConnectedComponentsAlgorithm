package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vertex {

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

    /**
     * @return - string representation of vertex
     */
    public String toString() {
        String stringVertex = "{"
                + name
                + String.valueOf(number)
                + "}";
        return stringVertex;
    }

    /**
     * @return - string representation of edge
     */
    public String printAdjacentVertexes() {
        String stringAdjVertexes = "  : ";
        for (Vertex Vertexes : adjVertexes) {
            stringAdjVertexes += Vertexes.toString()
                    + " ";
        }
        return stringAdjVertexes;
    }

}