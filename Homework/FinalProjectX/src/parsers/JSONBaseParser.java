package parsers;

import constants.Constants;
import manager.Manager;
import models.Root;
import models.Students;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DMX101 on 25/10/15.
 */

            /*
            Встроенный парсер для сериализации файлов формата JSON
             */

public class JSONBaseParser {

    public Students jsonBaseparser() {

        Root root = new Root();
        Students students = new Students();
        Constants constants = new Constants();
        Manager manager = new Manager();

        FileReader fileReader = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(constants.DATE_FORMAT);
        JSONArray jsonArray = new JSONArray();
        List<Integer> ratingList = new ArrayList<>();
        List<Students> studentsList = new ArrayList<>();

        try {
            fileReader = new FileReader(constants.JSON_NAME);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            /*
            Получаем и обрабатываем данные из JSON
             */

            root.setName((String) jsonObject.get("name"));
            root.setLocation((String) jsonObject.get("location"));

            if (jsonObject.containsKey("students")) {

                jsonArray = (JSONArray) jsonObject.get("students");

            } else {
                System.out.println("Объект не найден!");
            }

            Iterator<JSONObject> iterator = jsonArray.iterator();

            System.out.println("///////////////////////////////////////////////////////////");
            System.out.println("-----------------------------------------------------------");
            System.out.println("--------------Список студентов из файла .json--------------");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            while (iterator.hasNext()) {

                students = new Students();
                JSONObject object = iterator.next();

                students.setId((int) (long) object.get("id"));
                students.setName((String) object.get("name"));
                students.setDegree((String) object.get("degree"));
                students.setDateOfBirth((simpleDateFormat.parse((String) object.get("dateOfBirth"))));
                students.setVisible((Boolean) object.get("visible"));

                JSONArray ratingArray = (JSONArray) object.get("rating");

                for (int i = 0; i < ratingArray.size(); i++) {
                    students.setRating((int) (long) ratingArray.get(i));
                }
                System.out.println(students.toString());
                ratingList = students.getRating();
                manager.setRate(ratingList);
                manager.averageMark();
                studentsList = root.getStudents();
                manager.setStudentsList(studentsList);
                root.setStudents(students);
            }
            manager.sortByName();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (java.text.ParseException e1) {
            e1.printStackTrace();
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return students;
    }
}