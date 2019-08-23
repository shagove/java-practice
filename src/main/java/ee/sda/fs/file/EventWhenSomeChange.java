package ee.sda.fs.file;


import java.io.IOException;
import java.nio.file.*;

public class EventWhenSomeChange {
    public static void main(String[] args) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path path = FileSystems.getDefault().getPath("/home/eduard/target");
            WatchKey key = path.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

            int shutdown = 0;
            while (shutdown != 5){
                key = watcher.take();
                for (WatchEvent event: key.pollEvents()){
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY){
                        System.out.println("Directory has modified its content!");
                        shutdown++;
                    }
                    key.reset();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
