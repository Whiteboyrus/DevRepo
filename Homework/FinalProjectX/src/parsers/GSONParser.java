package parsers;

import constants.Constants;
import manager.Manager;
import models.Root;
import models.Students;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by DMX101 on 24/10/15.
 */
        /*
        Библиотека GSON для сериализации файлов формата JSON
        */

public class GSONParser extends Students {

    List<Integer> rate = new ArrayList<>();

    /*
    Метод GsonSerialize, отвечает за сериализацию json, содержит несколько ArrayList, также осуществляет обработку и вывод
    информации, при сериализации обращается к модели Students
     */
    public List<Students> GsonSerialize() {
        Constants constants = new Constants();
        List<Students> studentsList = new ArrayList<Students>();
        List<Integer> ratingList = new ArrayList<>();
        List<String> names = new ArrayList<>();

        try {
            Gson gson = new GsonBuilder().setDateFormat(constants.DATE_FORMAT).create();
            BufferedReader buffRead = new BufferedReader(new FileReader("student.json"));
            Root root = gson.fromJson(buffRead, Root.class);
            Students students = new Students();
            Manager manager = new Manager();
            studentsList = root.getStudents();
            System.out.println("///////////////////////////////////////////////////////////");
            System.out.println("-----------------------------------------------------------");
            System.out.println("--------------Список студентов из файла .json--------------");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            Iterator<Students> it = studentsList.iterator();
            while (it.hasNext()) {
                students = it.next();
                System.out.println(students.toString());
                ratingList = students.getRating();
                manager.setRate(ratingList);
                manager.setStudentsList(studentsList);
                manager.averageMark();
            }
            manager.sortByName();

        } catch (Exception e) {
            System.out.println("Файла не существует! Его нужно загрузить!");
        }
        return studentsList;
    }
}