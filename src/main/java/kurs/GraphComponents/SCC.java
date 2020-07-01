package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class SCC {
    private List<Vertex> vertexList;

    /**
     * adds an vertex to the strongly connected component's list of vertexes
     *
     * @param vertex - strongly connected component's vertex
     */
    public void addVertexToSCC(Vertex vertex) {
        vertexList.add(vertex);
    }

    /**
     * @return - string representation of strongly connected component
     */
    @Override
    public String toString() {
        StringBuilder strSCC = new StringBuilder("SCC: ");
        for (Vertex v : vertexList) {
            strSCC.append(v.toString());
        }
        return strSCC.toString();
    }
}
