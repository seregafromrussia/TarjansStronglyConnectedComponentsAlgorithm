package kurs.GraphComponents;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    private Vertex sourceVertex;
    private Vertex targetVertex;
    private double weight;
}
