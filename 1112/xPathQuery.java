import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.xpath.*;

public class xPathQuery  {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException, XPathExpressionException {
        File xmFile = new File("studentECY3RI.xml");
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmFile);
        doc.getDocumentElement().normalize();

        //1
        System.out.println(String.join(", ", executeQuery(doc, "/class/student")));
        
        //2
        WriteArray(executeQuery(doc, "student[@id='02']"));

        //3
        WriteArray(executeQuery(doc, "student"));

        //4
        WriteArray(executeQuery(doc, "/class/student[1]"));

        //5
        WriteArray(executeQuery(doc, "/class/student[last()]"));

        //6
        WriteArray(executeQuery(doc, "/class/student[last()-1]"));

        //7
        WriteArray(executeQuery(doc, "/class/student[position()<2]"));
        
        //8
        WriteArray(executeQuery(doc, "/class/"));
        
        //9
        
        //10
        
        //11
    
        //12
    
    }

    //
    public static String[] executeQuery(Document myDoc, String query) throws  XPathExpressionException {
        XPath xp = XPathFactory.newInstance().newXPath();
        XPathExpression xpExp = xp.compile("");
        NodeList nList = (NodeList) xpExp.evaluate(myDoc, XPathConstants.NODESET);

        String[] result = new String[nList.getLength()];

        for (int i = 0; i < nList.getLength(); i++) {
            result[i] = nList.item(i).getTextContent();
        }

        return result;
    }

    public static void WriteArray(String[] myArray) {
        System.out.println(String.join(", ", myArray));
    }
}