package kurs.GraphComponents;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log
@Component
@Data
public final class AdjMatrix {
    private int[][] adjMatrix;

    private static int[][] adjMatrixStatic = new int[][]{
            {0, 1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0}};

    @Autowired
    private void initAdjMatrix(AdjMatrix adjMatrix) {
        adjMatrix.setAdjMatrix(adjMatrixStatic);
        log.info(toString());
    }

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
