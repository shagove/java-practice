package ee.sda.fs.path;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExplorer {

    public static void main(String[] args) {
        Path dir = Paths.get("/home/eduard/IdeaProjects/DB/amberpluto/amberpluto-repository/src/main/resources");

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.properties")){
            for(Path entry : stream){
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
