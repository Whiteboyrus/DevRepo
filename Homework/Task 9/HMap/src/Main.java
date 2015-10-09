import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Pavlik on 10/8/15.
 */
public class Main extends abs {

    public static void main (String [] args) {


        String in = "";
Functional func = new Functional();

        Scanner sc = new Scanner(System.in);
        in = sc.nextLine();



        for (int i = 0; i < 2; i++ ) {
            func.manGen();
            func.womanGen();
        }

        if (in.equals("man") && in.equals("woman")) {

        } else {
            System.out.println("Неверный ввод");
        }
    }

}
