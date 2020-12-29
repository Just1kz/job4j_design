package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFilesDuplicate implements FileVisitor<Path> {

    private final Set<CustomFile> allFiles = new HashSet<>();
    private final List<CustomFile> duplicate = new ArrayList<>();

    public List<CustomFile> getDuplicate() {
        return duplicate;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        CustomFile x = new CustomFile(file.toFile().getName(), file.toFile().length(), file.toFile().getAbsolutePath());
        if (!allFiles.contains(x)) {
            allFiles.add(x);
        } else {
            duplicate.add(x);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static class CustomFile {
      private final String name;
      private final long size;
      private final Set<String> path = new HashSet<>();

        public CustomFile(String name, long size, String path) {
            this.name = name;
            this.size = size;
            this.path.add(path);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CustomFile that = (CustomFile) o;
            return size == that.size
                    && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, size);
        }

        @Override
        public String toString() {
            return "CustomFile{"
                    + "name='"
                    + name
                    + '\''
                    + ", size="
                    + size
                    + ", path="
                    + path
                    + '}';
        }
    }
}
