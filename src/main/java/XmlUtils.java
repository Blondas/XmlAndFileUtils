import lombok.SneakyThrows;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlUtils {

    private static Document addNodes(Node parent, NodeList nodes) {
        Document dom = parent.getOwnerDocument();

        for (int i = 0; i < nodes.getLength(); i++) {
            parent.appendChild(nodes.item(i));
        }

        return dom;
    }

    private static NodeList findElements(File file, String tagName){
        Document doc = parseXmlFile(file);
        return doc.getDocumentElement().getElementsByTagName(tagName);
    }
    @SneakyThrows
    private static Document parseXmlFile(File file) {
        return DocumentBuilderFactory.newInstance()
                                     .newDocumentBuilder()
                                     .parse(file);
    }
    @SneakyThrows
    public static void copySitemaps(File oldSitemapFile, File newSitemapFile) {
        Document oldSitemapsDocument = parseXmlFile(oldSitemapFile);
        Document newSitemapsDocument = parseXmlFile(newSitemapFile);
        NodeList newSitemapsNodes = newSitemapsDocument.getDocumentElement().getElementsByTagName("sitemap");

//      addNodes(oldSitemaps.getDocumentElement(), sitemaps);

        Element sitemapindex = oldSitemapsDocument.getDocumentElement();
        for (int i = 0; i < newSitemapsNodes.getLength(); i++) {
            Node nodeImported = oldSitemapsDocument.importNode(newSitemapsNodes.item(i), true);
            sitemapindex.appendChild(nodeImported);
        }

        TransformerFactory
                .newInstance()
                .newTransformer()
                .transform(new DOMSource(oldSitemapsDocument), new StreamResult(oldSitemapFile));
    }
}
