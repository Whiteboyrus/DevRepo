package menuModel;

import starter.DPStarters;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Created by Pavlik on 11/3/15.
 */
public class MainMenu extends KeyAdapter {

    /*
    Метод MainMenu, отвечает за главное меню программы, работает в основном потоке.
     */

    public void mainMenu() {

        DPStarters dpStarters = new DPStarters();

        boolean chk = false;
        String input;


        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\\\\______________________________________________________//");
        System.out.println("\\\\Добро пожаловать в ведомость успеваемости студентов!  //");
        System.out.println("\\\\    Введите \"start\" для загрузки и парсинга           //");
        System.out.println("\\\\    Введите \"startp\" для парсинга без загрузки        //");
        System.out.println("\\\\    Введите \"exit\" для выхода из программы            //");
        System.out.println("\\\\------------------------------------------------------//");
        System.out.println("\\\\               Павел Руденков, 2015                   //");
        System.out.println("\\\\                                                      //");
        System.out.println("\\\\||||||||||||||||||||||||||||||||||||||||||||||||||||||//");



            while (!chk) {
                Scanner sc = new Scanner(System.in);
                input = sc.nextLine();

                switch (input) {

                    case "start": {
                        dpStarters.startDownload();
                        dpStarters.startParsing();
                        break;
                    }

                    case "startp": {
                        dpStarters.startParsing();
                        break;
                    }

                    case "exit": {
                        System.out.println("Выход из программы");
                        System.out.println("До встречи!");
                        System.exit(0);
                        break;
                    }

                    default: {
                        System.out.println("Некорректный ввод, повторите");
                        break;
                    }
                }
            }
        }
    }