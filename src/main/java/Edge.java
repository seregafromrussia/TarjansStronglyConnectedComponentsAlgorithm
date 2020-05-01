import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    private Vertex sourceVertex;
    private Vertex targetVertex;
    private double weight;

//    public boolean isLoop(Edge edge) {
//        if (edge.sourceVertex == edge.targetVertex) return true;
//        else return false;
//    }

    @Override
    public String toString() {
        String stringEdge = "(" + sourceVertex.toString() + "->" + targetVertex.toString() + "w:" + String.valueOf(weight) + ")";
        return stringEdge;
    }

//    public static boolean Equals(Edge edge1, Edge edge2) {
//        if (Vertex.Equals(edge1.getSourceVertex(), edge2.getSourceVertex()) &&
//                Vertex.Equals(edge1.getTargetVertex(), edge2.getTargetVertex())) {
//            return true;
//        }
//        else return false;
//    }
}
