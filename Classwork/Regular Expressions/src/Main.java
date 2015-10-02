import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

abstract class Variables {
	 
	 static String ww;
	 static String validation;
	 static Scanner sc = new Scanner(System.in);
	 static boolean chk = false;
	
}

 
public class Main extends Variables {

	public static final Pattern pt = Pattern.compile 
			("[+]{1}(375)((29)|(25)|(33)|(44)|)[0-9]{7}");
	public static final Pattern ptrn = Pattern.compile 
			("\\w{1}((029)|(025)|(033)|(044)|)[0-9]{7}");
	
	
	public static void matching () {
		ww = sc.nextLine();
		validation = "Валидация номера \"" + ww + "\"";
		Matcher match = pt.matcher(ww);
		Matcher matcher = ptrn.matcher(ww);
		if (match.matches() | matcher.matches())
				validation +="\nНомер принадлежит региону Беларусь";
		else
			validation += "\nНомер не принадлежит региону Беларусь";
		System.out.println(validation);
}
	
	public static void main (String [] args) {
		while (!chk) {
		System.out.println("Введите номер телефона для валидации:");
		
		matching();
		}
	}
}