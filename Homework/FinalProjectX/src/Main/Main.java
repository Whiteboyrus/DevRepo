package Main;

import ConstData.Constants;
import Starter.DPStarters;

import java.util.Scanner;

/**
 * Created by DMX101 on 24/10/15.
 */

                                /*
          Главный класс, содержит главное меню и вызовы методов
                                 */

public class Main {

    public static void main(String[] args) {

        Constants constants = new Constants();
        DPStarters dpStarters = new DPStarters();

        String input;
        boolean chk = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\\\\______________________________________________________//");
        System.out.println("\\\\Добро пожаловать в ведомость успеваемости студентов!  //");
        System.out.println("\\\\    Введите \"start\" для загрузки и парсинга           //");
        System.out.println("\\\\    Введите \"startParse\" для парсинга без загрузки    //");
        System.out.println("\\\\    Введите \"exit\" для выхода из программы            //");
        System.out.println("\\\\------------------------------------------------------//");
        System.out.println("\\\\                    Павел Руденков, 2015              //");
        System.out.println("\\\\                  Экзаменационная версия              //");
        System.out.println("\\\\||||||||||||||||||||||||||||||||||||||||||||||||||||||//");

        while (!chk) {
            input = sc.nextLine();
            switch (input) {

                case "start": {
                        dpStarters.startDownload();
                        dpStarters.startParsing();
                    break;
                }

                case "startParse": {
                    dpStarters.startParsing();
                    break;
                }

                case "exit": {
                    System.out.println("Выход из программы");
                    System.out.println("До встречи!");
                    System.exit(0);
                }

                default: {
                    System.out.println("Введён неверный параметр, повторите ввод!");
                }
            }
        }
    }
}