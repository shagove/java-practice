package ee.sda.fs.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {
    public static void main(String[] args) {
        Path listing = Paths.get("/home/eduard/Documents/books");
        System.out.printf("File name [%s]\n", listing.getFileName());
        System.out.printf("Number of Name Elements in the Path  [%s]\n", listing.getNameCount());
        System.out.printf("Parent path [%s]\n", listing.getParent());
        System.out.printf("Subpath from Root, 2 elements deep [%s]\n", listing.subpath(0, 2));
        Path current = Paths.get("./../").toAbsolutePath().normalize();
        System.out.printf("Absolute path [%s]\n", current.toString());
        Path pathBetween = current.relativize(listing);
        System.out.printf("Path between two folders [%s]", pathBetween.toString());
    }
}
