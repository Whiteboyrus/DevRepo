import java.util.List;

/**
 * Created by DMX101 on 25/10/15.
 */
public class Manager extends Students {



    public void allStudents() {
        Root root = new Root();

        List<Students> list = root.getStudents();

        System.out.println("Все студенты: ");

        for (Students students : list) {

            System.out.println(students.toString());

        }
    }

                                            /*
                    Singleton pattern со статической константой INSTANCE,
                    которая содержит экземпляр класса Manager
                                            */
        private static class Singleton {

        private final static Manager INSTANCE = new Manager();
    }

    public static Manager getInstance() {

        return Singleton.INSTANCE;

    }
}