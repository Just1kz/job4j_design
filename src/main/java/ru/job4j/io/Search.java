package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

//public class Search {
//    public static void main(String[] args) throws IOException {
//        Path start = Paths.get(".");
//        search(start, "js").forEach(System.out::println);
//    }
//
//    public static List<Path> search(Path root, String ext) {
//        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
//        //p -> p.toFile().getName().endsWith(ext)
//        Files.walkFileTree(root, searcher);
//        return searcher.getPaths();
//    }
//
//    private static class SearchFiles {
//        private Predicate<FileX> fileX;
//
//        public SearchFiles(Predicate<FileX> fileX) {
//            this.fileX = fileX;
//        }
//    }
//
//    private static class FileX {
//        private String name;
//
//        public void toFile() {
//
//        }
//
//        public FileX(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
//}
