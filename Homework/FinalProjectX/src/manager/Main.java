package manager;

import menuModel.MainMenu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by DMX101 on 24/10/15.
 */

                                /*
          Главный класс, содержит главное меню и вызовы методов
                                 */

public class Main {

    /*
    Главный статичный метод, используется как точка входа в программу, содержит вызов метода главного меню
    из класса MainMenu
     */
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();

        mainMenu.mainMenu();

    }
}