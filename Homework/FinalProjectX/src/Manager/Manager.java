package Manager;

import models.Root;
import models.Students;

import java.util.*;

/**
 * Created by DMX101 on 25/10/15.
 */

/*
Класс Manager, содержит вывод всех студентов, паттерн Singleton, сортировку, поиск
 */

public class Manager {

    /*
    Объявление переменных
     */
    private Root root = new Root();
    private Students students = new Students();

    private List<Integer> rate = new ArrayList<>();
    private List<Students> studentsList = new ArrayList<>();

    /*Сеттеры для ArrayList rate и students, для передачи значений в ArrayLists класса Manager
     */

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public void setRate(List<Integer> rate) {
        this.rate = rate;
    }

    /*
    Метод averageMark, предназначен для расчёта средней оценки каждого студента
     */
    public void averageMark() {

        double sum = 0;
        double rez = 0;

        for (int i = 0; i < rate.size(); i++) {
            sum += rate.get(i);
        }
        rez = sum / rate.size();
        System.out.println("Средний балл: " + rez);
    }



    /*
    Метод sortByName, предназначен для сортировки студентов по имени, использует класс CompareName
     */
    public void sortByName() {
        System.out.println("-------------------------------");
        System.out.println("Сортировка студентов по имени: ");
        System.out.println("-------------------------------");
        for (int i = 0; i < studentsList.size(); i++) {
            Collections.sort(studentsList, new CompareName());
            System.out.println(studentsList.get(i));
        }
    }

    /*
    Класс CompareName, содержит переопределённый метод compare, выполняет сравнивание имён при помощи CompareTo,
    ищет подстроку и подаёт её в переменную.
     */
    class CompareName implements Comparator<Students> {

        @Override
        public int compare(Students student1, Students student2) {

            String fio1 = student1.getName();
            String fio2 = student2.getName();

            String name1 = fio1.substring(0, fio1.indexOf(" "));
            String name2 = fio2.substring(0, fio2.indexOf(" "));

            return name1.compareTo(name2);
        }
    }

        /*
    Singleton pattern со статической константой INSTANCE,
    которая содержит экземпляр класса Manager.Manager
        */
        private static class Singleton {

            private final static Manager INSTANCE = new Manager();


            public static Manager getInstance() {

                return Singleton.INSTANCE;

            }
        }
    }