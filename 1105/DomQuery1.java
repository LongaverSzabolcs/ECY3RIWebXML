import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.List;
import java.util.ArrayList;

public class DomQuery1  {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException, XPathExpressionException {
        File xmFile = new File("ecy3ri_orarend.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmFile);
        doc.getDocumentElement().normalize();
        
        XPathFactory xpFact = XPathFactory.newInstance();
        XPath xp = xpFact.newXPath();
        XPathExpression xpExp = xp.compile("/orarend/ora/targy");
        NodeList targylista = (NodeList) xpExp.evaluate(doc, XPathConstants.NODESET);  

        List<String> targyak = new ArrayList<String>();

        for (int i = 0; i < targylista.getLength(); i++) {
            if(!targyak.contains(targylista.item(i).getTextContent())) targyak.add(targylista.item(i).getTextContent());
        }
        System.out.println(String.join(", ", targyak));
    }


}
