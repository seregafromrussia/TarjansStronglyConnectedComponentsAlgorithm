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
    private List<List<Integer>> adjacencyMatrix;
    @Autowired
    private Parser parser;

    @PostConstruct
    private void init(){
        adjacencyMatrix = parser.parse();
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
