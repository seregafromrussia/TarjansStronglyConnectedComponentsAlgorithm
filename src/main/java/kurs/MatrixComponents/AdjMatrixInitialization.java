//package kurs.MatrixComponents;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.java.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Log
//@AllArgsConstructor
//@Component
//public final class AdjMatrixInitialization {
//    @Autowired
//    private final AdjMatrix adjMatrix;
//
//    private static final int[][] adjMatrixStatic = new int[][]{
//            {0, 1, 0, 0, 0, 1},
//            {0, 0, 1, 0, 0, 0},
//            {0, 0, 0, 1, 1, 0},
//            {0, 0, 1, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0},
//            {1, 0, 0, 0, 1, 0}};
//
//    @PostConstruct
//    private void initAdjMatrix() {
//        adjMatrix.setAdjMatrix(adjMatrixStatic);
//        log.info(adjMatrix.toString());
//    }
//}
