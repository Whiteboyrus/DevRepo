
import java.util.Scanner;

public class Class1 {
 
	public static void main (String[] args) {
		Integer[] digitArray = new Integer [10];				//Объявление массива и кол-ва элементов
		input(digitArray);										//Вызов метода ввода и т.д
		output(digitArray);	
		sort(digitArray);
		output2(digitArray);
		div(digitArray);
	}
	
	public static void input(Integer[] digitArray) {
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("----------------Задание 1-------------------------");
		for (int i = 0; i< digitArray.length; i++)
		{	
			System.out.print("Введите элемент " + i + ":");
			digitArray[i]=sc.nextInt();	
		}
	}
	
	public static void output(Integer[] digitArray) {				
		System.out.println("\n----------------Исходный массив - Без сортировки-------------------------");
		for(int i=0; i < digitArray.length; i++) {
			System.out.print("|Значение " + (i+1) + " = " + digitArray[i]);			//Вывод массива в консоль
		}
		
	}
	
	public static void sort(Integer[] digitArray) {			//Метод пузырьковой сортировки
		for (int i = digitArray.length-1; i >0; i--) {			//Циклическое сокращение массива на 1
			for (int j=0; j < i; j++) {
				if (digitArray[j] > digitArray[j+1]) {
					int variable = digitArray[j];
					digitArray[j] = digitArray[j+1];
					digitArray[j+1] = variable;
				}
			}
		}
	}
	
	public static void output2(Integer[] digitArray) {		//Метод вывода отсортированного массива
		System.out.println("\n----------------Отсортированный массив - Сортировка пузырьком - По возрастанию-------------------------");
		for (int i = 0; i< digitArray.length; i++)
		{	
		System.out.print("|Значение " + (i+1) + " = " + digitArray[i]);
		}
	}
	
	public static void div(Integer[] digitArray) {
		System.out.println("\n----------------Чётные элементы массива-------------------------");
		for (int i = 0; i < digitArray.length; i++) {
		if ((digitArray[i] % 2 == 0) && (digitArray[i] != 0))
				{
			System.out.print("|Значение " + (i+1) + " = " + digitArray[i]);
			}
		}
	}
}
