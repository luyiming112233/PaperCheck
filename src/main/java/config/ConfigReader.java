package config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class ConfigReader {
    private static DocumentBuilderFactory dbFactory = null;
    private static DocumentBuilder db = null;
    private static Document document = null;

    static {
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            db = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static WordConfig getWordConfig(String fileName) throws Exception {
        document = db.parse(fileName);
        NodeList nodes = document.getElementsByTagName("word");
        WordConfig wordConfig = new WordConfig();
        if (nodes.getLength() > 0) {
            org.w3c.dom.Node node = nodes.item(0);
            NamedNodeMap namedNodeMap = node.getAttributes();
            NodeList cList = node.getChildNodes();
            ArrayList<String> contents = new ArrayList();
            for (int j = 1; j < cList.getLength(); j += 2) {
                org.w3c.dom.Node cNode = cList.item(j);
                String content = cNode.getFirstChild().getTextContent();
                contents.add(content);
            }

            wordConfig.setK1(contents.get(0));
            wordConfig.setK2(contents.get(1));
        }

        return wordConfig;

    }
}