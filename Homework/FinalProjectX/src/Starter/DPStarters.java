package Starter;

import ConstData.PubData;
import Models.Root;
import Threads.DownloadThread;
import Threads.ParsingThread;

/**
 * Created by DMX101 on 29/10/15.
 */

                /*
                Класс-стартер, осуществляет запуск потоков загрузки и парсинга.
                 */

public class DPStarters extends PubData {

    private Root root;

    public void startParsing() {
        ParsingThread parsingThread = new ParsingThread();
        parsingThread.run();
        try {
            parsingThread.getParsingThread().join();
            this.setRoot(parsingThread.getRoot());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startDownload() {
        DownloadThread downloadThread = new DownloadThread(JSON_URL, XML_URL);
        downloadThread.run();
        System.out.println("Поток загрузки завершён");
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}
