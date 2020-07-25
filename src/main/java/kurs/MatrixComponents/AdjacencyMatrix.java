package kurs.MatrixComponents;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Data
@Log
public final class AdjacencyMatrix {
    private final List<List<Integer>> adjacencyMatrix;
    private final Parser parser;

    @Autowired
    public AdjacencyMatrix(Parser parser) {
        this.parser = parser;
        this.adjacencyMatrix = parser.parse();
    }

    @PostConstruct
    private void init(){
        log.info(toString());
    }

    @Override
    public String toString() {
        StringBuilder strAdjMatrix = new StringBuilder("AdjMatrix\n");
        for (List<Integer> list : adjacencyMatrix) {
            strAdjMatrix.append("{");
            for (Integer number : list) {
                strAdjMatrix.append(" ").append(number).append(", ");
            }
            strAdjMatrix.append("},");
            strAdjMatrix.append("\n");
        }
        return strAdjMatrix.toString();

    }
}
