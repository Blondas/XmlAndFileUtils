import net.lingala.zip4j.core.ZipFile;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;

public class ArchiveUtils {

    public static void unpackArchive(URL url, File targetDir) throws IOException {
        // make sure we get the actual file
        File zip = File.createTempFile("arc", ".zip", targetDir);
        FileUtils.copyURLToFile(url, zip);
        unpackArchive(zip, targetDir);

        zip.delete();
    }

    @SneakyThrows
    public static void unpackArchive(File zippedFile, File targetDir) throws IOException {
        ZipFile zipFile = new ZipFile(zippedFile);
        zipFile.extractAll(targetDir.getPath());
    }
}