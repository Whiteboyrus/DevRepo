package packaged;

import java.util.Scanner;
import java.math.*;

public class Round extends Figure {
	double rx;
	double r;
	public void area() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter radius: ");
		double r =  sc.nextDouble();
		
	rx = Math.PI * Math.pow(r, 2);
		sc.close();
		output();
	}
	
	public void output() {
		System.out.println("Square area = " + rx);
	}
}
