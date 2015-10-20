import Manager.Manager;
import Manager.StarterXML;
import Threads.Threads;


/**
 * Created by Pavlik on 10/18/15.
 */
public class Main extends Thread {


    public static void main(String[] args) {

Manager man = new Manager();
        man.xml();
        System.out.print("Тест main");
    }
}