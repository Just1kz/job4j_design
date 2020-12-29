package ru.job4j.io;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class Search {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\Users\\Just1lz\\Documents\\Data\\Java");
        searchDuplicate(start).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static Set<SearchFilesDuplicate.CustomFile> searchDuplicate(Path root) throws IOException {
        SearchFilesDuplicate searcher = new SearchFilesDuplicate();
        Files.walkFileTree(root, searcher);
        searcher.findDuplicate();
        return searcher.getDuplicate();
    }
}
