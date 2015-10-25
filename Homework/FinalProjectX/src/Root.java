import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DMX101 on 24/10/15.
 */
public class Root {

    private String name;
    public String location;

    private List<Students> students;

    public Root(List<Students> students) {
    students = new ArrayList<Students>();
    }

    public Root() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students.add(students);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

