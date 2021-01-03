package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ExamSearch {

    public static void main(String[] args) throws IOException {
        for (String rsl : args) {
            System.out.println(rsl);
        }
        ExamSearchAndZip examSearchAndZip = new ExamSearchAndZip(args);
        System.out.println(examSearchAndZip.valid());
        ExamSearch searcher = new ExamSearch();
        List<Path> files = searcher.search(examSearchAndZip);
        searcher.writeLog(examSearchAndZip, files);
    }

    private List<Path> search(ExamSearchAndZip examSearchAndZip) throws IOException {
        Files.walkFileTree(Path.of(examSearchAndZip.directory()), examSearchAndZip.predicateSearch());
        return examSearchAndZip.predicateSearch().getPaths();
    }

    private void writeLog(ExamSearchAndZip examSearchAndZip, List<Path> files) throws IOException {
        Files.write(
                Path.of(examSearchAndZip.logPath()),
                files.stream().map(Path::toString).collect(Collectors.toList())
        );
    }

}
