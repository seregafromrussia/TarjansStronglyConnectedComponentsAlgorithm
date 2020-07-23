package kurs.MatrixComponents;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log
@Component
public class MatrixReaderFromTextFile implements Reader {
//    @Autowired
//    private AdjacencyMatrix adjacencyMatrix;

    //TODO: и разобраться с жиненным циклом бина
    //нэйминг, дженерики, интерфейсы и NotNull annotation

    @PostConstruct
    public List<String> read() {
        try (Stream<String> stream =
                     Files.lines(Paths.get("src\\main\\java\\kurs\\Files\\TextOfMatrix"))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            log.info(Arrays.toString(e.getStackTrace()));
            return Collections.emptyList();
        }
    }
}
