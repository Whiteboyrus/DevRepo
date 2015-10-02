import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rasch {
	
	public Rasch(Scanner sc) {
		this.setSc(sc);
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	private Scanner sc;
	private Pattern pt = Pattern.compile("[0-9]*[0-9]");
	private Matcher match;
	
public double choice () throws CustomException {
		
		double a = 0;
		String in = "";
		
		Matcher match;
		
		in = sc.nextLine();
		match = pt.matcher(in);
		
		if(match.matches())
		{
			a = Double.valueOf(in);
		} else {
			throw new CustomException("Неверный ввод!");
		}	
		
		return a;
	}
	
	public void calc(double a, double b) throws CustomException {
		
		//double a = 0;
		//double b = 0;
		double rezult = 0;
		int t = 0;
		
		boolean chk = false;
		boolean chk1 = true;
		
		String in = "";
		//System.out.println("");
		System.out.println("\nПожалуйста, выберите вариант расчёта: 1 - '+', 2 - '-', 3 - '/', 4 - '*' ");
		in = sc.nextLine();
		match = pt.matcher(in);
		
		
		if (!match.matches()) {
			throw new CustomException ("Некорректный ввод! Повторите");
		} else {
			t = Integer.valueOf(in);
		}
		
		switch (t) {
			
		case 1:
		{
						
			rezult=a+b;
			System.out.println("Результат сложения = " + rezult);
			break;
			
		}
		
		case 2:
		{
			
			rezult=a-b;
			System.out.println("Разность = " + rezult);
			break;
		}
		
		case 3:
		{
					
			rezult=a/b;
			System.out.println("Результат деления  = " + rezult);
			break;
		}
		
		case 4:
		{
					
			rezult=a*b;
			System.out.println("Произведение = " + rezult);
			break;
		}
		}	 
	}
}
