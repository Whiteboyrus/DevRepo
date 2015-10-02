package packaged;

import java.util.Scanner;

public class Triangle extends Figure {
double ar;
double a;
double h;
	public void area() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter a (basis) ");
		double a =  sc.nextDouble();;
		System.out.println("Please, enter h (height) ");
		double h =  sc.nextDouble();
		
		ar = 0.5 * a * h;
		sc.close();
		output();
		
	}
	
	public void output() {
		System.out.println("Triangle area: " + ar);
	}
}