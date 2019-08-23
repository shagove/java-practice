package ee.sda.fs.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureImpl {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("file.ini");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
            ByteBuffer buffer = ByteBuffer.allocate(100_000_000);

            Future<Integer> result = channel.read(buffer, 0);

            if (!result.isDone()){
                Demo.work();
            }

            Integer bytesRead = result.get();
            System.err.println("Bytes read [" + bytesRead + "]");

        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo{

    private static int count = 1;

    static void work(){
        while (System.currentTimeMillis() % 9929 != 0){
            if (System.currentTimeMillis() % 113 == 0)
                System.err.printf("[%3d] INSIDE\n", count++);
        }
    }
}
