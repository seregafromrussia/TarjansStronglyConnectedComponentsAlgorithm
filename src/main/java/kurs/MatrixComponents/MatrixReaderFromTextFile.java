package kurs.MatrixComponents;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
@Component
public class MatrixReaderFromTextFile {
    @Autowired
    private AdjMatrix adjMatrix;

    //TODO: и разобраться с жиненным циклом бина
    //нэйминг, дженерики, интерфейсы и NotNull annotation

    @PostConstruct
    private void read() {
        try (Stream<String> stream =
                     Files.lines(Paths.get("src\\main\\java\\kurs\\Files\\TextOfMatrix"))) {
            List<String> stringList = stream.collect(Collectors.toList());
            for (String string : stringList) {
                adjMatrix.getAdjMatrix().add(parseLine(string));
            }
            log.info(adjMatrix.toString());
        } catch (IOException e) {
            log.info(Arrays.toString(e.getStackTrace()));
        }
    }

    private List<Integer> parseLine(String line) {
        List<Integer> integerList = new ArrayList<>();
        String[] strings = line.split(" ");
        for(String s : strings){
            integerList.add(Integer.valueOf(s));
        }
        return integerList;
    }
}
