package Parsers;

import ConstData.Constants;
import Models.Root;
import Models.Students;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by DMX101 on 24/10/15.
 */

                                    /*
     Класс парсера SAX, предназначенного для парсинга XML файлов, не работает
                                     */

public class SAXParserXML extends DefaultHandler {

    private String thisElement;
    private Constants constants;
    private List<Students> list;
    private Students students;
    private Root root;
    private SimpleDateFormat simpleDateFormat;
    private boolean chk = false;

    public SAXParserXML() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list = new ArrayList<Students>();
        root = new Root();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Старт парсинга файла student.xml при помощи SAX...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {


        if (thisElement.equals("name")) {
            if (chk) {
                students.setName(new String(ch, start, length));
            } else {
                root.setName(new String(ch, start, length));
            }
        }

        if(thisElement.equals("location")) {
            root.setLocation(new String(ch, start,length));
        }

        if (thisElement.equals("id")) {
            chk = true;
            students = new Students();
            students.setId(Integer.valueOf(new String(ch, start, length)));
        }



        if(thisElement.equals("degree")) {
          students.setDegree(new String(ch, start,length));
        }

        if (thisElement.equals("dateOfBirth")) {

            try {
                students.setDateOfBirth(simpleDateFormat.parse(new String(ch,start,length)));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (thisElement.equals("rating")) {

                students.setRating(Integer.valueOf(new String(ch,start,length)));

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
        System.out.println("Завершение парсинга файла student.xml ...");
        root.setStudents(students);
        list = root.getStudents();
        Iterator<Students> it = list.iterator();
        while (it.hasNext()) {
            students = it.next();
            System.out.println(students.toString());
        }
    }

    public Students getStudents() {
        return students;
    }
}