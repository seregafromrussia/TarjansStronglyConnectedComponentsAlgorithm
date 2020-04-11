import java.util.ArrayList;

public class Vertex {
    private final String name;
    private int index;
    private int number;
    private int lowlink;
    private ArrayList<Vertex> AdjacentVertexes;
    private ArrayList<Edge> edges;
    private boolean onStack;

    public Vertex(int number, int lowlink, String name, int index, ArrayList<Vertex> AdjacentVertexes, ArrayList<Edge> edges) {
        this.number = number;
        this.lowlink = lowlink;
        this.name = name;
        this.index = index;
        this.AdjacentVertexes = AdjacentVertexes;
        this.edges = edges;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public boolean isOnStack() {
        return onStack;
    }

    public void setOnStack(boolean onStack) {
        this.onStack = onStack;
    }

    public int getLowlink() {
        return lowlink;
    }

    public void setLowlink(int lowlink) {
        this.lowlink = lowlink;
    }


    public void addAdjacentVertex(Vertex adjacentVertex) {
        AdjacentVertexes.add(adjacentVertex);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public ArrayList<Vertex> getAdjacentVertexes() {
        return AdjacentVertexes;
    }

    public void setAdjacentVertexes(ArrayList<Vertex> adjacentVertexes) {
        AdjacentVertexes = adjacentVertexes;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
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
        if (vertex1.getName() == vertex2.getName() && vertex1.getNumber() == vertex2.getNumber()) {
            return true;
        } else return false;
    }
}
