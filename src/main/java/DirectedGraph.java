import java.util.ArrayList;

public class DirectedGraph {
    private ArrayList<Vertex> vertexList;
    private ArrayList<Edge> edgeList;

    public DirectedGraph(ArrayList<Vertex> vertexList, ArrayList<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public void addVertex(String vertexName, int numberVertex) {
        ArrayList<Vertex> emptyAdjVertexList = new ArrayList<Vertex>(0);
        ArrayList<Edge> emptyEdgesList = new ArrayList<Edge>(0);
        Vertex vertex = new Vertex(numberVertex, 0, vertexName, -1, emptyAdjVertexList, emptyEdgesList);
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

    public ArrayList<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(ArrayList<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
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
