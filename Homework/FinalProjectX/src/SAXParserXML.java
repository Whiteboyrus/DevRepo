import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by DMX101 on 24/10/15.
 */
public class SAXParserXML extends DefaultHandler {

    private String thisElement;
    private Constants constants;
    private Students students;
    private List<Students> list;
    private Root root;
    private SimpleDateFormat simpleDateFormat;
    private boolean chk;

    public SAXParserXML() {
        simpleDateFormat = new SimpleDateFormat(constants.DATE_FORMAT);
        list = new ArrayList<Students>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Старт парсинга...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if(thisElement.equals("location")) {
            root.setLocation(new String(ch, start,length));
        }

        if (thisElement.equals("id")) {
            students.setId(new Integer(new String(ch, start, length)));
        }

        if (thisElement.equals("name")) {
            if (chk) {
                students.setName(new String(ch, start, length));
            } else {
                root.setName(new String(ch, start, length));
            }
        }

        if(thisElement.equals("degree")) {
            students.setDegree(new String(ch, start,length));
            root.setStudents(students);
        }

        if (thisElement.equals("dateOfBirth")) {

            try {
                students.setDateOfBirth(simpleDateFormat.parse(new String(ch,start,length)));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (thisElement.equals("rating")) {

                students.setRating(new Integer(new String(ch, start, length)));

            }

            if (thisElement.equals("visible")) {
                students.setVisible(Boolean.valueOf(new String(ch, start, length)));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Завершение парсинга...");
    }
}