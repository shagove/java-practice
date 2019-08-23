package ee.sda.fs.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreaterDeleter {
    public static void main(String[] args) throws IOException {
        Path target = Paths.get("./file.ini");

        //create new file
        Path file = Files.createFile(target);

        //delete file
        Files.delete(target);
    }

}
