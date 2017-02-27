import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class XmlUtils {

    private static Document addNodes(Node parent, NodeList nodes) {
        Document dom = parent.getOwnerDocument();

        for (int i = 0; i < nodes.getLength(); i++) {
            parent.appendChild(nodes.item(i));
        }

        return dom;
    }

    private static NodeList findElements(File file, String tagName)
            throws ParserConfigurationException, IOException, SAXException{

        Document doc = parseXmlFile(file);
        return doc.getDocumentElement().getElementsByTagName(tagName);
    }

    private static Document parseXmlFile(File file) throws ParserConfigurationException, IOException, SAXException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        return db.parse(file);
    }

    public static void addSitemaps(File from, File to) {
        try {
            NodeList sitemaps = findElements(from, "sitemap");
            NodeList sitemapindex = findElements(to, "sitemapindex");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }


    }

    public static void copySitemaps(File oldSitemapFile, File newSitemapFile) {
        try {
            Document oldSitemaps = parseXmlFile(oldSitemapFile);
            Document newSitemaps = parseXmlFile(newSitemapFile);

            NodeList sitemaps = newSitemaps.getDocumentElement().getElementsByTagName("sitemap");

            Document updatedOldSitemaps = addNodes(oldSitemaps.getDocumentElement(), sitemaps);


            TransformerFactory
                    .newInstance()
                    .newTransformer()
                    .transform(new DOMSource(updatedOldSitemaps), new StreamResult(oldSitemapFile));

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }
}
