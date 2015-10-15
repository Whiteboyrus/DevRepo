import java.util.Scanner;

import com.google.gson.*;


public class Main {
	
	
	public static void main (String [] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean chk = false;
		
		
		while (!chk) {
		System.out.println("Enter \"JSON\" or \"GSON\" to continue...");
		String in = sc.nextLine();

		
		
		switch (in) {
		
		case "GSON": {
			
			GSONParse.GsonSerialize();
			break;
			
		}
		
		case "JSON": {
			
			JSONSimple.parse();
			break;
		}
		
		
			}
		}
	}
}
