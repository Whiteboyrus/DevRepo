import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Pavlik on 10/11/15.
 */
public class Main {

    public static void main (String [] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser pars = factory.newSAXParser();
        SAX saxp = new SAX();

        pars.parse(new File("test.xml"), saxp);

        saxp.outList();
    }
}
