package kurs.GraphComponents;

import org.springframework.stereotype.Component;

@Component
public class AdjMatrix {
    /**
     * @return the adjacency matrix
     */
    public int[][] getAdjMatrix() {

        return new int[][]{
                {0, 1, 0, 0, 0, 1 },
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0}};
    }

    /**
     * @return string representation of the adjacency matrix
     */
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
