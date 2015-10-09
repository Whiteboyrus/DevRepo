import java.util.*;

/**
 * Created by Pavlik on 10/8/15.
 */
public class Functional extends abs {

    ArrayList<Name> listm;
    ArrayList<Name> listw;

    Map<String, List<Name>> hMap;

    Random rand = new Random();

    private String [] mName = {"Василий", "Пётр", "Купрей", "Иван", "Владимир"};
    private String [] mSurName = {"Петров", "Кутузов", "Иванов", "Сидоров", "Рыжов"};
    private String [] wName = {"Александра", "Дарья", "Ольга", "Галина", "Валентина"};
    private String [] wSurName = {"Иванова", "Петрова", "Сидорова", "Купреева", "Краснова"};
    private String [] mwch = {"man", "woman"};

    public void fiogen () {

        listm = new ArrayList<Name>();
        listw = new ArrayList<Name>();

        hMap = new HashMap<String, List<Name>>();
    }

    public void hmPut (String name, String surName, String mwch) {

        Name peoplename = new Name(name, surName);

        if (mwch == this.mwch[0] ) {

            listm.add(peoplename);
            hMap.put(mwch, listm);
        }
        else {
            listw.add(peoplename);
            hMap.put(mwch, listw);
        }

    }

    public String random (String [] str) {

        return str[rand.nextInt(str.length)];

    }

    public void manGen() {

        this.hmPut(this.random(mName), this.random(mSurName), mwch[0]);
    }

    public void womanGen() {

        this.hmPut(this.random(wName), this.random(wSurName), mwch[1]);
    }

    public void output(String mwch) {

        for (Map.Entry<String, List<Name>>entry : hMap.entrySet()) {

            if (entry.getKey().equals(mwch)) {

                nameM = entry.getValue().get(rand.nextInt(entry.getValue().size()));

                System.out.println("Пол: "+ mwch);
                System.out.println("Имя: "+ nameM.getName());
                System.out.println("Фамилия: "+ nameM.getSurName());
                break;
            }
        }
    }
}