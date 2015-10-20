package Manager;

import AllParsers.SAXParser;
import Students.Root;
import Threads.Threads;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Pavlik on 10/20/15.
 */
public class StarterXML extends Threads{

    public StarterXML (String fileName){

        super(fileName);

    }

    @Override
    public void parse() {

        SAXParserFactory saxFact = SAXParserFactory.newInstance();
        SAXParser saxParser = new SAXParser();

        try {
            javax.xml.parsers.SAXParser parser = saxFact.newSAXParser();
            parser.parse(this.getFileName(), saxParser);
            saxParser.outList();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
