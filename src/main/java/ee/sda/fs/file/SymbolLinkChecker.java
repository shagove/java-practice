package ee.sda.fs.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class SymbolLinkChecker {
    public static void main(String[] args) {
        Path path = Paths.get("/home/eduard/link");
        try {
//            if (Files.isSymbolicLink(path))
//                path = Files.readSymbolicLink(path);

            System.out.println(path.toString());
            System.out.println(Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS).lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//2016-05-08T15:18:53Z