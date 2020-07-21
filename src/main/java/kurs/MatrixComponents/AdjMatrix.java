package kurs.MatrixComponents;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public final class AdjMatrix {
    //TODO: разобраться с null
    private int[][] adjMatrix = new int[][]{
            {0, 1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0}};

    @Override
    public String toString() {
        StringBuilder strAdjMatrix = new StringBuilder("AdjMatrix\n");
        for (int i = 0; i < getAdjMatrix().length; ++i) {
            strAdjMatrix.append("{");
            for (int j = 0; j < getAdjMatrix()[0].length; ++j) {
                strAdjMatrix.append(" ").append(getAdjMatrix()[i][j]).append(", ");
            }
            strAdjMatrix.append("},");
            strAdjMatrix.append("\n");
        }
        return strAdjMatrix.toString();
    }
}
