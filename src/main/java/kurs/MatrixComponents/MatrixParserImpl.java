package kurs.MatrixComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatrixParserImpl implements Parser {
    @Autowired
    private Reader reader;

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
