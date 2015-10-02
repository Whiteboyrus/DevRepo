import java.util.Scanner;

public class Main {
	
	public static void main (String [] args) {
		
		boolean chk = false;
		
		Scanner sc = new Scanner(System.in);
		Rasch meth = new Rasch(sc);
		
		double a = 0;
		double b  =0;
		
		while (!chk) {
			try {
					
				System.out.println("\nВведите два числа для дальнейших операций:");
				System.out.println("Введите a");
				a = meth.choice();
				System.out.println("Введите b");
				b = meth.choice();
				meth.calc(a, b);
				
			} catch (CustomException e) {
				System.err.print(e);
			}
		}
	}
}
