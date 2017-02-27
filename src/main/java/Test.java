import java.io.*;
import java.net.URL;

public class Test {
    private static final String urlString = "http://0.0.0.0:7070/sitemap?lang=de";

    private static final String sitemapsFolder = "google_sitemaps";

    private static final File oldIndexFile = new File(new File(sitemapsFolder), "ch_index.xml");
    private static final File newIndexFile = new File(new File(sitemapsFolder), "index.xml");


    public static void main(String[] args) {

    }


    public static void downloadFile() {
        try{
            URL url = new URL(urlString);
            File file = new File(sitemapsFolder);

            ArchiveUtils.unpackArchive(url, file);

        } catch(IOException x) {
            x.getStackTrace();
        }
    }


    public static void updateIndexFile() {
        XmlUtils.copySitemaps(oldIndexFile, newIndexFile);
        newIndexFile.delete();
    }
}
