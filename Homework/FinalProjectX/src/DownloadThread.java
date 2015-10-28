import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DMX101 on 24/10/15.
 */
public class DownloadThread extends PubData implements Runnable {

    Constants constants = new Constants();
    Thread threadDownloader = new Thread();
    File jsonFile = new File(constants.JSON_NAME);
    File xmlFile = new File(constants.XML_NAME);

    public DownloadThread( String jsonURL, String xmlURL) {
        threadDownloader = new Thread("\"Загрузка файлов\" - " + threadDownloader.getName());

        this.JSON_URL = jsonURL;
        this.XML_URL = xmlURL;
        threadDownloader.run();
    }

    @Override
    public synchronized void run() {

        System.out.println("Поток "+threadDownloader.getName()+" запущен,идёт загрузка, один момент...");

            try {
                fileDownloader(JSON_URL);
                fileDownloader(XML_URL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("Файлы " +jsonFile+ " и " +xmlFile+ " загружены и сохранены в каталог проекта.");
        }

    public String fileDownloader(String fileURL) throws IOException {

        InputStream inputStreamJSON = null;
        InputStream inputStreamXML = null;

        FileOutputStream fileOutputStreamJSON = null;
        FileOutputStream fileOutputStreamXML = null;

        try {
            URL urlJSON = new URL(JSON_URL);
            URL urlXML = new URL(XML_URL);

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
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileURL;
    }

    public Thread getThreadDownloader() {
        return threadDownloader;
    }
}