package threads;

import menuModel.ParsingMenu;
import models.Root;
import models.Students;

/**
 * Created by DMX101 on 24/10/15.
 */

/*
Класс, содержащий методы поток для парсинга файлов, implements Runnable
 */

public class ParsingThread implements Runnable {


    /*
    Создание объектов класса.
     */
    private ParsingMenu parsingMenu = new ParsingMenu();
    private Thread parsingThread = new Thread();

    @Override
    public synchronized void run() {
        parsingMenu.parsingMenu();
    }
}
