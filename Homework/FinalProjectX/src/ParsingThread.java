/**
 * Created by DMX101 on 24/10/15.
 */
                                                /*
                            Класс, содержащий методы поток для парсинга файлов, наледуется
                            от интерфейса Runnable
                                                 */
public class ParsingThread implements Runnable{

    private ParsingMenu parsingMenu = new ParsingMenu();
    private Thread parsingThread = new Thread();

    private Students students;
    private Manager manager;

    public ParsingThread() {

    }

    @Override
    public synchronized void run() {
        parsingMenu.parsingMenu();
    }

    public Thread getParsingThread() {
        return parsingThread;
    }
}
