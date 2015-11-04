package threads;

import abstracts.abstractClass;
import constants.Constants;
import models.Root;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DMX101 on 24/10/15.
 */

                /*
                Класс, отвечающий за загрузку файлов из интернета, наследуется от интерфейса Runnable,
                запускается отдельным потоком через DPStarters
                 */

public class DownloadThread extends abstractClass implements Runnable {

    /*
    Создание объектов.
     */

    private Constants constants = new Constants();
    private Thread threadDownloader = new Thread();

    private File jsonFile = new File(constants.JSON_NAME);
    private File xmlFile = new File(constants.XML_NAME);

    /*
    Конструктор
     */
    public DownloadThread( String jsonURL, String xmlURL) {
        threadDownloader = new Thread("\"Загрузка файлов\" - " + threadDownloader.getName());

        this.JSON_URL = jsonURL;
        this.XML_URL = xmlURL;

        threadDownloader.run();
    }

    /*
    Синхронизированный переопределённый метод run, отвечает за запуск загрузчика файлов.
     */

    @Override
    public synchronized void run() {

        System.out.println("Поток "+threadDownloader.getName()+" запущен, идёт загрузка "+jsonFile + " и " +xmlFile+ ", один момент...");

            try {
                fileDownloader(abstractClass.JSON_URL);
                fileDownloader(abstractClass.XML_URL);
            } catch (IOException e) {


            }
        }


    /*
    Метод fileDownloader, предназначен для загрузки файлов по URL ссылке
     */

    public String fileDownloader(String fileURL) throws IOException {

        InputStream inputStreamJSON = null;
        InputStream inputStreamXML = null;

        FileOutputStream fileOutputStreamJSON = null;
        FileOutputStream fileOutputStreamXML = null;

        try {
            URL urlJSON = new URL(abstractClass.JSON_URL);
            URL urlXML = new URL(abstractClass.XML_URL);

            HttpURLConnection urlConnectionJSON = (HttpURLConnection) urlJSON.openConnection();
            HttpURLConnection urlConnectionXML = (HttpURLConnection) urlXML.openConnection();

            int responseCodeJSON = urlConnectionJSON.getResponseCode();
            int responseCodeXML = urlConnectionXML.getResponseCode();

            if (responseCodeJSON == HttpURLConnection.HTTP_OK) {

                inputStreamJSON = urlConnectionJSON.getInputStream();
                fileOutputStreamJSON = new FileOutputStream(jsonFile);
            }

            if (responseCodeXML == HttpURLConnection.HTTP_OK) {

                inputStreamXML = urlConnectionXML.getInputStream();
                fileOutputStreamXML = new FileOutputStream(xmlFile);
            }

            int byteRead = -1;

            byte[] buff = new byte[4096];

            while ((byteRead = inputStreamJSON.read(buff)) != -1) {
                fileOutputStreamJSON.write(buff, 0, byteRead);
            }

            while ((byteRead = inputStreamXML.read(buff)) != -1) {
                fileOutputStreamXML.write(buff, 0, byteRead);
            }

            if (inputStreamJSON != null) {
                inputStreamJSON.close();
                inputStreamXML.close();
            }

            if (fileOutputStreamJSON != null) {
                fileOutputStreamXML.close();
                fileOutputStreamJSON.close();
            }

        } catch (IOException e) {
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("Не удаётся загрузить "  +jsonFile+ " и " +xmlFile+ "! Проверьте подключение!");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        }
        return fileURL;
    }
}