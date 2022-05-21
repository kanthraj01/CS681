package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVIStream {
 static void main(String[] args) {

        Path path = Paths.get("src/data.csv");

        try( Stream<String> lines = Files.lines(path) ){
            List<List<String>> matrix = lines.map(line -> {
                        return Stream.of( line.split(",") )
                                .map(value->value.substring(0, value.length()))
                                .collect( Collectors.toList() ); })
                    .collect( Collectors.toList() );


            List massachusetts = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).
                    collect(Collectors.toList());
            String totalCases = matrix.stream().
                    parallel().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((j) -> j.get(6)).reduce("0",
                            (temp, result) -> String.valueOf(Integer.parseInt(temp) + Integer.parseInt(result)));


            System.out.println("Total cases in Massachusetts: " + totalCases);
            

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}