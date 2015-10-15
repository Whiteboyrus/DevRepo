import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONSimple {
	
	public static void parse () {
	

	JSONParser parser = new JSONParser();
	JSONArray arr = new JSONArray(); {
	try {
	JSONObject object = (JSONObject)parser.parse(new FileReader("test.json"));
	
	if(object.containsKey("people")) {
		arr = (JSONArray)object.get("people");
		}

	Iterator<JSONObject> iter = arr.iterator();
	while (iter.hasNext()) {
		 object = iter.next();
		System.out.println(object.get("age") + " " + object.get("name") + " " + object.get("surname") + " " + object.get("age") + " " + object.get("isDegree"));
		}	
	} catch (Exception e) {
		System.err.print(e);
	} finally {
		System.out.println("END!");
			}
		}
	}
}