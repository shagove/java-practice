package ee.sda.fs.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAttributeReader {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/usr/bin/zip");
        System.out.printf("Path [%s]\n", path.toString());
        System.out.printf("Last modified [%s]\n", Files.getLastModifiedTime(path));
        System.out.printf("Size [%s] byte\n", Files.size(path));
        System.out.printf("Is symbolic link? [%s]\n", Files.isSymbolicLink(path));
        System.out.printf("Is directory? [%s]\n", Files.isDirectory(path));
        System.out.printf("Attributes: [%s]\n", Files.readAttributes(path, "*"));
    }
}
