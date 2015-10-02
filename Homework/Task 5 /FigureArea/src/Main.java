import packaged.Square;
import packaged.Rectangle;
import packaged.Square;
import packaged.Round;
import packaged.Square;
import packaged.Triangle;

import java.util.Scanner;


public class Main {
		
		public static void main(String [] args) {
			
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||Hello!|||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.print("Enter number of your variant: 1 - Square area; 2 - Rectangle area; 3 - Triangle area; 4 - Round area; ");
			
			Scanner sc = new Scanner(System.in);
			int sw = sc.nextInt();
			
			switch (sw) {
			case 1: 
				Square kv = new Square();
				kv.area();
				break;
				
			case 2:
				Rectangle rc = new Rectangle();
				rc.area();
				break;
				
			case 3:
				Triangle tr = new Triangle();
				tr.area();
				break;
				
			case 4:
				Round rd = new Round();
				rd.area();
				break;
				
			default:
					System.out.println("Wrong input");
			}
		
				
			
		}
	
}
