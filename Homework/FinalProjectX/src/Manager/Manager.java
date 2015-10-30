package Manager;

import Models.Root;
import Models.Students;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by DMX101 on 25/10/15.
 */

                                                                /*
Класс Manager, содержит вывод всех студентов, паттерн Singleton, сортировку, поиск по заданным параметрам. Пока ничего этого нету :(
                                                                */

public class Manager extends Students {
    Root root = new Root();

   /* public void allStudents() {


        List<Students> list = root.getStudents();

        System.out.println("Все студенты: ");

        for (Students students : list) {

            System.out.println(students.toString());

        }
    }*/


    public void sortingByName() {

        List<Students> studentsList = root.getStudents();
        System.out.print("Сортировка студентов по имени: ");
        Collections.sort(studentsList,new CompareName());

    }


    class CompareName implements Comparator<Students> {


        @Override
        public int compare(Students student1, Students student2) {

            String fio1 = student1.getName();
            String fio2 = student2.getName();

            String name1 = fio1.substring(0, fio1.indexOf(""));
            String name2 = fio2.substring(0, fio2.indexOf(""));

            return name1.compareTo(name2);
        }
    }

                                            /*
                    Singleton pattern со статической константой INSTANCE,
                    которая содержит экземпляр класса Manager.Manager
                                            */
        private static class Singleton {

        private final static Manager INSTANCE = new Manager();
    }

    public static Manager getInstance() {

        return Singleton.INSTANCE;

    }
}