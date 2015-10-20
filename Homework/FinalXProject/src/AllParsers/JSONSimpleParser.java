package AllParsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

/**
 * Created by Pavlik on 10/18/15.
 */
public class JSONSimpleParser {

    public static void parse () {


        JSONParser parser = new JSONParser();
        JSONArray arr = new JSONArray(); {
            try {
                JSONObject object = (JSONObject)parser.parse(new FileReader("student.json"));

                if(object.containsKey("students")) {
                    arr = (JSONArray)object.get("students");
                }

                Iterator<JSONObject> iter = arr.iterator();
                while (iter.hasNext()) {
                    object = iter.next();
                    System.out.println(object.get("age") + " " + object.get("name") + " " + object.get("surname") + " " + object.get("age") + " " + object.get("isDegree"));
                }
            } catch (Exception e) {
                System.err.print(e);
            } finally {
                System.out.println("Сериализация окончена...");
            }
        }
    }
}
