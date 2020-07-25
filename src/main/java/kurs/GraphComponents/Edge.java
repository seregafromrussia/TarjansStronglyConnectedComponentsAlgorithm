package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Edge <T> {
    private final Vertex sourceVertex;
    private final Vertex targetVertex;
    private final T weight;
}
