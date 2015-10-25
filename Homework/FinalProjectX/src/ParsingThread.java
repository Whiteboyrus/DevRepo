import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DMX101 on 24/10/15.
 */
public class ParsingThread extends PubData implements Runnable{

    private Thread parsingThread = new Thread();
    private ParsingThread parser;
    private JacksonParser jsonSimpleParser;
    private Students students;

    public ParsingThread() {

        parsingThread = new Thread("\"Парсинг файлов\" - " + parsingThread.getName());
    }

    @Override
    public synchronized void run() {
        System.out.println("Поток "+parsingThread.getName()+" запущен");

        while (!chk) {
            System.out.println("----------------Выберите метод парсинга:-----------------------");
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
                    GSONParser.GsonSerialize();
                    break;
                }

                case "JSON": {
                    System.out.println("Вы выбрали сериализацию при помощи библиотеки \"JSON Simple\"");
                  //  jsonSimpleParser.jacksonParser();
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
                    return;
                }

                default:
                    System.out.println("Неверный ввод! Повторите...");
                    break;
            }
        }
    }

    public Thread getParsingThread() {
        return parsingThread;
    }
}
