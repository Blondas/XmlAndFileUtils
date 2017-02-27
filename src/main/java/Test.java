
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Test {
    private static String sitemapsFolder = "google_sitemaps";

    public static void main(String[] args) {

//        try{
//            URL url = new URL("http://0.0.0.0:7070/sitemap?lang=de");
//            File file = new File(sitemapsFolder);
//            ArchiveUtils.unpackArchive(url, file);
//
//
//        } catch(IOException x) {
//            x.getStackTrace();
//        }


        File newIndexFile = new File(new File(sitemapsFolder), "index.xml");
        XmlUtils.dupa(newIndexFile);

    }


}
