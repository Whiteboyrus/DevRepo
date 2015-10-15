import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

public class GSONParse {
	
	public static void GsonSerialize() {
	
	List<People> lst = new ArrayList<People>(); 
		
	try {
	Gson gson = new Gson();
	BufferedReader buffRead = new BufferedReader(new FileReader("test.json"));
	Root root = gson.fromJson(buffRead, Root.class);
	
	lst = root.getPeople();
	
	Iterator<People> it = lst.iterator();
	while(it.hasNext()) {
		People people;
		people = it.next();
		System.out.println(people.getAge() + " " + people.getName() + " " + people.getSurName() + " " + people.getId());
	}
}
	
	catch (Exception e) {
		System.err.print(e);
		}
		
	}
}