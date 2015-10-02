import java.util.Scanner;

//Внешний класс
public class City {
	
	static Scanner sc = new Scanner(System.in);

	static String streets = "";
	static String squares = "";
	static String avenues = "";

	//Внутренний Streets
	class Streets {
		
		City streets = new City();
		
	}
	
	//Внутренний Squares
	class Squares {
		
		City squares = new City();
	}
	
	//Внутренний Avenues
	class Avenues {
		
		City avenues = new City();
		
	}

	
public static void main (String [] args) {
	
//Ввод значений и вывод 
	
	System.out.println("Введите название улицы:");
	streets = sc.nextLine();
	System.out.println("Введите название площади:");
	squares = sc.nextLine();
	System.out.println("Введите название проспекта:");
	avenues = sc.nextLine();
	
	System.out.printf("Улица: %s \n", streets);
	System.out.printf("Проспект:  %s \n", avenues);
	System.out.printf("Площадь:  %s", squares);
	}
}