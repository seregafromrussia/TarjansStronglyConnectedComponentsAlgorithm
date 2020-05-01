import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DirectedGraph {
    private List<Vertex> vertexList;
    private List<Edge> edgeList;


    public void addVertex(String vertexName, int numberVertex) {
        List<Vertex> emptyAdjVertexList = new ArrayList<Vertex>(0);
        List<Edge> emptyEdgesList = new ArrayList<Edge>(0);
        Vertex vertex = new Vertex(vertexName,
                StronglyConnectedComponents.UNDEFINED,
                numberVertex,
                0,
                emptyAdjVertexList,
                emptyEdgesList,
                false);
        vertexList.add(vertex);
    }

    public void addEdge(int numberSourceVertex, int numbertargetVertex, double weight) {
        Vertex sourceVertex = vertexList.get(numberSourceVertex - 1);
        Vertex targetVertex = vertexList.get(numbertargetVertex - 1);
        vertexList.get(numberSourceVertex - 1).addAdjacentVertex(targetVertex);
        Edge edge = new Edge(sourceVertex, targetVertex, weight);
        vertexList.get(numberSourceVertex - 1).addEdge(edge);
        edgeList.add(edge);
    }


    @Override
    public String toString() {
        String stringVertexes = "Vertexes : ";
        String stringEdges = "Edges : ";
        for (Vertex vertexes : vertexList) {
            stringVertexes += vertexes.toString() + "; ";
        }
        for (Edge edges : edgeList) {
            stringEdges += edges.toString() + " ";
        }
        return stringVertexes + "\n" + stringEdges;
    }

    public String printAdjList() {
        String strAdjList = "AdjList";
        for (Vertex vertexes : vertexList) {
            strAdjList += "\n" + vertexes.toString() + vertexes.printAdjacentVertexes();
        }
        return strAdjList;
    }

    public String printEdges() {
        String strVertexWithEdges = "Edges" + "\n";
        for (Vertex v : vertexList) {
            strVertexWithEdges += v.toString() + "  :" + v.printEdgesOfVertex() + "\n";
        }
        return strVertexWithEdges;
    }
}
