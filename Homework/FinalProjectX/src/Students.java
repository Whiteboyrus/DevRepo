import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DMX101 on 24/10/15.
 */
public class Students extends Constants{

    private String name;
    private String degree;
    private List<Integer> rating;
    private boolean visible;
    private int id;
    private Date dateOfBirth;
    private SimpleDateFormat simpleDateFormat;

    Root root = new Root();

    public Students(ArrayList<Integer> rating) {
        this.rating = rating;
        rating = new ArrayList<Integer>();
        simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    }

    public Students() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<Integer> getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating.add(rating);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (visible != students.visible) return false;
        if (id != students.id) return false;
        if (name != null ? !name.equals(students.name) : students.name != null) return false;
        if (degree != null ? !degree.equals(students.degree) : students.degree != null) return false;
        if (rating != null ? !rating.equals(students.rating) : students.rating != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(students.dateOfBirth) : students.dateOfBirth != null)
            return false;
        if (simpleDateFormat != null ? !simpleDateFormat.equals(students.simpleDateFormat) : students.simpleDateFormat != null)
            return false;
        return !(root != null ? !root.equals(students.root) : students.root != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (visible ? 1 : 0);
        result = 31 * result + id;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (simpleDateFormat != null ? simpleDateFormat.hashCode() : 0);
        result = 31 * result + (root != null ? root.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "Имя: " + name + '\'' +
                ", Факультет: " + degree + '\'' +
                ", Рейтинг: " + rating +
                ", Видимый: " + visible +
                ", Идентификатор: " + id +
                ", Дата рождения: " + dateOfBirth +
               '}';
    }
}
