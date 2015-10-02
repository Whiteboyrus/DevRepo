package packaged;

import java.util.Scanner;

public class Square extends Figure {
		double sq;
	public void area() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter side of square: ");
		double a =  sc.nextDouble();
		
		sq = a * a;
		sc.close();
		output();
	}
	
	public void output() {
		System.out.println("Square area = " + sq);
	}
}