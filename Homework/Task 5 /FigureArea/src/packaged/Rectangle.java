package packaged;

import java.util.Scanner;

public class Rectangle extends Figure{
	double sq;
	public void area() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter side a: ");
		double a = sc.nextDouble();
		System.out.println("Please, enter side b: ");
		double b = sc.nextDouble();
		
		sq = a * b;
		sc.close();
		output();
	}
	
	public void output() {
		System.out.println("Rectangle area = " + sq);
	}
}