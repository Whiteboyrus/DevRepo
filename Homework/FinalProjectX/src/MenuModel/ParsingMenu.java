package MenuModel;

import ConstData.PubData;
import Manager.Manager;
import Models.Root;
import Parsers.GSONParser;
import Parsers.JSONBaseParser;
import Parsers.SAXParserXML;
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

                                        /*
Метод, содержащий меню парсинга файлов, запускается после загрузки, либо отдельно.
                                        */

public class ParsingMenu extends PubData {
    private Thread parsingThread = new Thread();

    public void parsingMenu() {

        Manager manager = new Manager();
        Root root = new Root();

        parsingThread = new Thread("\"Парсинг файлов\" - " + parsingThread.getName());

        System.out.println("Поток " + parsingThread.getName() + " запущен");

        while (!chk) {
            System.out.println("----------------Выберите желаемое действие:--------------------");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"GJSON\" - сериализация структуры json при помощи GSON");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"JSON\" - сериализация структуры json при помощи Jackson");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"SAXXML\" - парсинг структуры XML при помощи SAXParser");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Введите \"exit\" - Выход из программы");
            System.out.println("---------------------------------------------------------------");

            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            switch (input) {

                case "GJSON": {
                    System.out.println("Вы выбрали сериализацию при помощи библиотеки \"GSON\"");
                    GSONParser gsonParser = new GSONParser();
                    gsonParser.GsonSerialize();
                    break;
                }

                case "SJSON": {
                    System.out.println("Вы выбрали сериализацию при помощи библиотеки \"JSON Simple\"");
                    JSONBaseParser jsonBaseParser = new JSONBaseParser();
                    jsonBaseParser.jsonBaseparser();
                    break;
                }

                case "SAXXML": {
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
                        e.printStackTrace();
                    }
                    break;
                }

                case "exit": {
                    System.out.println("Выход из программы");
                    System.out.println("До встречи!");
                    System.exit(0);
                }

                default:
                    System.out.println("Неверный ввод! Повторите...");
                    break;
            }
        }

    }
}