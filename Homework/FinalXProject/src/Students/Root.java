package Students;

import java.util.List;

/**
 * Created by Pavlik on 10/18/15.
 */
public abstract class Root {

    private String name;
    private String location;
    private List<Students> students;

       public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
