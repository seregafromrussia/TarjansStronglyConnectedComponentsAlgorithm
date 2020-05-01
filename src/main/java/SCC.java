import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SCC {
    private List<Vertex> vertices;

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
