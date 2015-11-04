package menuModel;

import abstracts.abstractClass;
import manager.Manager;
import models.Root;
import parsers.GSONParser;
import parsers.JSONBaseParser;
import parsers.SAXParserXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DMX101 on 26/10/15.
 */

public class ParsingMenu extends abstractClass {

    /*
    Создание объекта потока
     */

    private Thread parsingThread = new Thread();

    /*
    Метод, содержащий меню парсинга файлов, запускается после загрузки, либо отдельно, в любом случае новым потоком.
     */
    public void parsingMenu() {

        Manager manager = new Manager();
        Root root = new Root();
        MainMenu mainMenu = new MainMenu();

        Boolean chk = false;

        parsingThread = new Thread("\"Парсинг файлов\" - " + parsingThread.getName());

        System.out.println("Поток " + parsingThread.getName() + " запущен");

        while (!chk) {
            System.out.println("-                                                             -");
            System.out.println("----------------Выберите желаемое действие:--------------------");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"1\" - сериализация структуры json при помощи GSON -->");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"2\" - сериализация структуры json при помощи JSONSimple -->");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"3\" - парсинг структуры XML при помощи SAXParser -->");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"4\" - Выход из программы -->");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"5\" - Возврат в главное меню -->");
            System.out.println("---------------------------------------------------------------");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.matches("^[1-5]$")) {

                switch (input) {

                    case "1": {
                        System.out.println("Вы выбрали сериализацию при помощи библиотеки \"GSON\"");
                        GSONParser gsonParser = new GSONParser();
                        gsonParser.GsonSerialize();
                        break;
                    }

                    case "2": {
                        System.out.println("Вы выбрали сериализацию при помощи библиотеки \"JSON Simple\"");
                        JSONBaseParser jsonBaseParser = new JSONBaseParser();
                        jsonBaseParser.jsonBaseparser();
                        break;
                    }

                    case "3": {
                        System.out.println("Вы выбрали сериализацию при помощи библиотеки \"SAX\"");
                        SAXParserFactory factory = SAXParserFactory.newInstance();
                        try {
                            SAXParser parser = factory.newSAXParser();
                            SAXParserXML saxParserXML = new SAXParserXML();
                            parser.parse(new File("student.xml"), saxParserXML);
                        } catch (ParserConfigurationException e) {
                            e.printStackTrace();
                        } catch (SAXException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            System.out.println("Файла не существует! Его нужно загрузить!");
                        }
                        break;
                    }

                    case "4": {
                        System.out.println("Выход из программы\n");
                        System.out.println("До встречи!");
                        System.exit(0);
                    }

                    case "5": {
                        System.out.println("Вы выбрали возврат в главное меню -- >");
                        mainMenu.mainMenu();

                    }
                }
            } else {
                System.out.printf("\nНекорректный ввод! Введите цифру от 1 до 5\n");
            }
        }
    }
}