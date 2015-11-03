package parsers;

import constants.Constants;
import Manager.Manager;
import models.Root;
import models.Students;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by DMX101 on 24/10/15.
 */

    /*
     Парсер SAX, предназначенный для парсинга файлов формата XML
    */

public class SAXParserXML extends DefaultHandler {

    private String thisElement;
    private Constants constants;

    private List<Students> studentsList;
    private List<Integer> ratingList;

    private Students students;
    private Root root;
    private Manager manager;
    private SimpleDateFormat simpleDateFormat;
    private boolean chk = false;

    public SAXParserXML() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        studentsList = new ArrayList<>();
        ratingList = new ArrayList<>();
        root = new Root();
        manager = new Manager();
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


        switch(thisElement)
        {
            case "location": {
                root.setLocation(new String(ch, start, length));
                break;
            }

            case "id": {
                chk = true;
                students = new Students();
                students.setId(Integer.valueOf(new String(ch, start, length)));
                break;
            }

            case "name": {
                if (chk) {
                    students.setName(new String(ch, start, length));
                } else {
                    root.setName(new String(ch, start, length));
                }
                break;
            }

            case "degree": {
                students.setDegree(new String(ch, start, length));
                break;
            }

            case "dateOfBirth": {
                try {
                    students.setDateOfBirth(simpleDateFormat.parse(new String(ch, start, length)));
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }

            case "rating": {
                students.setRating(Integer.valueOf(new String(ch, start, length)));
                break;
            }

            case "visible": {
                students.setVisible(Boolean.valueOf(new String(ch, start, length)));
                root.setStudents(students);
                studentsList.add(students);
                manager.setStudentsList(studentsList);
                ratingList = students.getRating();
                manager.setRate(ratingList);
                System.out.println(students.toString());
                manager.averageMark();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() throws SAXException {
        manager.sortByName();
        System.out.println("Завершение парсинга файла student.xml ...");
    }
}