package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Edge {
    private final Vertex sourceVertex;
    private final Vertex targetVertex;
    private final double weight;
}
