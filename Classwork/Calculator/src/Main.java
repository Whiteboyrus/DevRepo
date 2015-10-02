import java.util.Scanner;

	abstract class WAbstract {
		
		abstract void calc();
		double a = 0;
		double b = 0;
		double rezult = 0;
		boolean chk = false;
}

	public class Main {
		public static void main(String [] args) {
			
			Rasch meth = new Rasch();
			
			meth.calc();
			
		}
	}
	
	class Rasch extends WAbstract {
		public void calc() {
			while (!chk)
			{
			try {
				System.out.println("Пожалуйста, выберите варинт расчёта: 1 - '+', 2 - '-', 3 - '/', 4 - '*' ");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			
			switch (ch) {
				
			case 1:
			{
				System.out.println("Введите a");
				a=sc.nextDouble();
				System.out.println("Введите b");
				b=sc.nextDouble();
				
				rezult=a+b;
				System.out.println("Результат = " + rezult);
				break;
			}
			
			case 2:
			{
				System.out.println("Введите a");
				a=sc.nextDouble();
				System.out.println("Введите b");
				b=sc.nextDouble();
				
				rezult=a-b;
				System.out.println("Результат = " + rezult);
				break;
			}
			
			case 3:
			{
				System.out.println("Введите a");
				a=sc.nextDouble();
				System.out.println("Введите b");
				b=sc.nextDouble();
				
				rezult=a/b;
				System.out.println("Результат деления  = " + rezult);
				break;
			}
			
			case 4:
			{
				System.out.println("Введите a");
				a=sc.nextDouble();
				System.out.println("Введите b");
				b=sc.nextDouble();
				
				rezult=a*b;
				System.out.println("Результат = " + rezult);
				break;
			}
			
			default: 
			{
				System.out.println("Ошибка!!!! Неверный ввод.");
			}
		}
}
			
			catch (Exception e) {
				System.out.println("Неверный ввод, введите корректное число!");
			}
	}
}
}
