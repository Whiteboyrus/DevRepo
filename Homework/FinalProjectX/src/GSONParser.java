import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DMX101 on 24/10/15.
 */
                            /*
        Библиотека GSON для сериализации файла формата GSON, нужно переделать
                             */

public class GSONParser extends Students {

    private List<Students> lst = new ArrayList<Students>();

        public List<Students> GsonSerialize() {
        Constants constants = new Constants();

        try {
            Gson gson = new GsonBuilder().setDateFormat(constants.DATE_FORMAT).create();
            BufferedReader buffRead = new BufferedReader(new FileReader("student.json"));
            Root root = gson.fromJson(buffRead, Root.class);
            Students students = new Students();
            lst = root.getStudents();
            System.out.println("///////////////////////////////////////////////////////////");
            System.out.println("-----------------------------------------------------------");
            System.out.println("--------------Список студентов из файла .json--------------");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            Iterator<Students> it = lst.iterator();
            while (it.hasNext()) {
                students = it.next();
                System.out.println(students.toString());

            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return lst;
    }



}