import java.util.ArrayList;
import java.util.Stack;

public class SCC {
    private ArrayList<Vertex> vertices;


    public SCC(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void addVertexToSCC(Vertex vertex) {
        vertices.add(vertex);
    }

    @Override
    public String toString() {
        String strSCC = "SCC: ";
        for (Vertex v : vertices) {
            strSCC += v.toString();
        }
        return strSCC;
    }
}
