package Manager;

import Students.Students;
import Threads.Threads;

/**
 * Created by Pavlik on 10/20/15.
 */
public class Manager {

    private Students students;

    public void json() {



    }

    public void xml () {

        StarterXML stx = new StarterXML(Threads.xml);
        this.stp(stx);

    }

    public void stp(Threads threads) {
        threads.start();
        System.out.print("Thread started");
    }

    //Singleton
    public class SingletonEx {
        private volatile SingletonEx instance;

        private SingletonEx() {

            if (instance == null)
                synchronized (SingletonEx.class) {

                    if (instance == null)
                        instance = new SingletonEx();
                }
        }
    }
}
