package ee.sda.fs.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadingAllFile {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("file.ini");

        List<String> strs = Files.readAllLines(path);
        for (String str : strs){
            System.out.println(str);
        }

        System.out.println("------------------------------------------------------");

        byte[] bytes = Files.readAllBytes(path);
        for (byte b : bytes){
            System.out.print(b + " ");
        }
    }
}
