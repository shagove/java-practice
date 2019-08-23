package ee.sda.fs.path;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryTreeExplorer {

    private static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        Path startDir = Paths.get("/home/eduard/IdeaProjects/");
        Files.walkFileTree(startDir, new FindJavaVisitor());
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")){
                System.out.printf("%5d: [%s]\n", ++COUNT, file.toAbsolutePath().toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
