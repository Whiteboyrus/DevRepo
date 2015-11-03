package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMX101 on 24/10/15.
 */

/*
Класс Root, содержащий поля name,location, и ArrayList Students, а также геттеры и сеттеры к ним.
 */

public class Root {

    private String name;
    public String location;

    private List<Students> students;

    public Root() {
        students = new ArrayList<Students>();
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