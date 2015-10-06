import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


abstract class Variables {
	
	static ArrayList<String> tList = new ArrayList<String>();
	Iterator<String> it;
	
	Pattern pt2 = Pattern.compile("a");
	Pattern pt = Pattern.compile("[0-9a-zA-z]+$");
	Matcher match;
	Scanner sc = new Scanner(System.in);
	

	String str = "";


}

public class AList extends Variables {

	public void arrList() {

		while (true) {
			System.out.print("Введите элементы массива: ");
			str = sc.nextLine();
			match = pt.matcher(str);

			if (str.equals("exit")) {
				break;
			} else if (match.matches()) {
				tList.add(str);
			}

		}
		System.out.printf("\n Полученный массив: \n" + tList);

		for (it = tList.listIterator(); it.hasNext(); ) {
			String t = it.next();

			int dig = tList.indexOf(t);

			match = pt2.matcher(t);

			if (match.find()) {
				tList.set(dig, t.replaceAll("a", ""));

			}

		}
		System.out.printf("\nОбработанный ArrayList \n" + tList);
		sc.close();

		for (it = tList.listIterator(); it.hasNext(); ) {

			if (Collections.frequency(tList, it.next()) >= 2) {
				it.remove();
			}
	}
		System.out.printf("\n ArrayList без дубликатов значений: " + tList);
	}
}
