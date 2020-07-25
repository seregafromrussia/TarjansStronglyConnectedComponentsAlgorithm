package kurs.GraphComponents;

import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public final class SCC {
    private final List<Vertex> vertexList;

    /**
     * adds an vertex to the strongly connected component's list of vertexes
     *
     * @param vertex - strongly connected component's vertex
     */
    public void addVertexToSCC(Vertex vertex) {
        vertexList.add(vertex);
    }

    @Override
    public String toString() {
        StringBuilder strSCC = new StringBuilder("SCC: ");
        for (Vertex v : vertexList) {
            strSCC.append(v.toString());
        }
        return strSCC.toString();
    }
}
