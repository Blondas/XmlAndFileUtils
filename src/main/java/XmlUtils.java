import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


//public class XmlUtils {
//
//    public static void addNode(String tagName, String value, Node parent) {
//        Document dom = parent.getOwnerDocument();
//
//        // Create a new Node with the given tag name
//        Node node = dom.createElement(tagName);
//
//        // Add the node value as a child text node
//        Text nodeVal = dom.createTextNode(value);
//        Node c = node.appendChild(nodeVal);
//
//        // Add the new node structure to the parent node
//        parent.appendChild(node);
//    }
//
//    public static NodeList findElements(File file, String tagName) {
//        Document doc = parseXmlFile(file);
//
//        return doc.getDocumentElement().getElementsByTagName(tagName)
//    }
//
//    public static Document parseXmlFile(File file) {
//        try {
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//
//            return db.parse(file);
//        } catch (ParserConfigurationException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (SAXException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//}
