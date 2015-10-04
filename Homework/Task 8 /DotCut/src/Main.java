import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main (String [] args) throws Exception {
		final Pattern pt = Pattern.compile 
				("[[:word:]]{1,}\\.((xml)|(json))$");
		
		String string = "";
		
		Scanner sc = new Scanner(System.in);
		boolean chk = false;		
		
		while (!chk) {
		System.out.print("Введите имя файла в формате <Имя файла>.xml/json: ");
		string = sc.nextLine();
		
		Matcher match = null;
		match = pt.matcher(string);	
		
		check(match, string);
		}
	}
	
	public static void check (Matcher match, String string) {
		if (match.find()) {
			System.out.print("\nФормат файла корректен, обработка\n");
			string = string.replaceAll("[[:word:]]", "");
			System.out.printf("Результирующая строка: %s \n", string);
		} else {
			System.out.println("\nНеверный формат файла, повторите ввод");
			}
	}
}