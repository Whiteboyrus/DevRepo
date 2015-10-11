/**
 * Created by Pavlik on 10/11/15.
 */

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class SAX extends DefaultHandler {

    private ArrayList<Varibles> lst;

    public SAX() {

        lst = new ArrayList<Varibles>();
    }

    String thisElement;

    Varibles var = new Varibles();

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

            if (thisElement.equals("age")) {
                var.setAge(new Integer(new String((new String(ch, start, length)))));
                //lst.add(var);
            }

            if (thisElement.equals("name")) {
                var.setName(new String(new String(ch, start, length)));
                //  lst.add(var);
            }

            if (thisElement.equals("surname")) {
                var.setSurname((new String(new String(ch, start, length))));
                lst.add(var);
            }
    }

    public List<Varibles> outList() {
       System.out.println(lst);
       return lst;
    }
}
