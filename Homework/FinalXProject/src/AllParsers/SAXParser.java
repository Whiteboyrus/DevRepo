package AllParsers;

import Students.Students;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavlik on 10/18/15.
 */

public class SAXParser extends DefaultHandler {

    private ArrayList<Students> lst;
    private SimpleDateFormat dt;

    public SAXParser() {
        dt = new SimpleDateFormat("yyy-MM-dd");
        lst = new ArrayList<Students>();
    }

    String thisElement;

    Students var = new Students();

    public void startDocument() throws SAXException {
        System.out.println("Начало парсинга...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец парсинга...");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (thisElement.equals("id")) {
            var.setId(new Integer(new String(ch, start, length)));
        }

        if (thisElement.equals("name")) {
            var.setName(new String(ch, start, length));
        }

        if (thisElement.equals("degree")) {
            var.setDegree(new String(ch, start, length));
        }

        if (thisElement.equals("dateOfBirth")) {
            try {
                var.setDateOfBirth(dt.parse(new String(ch, start, length)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (thisElement.equals("rating")) {
            var.setRating(new String(ch, start, length));
        }
    }

    public List<Students> outList() {
        System.out.println(lst);
        return lst;
    }
}
