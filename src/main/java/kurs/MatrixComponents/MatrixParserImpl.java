package kurs.MatrixComponents;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
final class MatrixParserImpl implements Parser {
    private final Reader reader;

    @Override
    public List<List<Integer>> parse() {
        List<String> stringList = reader.read();
        List<List<Integer>> matrix = new ArrayList<>();
        for (String string : stringList) {
            matrix.add(parseLine(string));
        }
        return matrix;
    }

    private List<Integer> parseLine(String line) {
        List<Integer> integerList = new ArrayList<>();
        String[] strings = line.split(" ");
        for (String s : strings) {
            integerList.add(Integer.valueOf(s));
        }
        return integerList;
    }
}
