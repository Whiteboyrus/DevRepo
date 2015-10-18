package AllParsers;

import Students.Students;
import Students.Root;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pavlik on 10/18/15.
 */
public class GSONParser  extends Root {

    public static void GsonSerialize() {

        List<Students> lst = new ArrayList<Students>();

        try {
            Gson gson = new Gson();
            BufferedReader buffRead = new BufferedReader(new FileReader("test.json"));
             Root root = gson.fromJson(buffRead, Root.class);

            lst = root.getStudents();

            Iterator<Students> it = lst.iterator();
            while(it.hasNext()) {
                Students students;
                students = it.next();
                System.out.println(students.getDateOfBirth() + " " + students.getName() + " " + students.getDegree() + " " + students.getRating());
            }
        }

        catch (Exception e) {
            System.err.print(e);
        }

    }
}
