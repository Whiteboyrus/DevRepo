import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMX101 on 25/10/15.
 */
public class Manager extends Students {


    private static class Singleton {

        private final static Manager INSTANCE = new Manager();

    }

    public static Manager getInstance() {

        return Singleton.INSTANCE;

    }

}