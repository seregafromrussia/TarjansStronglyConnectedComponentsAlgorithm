package kurs.MatrixComponents;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public final class AdjMatrix {

    private List<List<Integer>> adjMatrix = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder strAdjMatrix = new StringBuilder("AdjMatrix\n");
        for (List<Integer> list : adjMatrix) {
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
