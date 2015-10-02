import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


abstract class Variables {
	
	//Объявление переменных
	
	public static final Pattern pt = Pattern.compile //Паттерн 
			("(.)[a-z]\\1{1,}");
	
	static Matcher match;
	
	static String in = "";
	
	//StringBuilder str = new StringBuilder();
	static StringBuffer strbuff = new StringBuffer();
}

public class Main extends Variables {	//расширение класса Main до abstract Variables
	

	public static void main (String [] args) {
	
	Scanner sc = new Scanner(System.in);
	
	
	System.out.println("Пожалуйста, введите строку на английском языке: ");
	in = sc.nextLine();
	
	match = pt.matcher(in);
	
	//Отбор групп вхождения, замена на количество и вывод
	
	while(match.find()) {	
		
		//match.appendTail(sb);
		match.appendReplacement(strbuff, in.substring (match.start(), match.start()) +(match.end() - match.start()));
	}	
	
	match.appendTail(strbuff);
	System.out.printf("Результирующая строка: %s", strbuff);
	}
}

