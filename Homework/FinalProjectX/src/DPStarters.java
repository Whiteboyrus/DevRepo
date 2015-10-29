/**
 * Created by DMX101 on 29/10/15.
 */
public class DPStarters extends PubData {

    public void startParsing() {
        ParsingThread parsingThread = new ParsingThread();
        parsingThread.run();
    }

    public void startDownload() {
        DownloadThread downloadThread = new DownloadThread(JSON_URL, XML_URL);

        try {
            downloadThread.run();
            downloadThread.getThreadDownloader().join();
            System.out.println("Поток загрузки завершён");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
