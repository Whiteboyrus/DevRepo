
public class Class1 {

	public static void main(String[] args)
	{
		float[] digitArray = {14, 88, 2, 82, 16, 13, 18, 89, 19, 43}; //Объявление массива digitArray
		int numbers = 10;
		int average = 0;
		System.out.println("----------------Задание 1-------------------------");
		for(int i = 0; i < numbers; i++) {  //Цикл для упорядоченного вывода значений массива
			System.out.printf("|Значение " + (i+1) + " = " + digitArray[i]); // Вывод значений в консоль
		}
		for (float i:digitArray) {
			average+=i;
		}
		System.out.println("\nAverage value =  " + average/digitArray.length);  // Вывод среднего арифметического элементов массива
		task2();			//Вызов метода task2 (Второе задание)
		task3();			//Вызов метода task3 (Третье задание)
	}
	
	public static void task2() {
		System.out.println("----------------Задание 2-------------------------");
		String line = "Здесь введён текст - это вторая его часть";
		String[] lineParts = line.split("-");					// Задаём символ для деления строки
		System.out.println("Полный текст сроки: " + line);
		System.out.println("Количество символов в строке = " +line.length()); //Вывод количества символов строки
		System.out.println("Первая часть строки = " + lineParts[0]);  // Вывод первой части строки
		System.out.println("А " + lineParts[1]);					  //Вывод второй части строки
	}
	
	public static void task3() {
		int [] arrayDigit = {8, 17, 22, 25, 84, 99, 668, 20, 77, 33}; //Объявление массива arrayDigit
		int minValue = arrayDigit[0];
		int maxValue = arrayDigit[0];
		for (int i = 0; i < arrayDigit.length; i++) {   //Цикл for для высчитывания минимального и максимального элементов массива
			if (minValue > arrayDigit[i])
				minValue = arrayDigit[i];
			if (maxValue < arrayDigit[i])
				maxValue = arrayDigit[i];	
		}
			System.out.println("----------------Задание 3-------------------------");
			System.out.println("Минимальный элемент массива arrayDigit: " + minValue);  //Вывод минимального элемента массива
			System.out.println("Максимальный элемент массива arrayDigit: " + maxValue); //Вывод максимального элемента массива
	}
}
