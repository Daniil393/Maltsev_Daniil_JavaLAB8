package zadanie_7_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class PeopleFileProcessor {

    public static Map<Integer, List<String>> processFile(String filePath) throws IOException {

        return Files.lines(Path.of(filePath))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(":"))
                .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                .collect(Collectors.groupingBy(
                        parts -> Integer.parseInt(parts[1]),
                        Collectors.mapping(
                                parts -> capitalize(parts[0]),
                                Collectors.toList()
                        )
                ));
    }

    private static String capitalize(String name) {
        if (name.isEmpty()) return name;
        name = name.toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}