import net.lingala.zip4j.core.ZipFile;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;

public class ArchiveUtils {

    @SneakyThrows
    public static void unpackArchive(URL url, File targetDir) {
        // make sure we get the actual file
        File zip = File.createTempFile("arc", ".zip", targetDir);
        zip.deleteOnExit();
        FileUtils.copyURLToFile(url, zip);
        unpackArchive(zip, targetDir);
    }

    @SneakyThrows
    public static void unpackArchive(File zippedFile, File targetDir) {
        ZipFile zipFile = new ZipFile(zippedFile);
        zipFile.extractAll(targetDir.getPath());
    }
}