import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vertex {
    private String name;
    private int index;
    private int number;
    private int lowlink;
    private List<Vertex> AdjacentVertexes;
    private List<Edge> edges;
    private boolean onStack;

    /**
     *
     * @param edge
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    /**
     *
     * @param adjacentVertex
     */
    public void addAdjacentVertex(Vertex adjacentVertex) {
        AdjacentVertexes.add(adjacentVertex);
    }

    public String toString() {
        String stringVertex = "{" + name + String.valueOf(number) + "}";
        return stringVertex;
    }

    public String printAdjacentVertexes() {
        String stringAdjVertexes = "  : ";
        for (Vertex Vertexes : AdjacentVertexes) {
            stringAdjVertexes += Vertexes.toString() + " ";
        }
        return stringAdjVertexes;
    }

    public String printEdgesOfVertex() {
        String strEdges = "";
        for (Edge edge : edges) {
            strEdges += edge.toString() + " ";
        }
        return strEdges;
    }

    public static boolean Equals(Vertex vertex1, Vertex vertex2) {
        if (vertex1.getName() == vertex2.getName() &&
                vertex1.getNumber() == vertex2.getNumber()) {
            return true;
        } else return false;
    }
}
