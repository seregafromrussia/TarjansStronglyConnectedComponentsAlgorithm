public class Edge {
    private Vertex sourceVertex;
    private Vertex targetVertex;
    private double weight;

    public Edge(Vertex sourceVertex, Vertex targetVertex, double weight) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        weight = weight;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        targetVertex = targetVertex;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        sourceVertex = sourceVertex;
    }

    public boolean isLoop(Edge edge) {
        if (edge.sourceVertex == edge.targetVertex) return true;
        else return false;
    }

    @Override
    public String toString() {
        String stringEdge = "(" + sourceVertex.toString() + "->" + targetVertex.toString() + "w:" + String.valueOf(weight) + ")";
        return stringEdge;
    }

    public static boolean Equals(Edge edge1, Edge edge2) {
        if (Vertex.Equals(edge1.getSourceVertex(), edge2.getSourceVertex()) &&
                Vertex.Equals(edge1.getTargetVertex(), edge2.getTargetVertex())) {
            return true;
        }
        else return false;
    }
}
