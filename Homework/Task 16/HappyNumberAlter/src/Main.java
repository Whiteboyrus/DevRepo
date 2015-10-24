import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DMX101 on 22/10/15.
 */
public class Main {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int numb = sc.nextInt();
        String str = String.valueOf(numb);
        int i =1;
       // Pattern pt = Pattern.compile("(111) | (222)");
       // Matcher matcher = pt.matcher(str);
        if (numb > 100 && numb <=1000) {
            String sotka = str.substring(0,1); //sub сотни
            String deca = str.substring(1,2); // sub десятки
            String thosand = str.substring(2,3); // sub тысячи
            System.out.println("Ввод корректен!");

            int sotkaTwo = Integer.parseInt(sotka); //преобразуем в int
            int decaTwo = Integer.parseInt(deca);
            int thousandTwo = Integer.parseInt(thosand);

            if(sotkaTwo == decaTwo | decaTwo == thousandTwo)
                System.out.print("Число " +str+ " счастливое, все цифры совпадают");
            if((sotkaTwo+i == decaTwo | decaTwo+i == thousandTwo))
                System.out.print("Число " +str+ " счастливое, каждый предыдущий разряд больше последующего на 1");
        }
         else {
            System.out.print("Неверный ввод!");
        }
    }

}
