import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by DMX101 on 25/10/15.
 */
public class Manager extends Students {


    public String averageMark() {

        Students students = new Students();
        Root root = new Root();
        String s = "";

        List<Students> list = root.getStudents();
    return s;
    }


                                            /*
                    Singleton pattern со статической константой INSTANCE,
                    которая содержит экземпляр класса Manager
                                            */
        private static class Singleton {

        private final static Manager INSTANCE = new Manager();
    }

    public static Manager getInstance() {

        return Singleton.INSTANCE;

    }
}