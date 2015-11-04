package starter;

import abstracts.abstractClass;
import models.Root;
import threads.DownloadThread;
import threads.ParsingThread;

/**
 * Created by DMX101 on 29/10/15.
 */

                /*
                Класс-стартер, содержит методы для запуска потоков парсинга и загрузки соответственно.
                 */

public class DPStarters extends abstractClass {


    /*
    Метод startParsing, отвечает за запуск потока парсеров.
     */

    public void startParsing() {
        ParsingThread parsingThread = new ParsingThread();
        parsingThread.run();
        try {
            Thread parsThread = Thread.currentThread();
            parsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    Метод startDownload, отвечает за запусе потока загрузки
     */

    public void startDownload() {
        DownloadThread downloadThread = new DownloadThread(JSON_URL, XML_URL);
        downloadThread.run();
        System.out.println("Поток загрузки завершён");
    }
}
