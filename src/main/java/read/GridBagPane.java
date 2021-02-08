package read;

import org.w3c.dom.Document;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;

public class GridBagPane extends JPanel {
    private GridBagConstraints constraints;

    public GridBagPane(File file) {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            if(file.toString().contains("-schemta"))
            {
                factory.setNamespaceAware(true);
                final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
                final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
                factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

            }

            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            parseGridbag(doc.getDocumentElement());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Component get(String name) {
        Component[] components = getComponents();
        for (int i = 0; i < components.length; i++)
            if(components[i].getName().equals(name)) return components[i];
        return null;
    }
}
