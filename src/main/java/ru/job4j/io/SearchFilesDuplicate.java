package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFilesDuplicate implements FileVisitor<Path> {

    private final List<CustomFile> allFiles = new ArrayList<>();
    private final Set<CustomFile> duplicate = new HashSet<>();

    public List<CustomFile> getAttributes() {
        return allFiles;
    }

    public Set<CustomFile> getDuplicate() {
        return duplicate;
    }

    public void findDuplicate() {
        for (CustomFile rsl : allFiles) {
            for (CustomFile search : allFiles) {
                if (rsl.equals(search) && (!rsl.path.iterator().next().equals(search.path.iterator().next()))) {
                    rsl.path.add(search.path.iterator().next());
                    duplicate.add(rsl);
                }
            }
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        allFiles.add(new CustomFile(file.toFile().getName(), file.toFile().length(), file.toFile().getAbsolutePath()));
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
      private String name;
      private long size;
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
