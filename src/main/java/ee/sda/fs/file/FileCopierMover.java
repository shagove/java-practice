package ee.sda.fs.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopierMover {

    public static void main(String[] args) throws IOException {
        Path sourceDir = Paths.get("./file.ini");
        Path targetDir = Paths.get("./tmp/file.ini");

        Files.copy(sourceDir, targetDir, StandardCopyOption.REPLACE_EXISTING);
        //Files.move(sourceDir, targetDir, StandardCopyOption.REPLACE_EXISTING);
    }

}
