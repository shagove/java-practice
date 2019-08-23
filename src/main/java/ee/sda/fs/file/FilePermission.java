package ee.sda.fs.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FilePermission {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/eduard/.profile");

        PosixFileAttributes attrs = Files.readAttributes(path, PosixFileAttributes.class);

        Set<PosixFilePermission> permissions = attrs.permissions();
	    permissions.clear();

        String owner = attrs.owner().getName();
        String perms = PosixFilePermissions.toString(permissions);
        System.out.printf("%s %s%n", owner, perms);

        permissions.add(PosixFilePermission.OWNER_READ);
        permissions.add(PosixFilePermission.GROUP_READ);
        permissions.add(PosixFilePermission.OTHERS_READ);
        permissions.add(PosixFilePermission.OWNER_WRITE);
        Files.setPosixFilePermissions(path, permissions);

        perms = PosixFilePermissions.toString(permissions);
        System.out.printf("%s %s%n", owner, perms);
    }
}
