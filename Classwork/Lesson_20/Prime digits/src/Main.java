import java.util.Scanner;

/**
 * Created by DMX101 on 28/10/15.
 */
public class Main {

    public static void main(String[] args) {

        Integer[] digitArray;
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------Урок 20-------------------------");
        System.out.println("Введите размерность массива: ");
        int n = sc.nextInt();

        System.out.println("Введите размерность массива от 1 до 99");
        digitArray = new Integer[n];
        if (n > 0 && n < 100) {

            for (int i = 0; i < digitArray.length; i++) {
                System.out.println("Введите элемент " + i + ":");
                digitArray[i] = sc.nextInt();
            }

            int res = 0;


            for (int i = 0; i < digitArray.length; i++) {
                res ^= digitArray[i];
            }
            System.out.print("Результат  = " + res);


        } else {
            System.out.println("Ввод некорректен");
            return;
        }


    }
}