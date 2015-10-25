import java.util.Scanner;

/**
 * Created by DMX101 on 24/10/15.
 */
public class Main extends PubData {

    public static void main(String[] args) {

        Constants constants = new Constants();

        Thread thread = new Thread();
        DownloadThread downloadThread = new DownloadThread(JSON_URL, XML_URL);
        ParsingThread parsingThread = new ParsingThread();
        String input;
        boolean chk = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\\\\______________________________________________________//");
        System.out.println("\\\\Добро пожаловать в ведомость успеваемости студентов!  //");
        System.out.println("\\\\            Введите \"start\"  для начала работы!       //");
        System.out.println("\\\\------------------------------------------------------//");
        System.out.println("\\\\                    Павел Руденков, 2015              //");
        System.out.println("\\\\                  Экзаменационная версия              //");
        System.out.println("\\\\||||||||||||||||||||||||||||||||||||||||||||||||||||||//");


        while (!chk) {
            input = sc.nextLine();
            switch (input) {

                case "start": {
                    System.out.println("Основной поток запущен");

                    try {
                        downloadThread.run();
                        downloadThread.getThreadDownloader().join();
                        System.out.println("Поток загрузки завершён");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        parsingThread.run();
                        parsingThread.getParsingThread().join();
                        System.out.println("Поток парсинга завершён");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                case "exit": {
                    return;
                }
                default: {
                    System.out.println("Введён неверный параметр, повторите ввод!");
                }
            }
        }
    }
}