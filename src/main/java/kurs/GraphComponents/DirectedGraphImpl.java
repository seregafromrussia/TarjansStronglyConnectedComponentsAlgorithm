package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Component
@Log
public final class DirectedGraphImpl implements DirectedGraph {
    private final List<Vertex> vertexList = new ArrayList<>();
    private final List<Edge<Integer>> edgeList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder strAdjList = new StringBuilder("AdjList");
        for (Vertex vertexes : vertexList) {
            strAdjList.append("\n").
                    append(vertexes.toString()).
                    append(vertexes.toStringAdjacentVertexes());
        }
        strAdjList.append("\n");
        return strAdjList.toString();
    }
}
