import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Created by DMX101 on 25/10/15.
 */
public class JSONBaseParser {

    public Students jsonBaseparser() {

        Root root = new Root();
        Students students = new Students();
        Constants constants = new Constants();
        Manager manager = new Manager();

        FileReader fileReader = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(constants.DATE_FORMAT);
        JSONArray jsonArray = new JSONArray();

        try {
            fileReader = new FileReader(constants.JSON_NAME);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            /*
            Получаем строку из JSON
             */

            root.setName((String)jsonObject.get("name"));
            root.setLocation((String)jsonObject.get("location"));

            if(jsonObject.containsKey("students")) {

                jsonArray = (JSONArray) jsonObject.get("students");

            } else {
                System.out.println("Объект не найден!");
            }

            Iterator<JSONObject> iterator = jsonArray.iterator();

            while (iterator.hasNext()) {

                students = new Students();
                JSONObject object = iterator.next();

                students.setId((int) (long) object.get("id"));
                students.setName((String)object.get("name"));
                students.setDegree((String)object.get("degree"));
                students.setDateOfBirth((simpleDateFormat.parse((String)object.get("dateOfBirth"))));
                //students.setVisible(Boolean.valueOf()object.get("visible"));

                JSONArray ratingArray = (JSONArray)object.get("rating");

                for (int i = 0; i < ratingArray.size(); i++) {

                   students.setRating((int)(long)ratingArray.get(i));

                }

                root.setStudents(students);
                System.out.println(students.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        return students;
    }
}