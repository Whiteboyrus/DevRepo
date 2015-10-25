import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by DMX101 on 21/10/15.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число ");
        int x = sc.nextInt();

        /*double sqrt = Math.pow(Math.sqrt(Math.cos(Math.pow(Math.E, x))) + Math.pow(Math.E,Math.pow(x,2))+Math.sqrt(1.0/x), 1.0/4);

        double coszn = (Math.cos(Math.PI*Math.pow(x,3)));
        double log = Math.log(Math.pow(1+x,2));

        double sumzn = Math.pow(coszn+log,Math.sin(x));

        double rezult = sqrt/sumzn;

        System.out.println("rezult = " + rezult);*/


        double y = (Math.pow((Math.sqrt(Math.cos(Math.pow(Math.E, 2)) + Math.pow(Math.E, 2) + Math.sqrt(1.0 / x))), 1.0 / 4));
        double z = (Math.pow((Math.cos(Math.PI * Math.pow(x, 3))) + (Math.log(Math.pow(1 + x, 2))), Math.sin(x)));

        System.out.println("Результат  числителя = " + y);
        System.out.println("Результат знаменателя = " + z);

        System.out.print("Общий результат = " + y / z);
    }
}