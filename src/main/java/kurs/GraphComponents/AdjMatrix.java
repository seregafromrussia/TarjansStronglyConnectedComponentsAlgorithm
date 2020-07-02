package kurs.GraphComponents;

import org.springframework.stereotype.Component;


@Component
public class AdjMatrix {

    /**
     * @return the adjacency matrix
     */
    public int[][] getAdjMatrix() {
        int[][] adjMatrix = {
                {0, 1, 0, 0, 0, 1 },
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0}};

        return adjMatrix;
    }

    /**
     * @return string representation of the adjacency matrix
     */
    public String toString() {
        String strAdjMatrix = "AdjMatrix\n";
        for (int i = 0; i < getAdjMatrix().length; ++i) {
            strAdjMatrix+="{";
            for (int j = 0; j < getAdjMatrix()[0].length; ++j) {
                strAdjMatrix += " "
                        + String.valueOf(getAdjMatrix()[i][j])
                        + ", ";
            }
            strAdjMatrix+="},";
            strAdjMatrix += "\n";
        }
        return strAdjMatrix;
    }

}
