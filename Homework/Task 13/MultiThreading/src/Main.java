import javax.swing.plaf.synth.SynthUI;
import java.util.Scanner;

/**
 * Created by USER on 14.10.2015.
 */
public class Main {



    public static void main (String [] args) {


        Scanner sc = new Scanner(System.in);
        String in;
        Main main = new Main();

        MyThread myThread11 = new MyThread();
        myThread11.setMain(main);

        MyThread myThread22 = new MyThread();
        myThread22.setMain(main);

        System.out.print("Введите старт для продолжения: ");
        in= sc.nextLine();

        if (in.toLowerCase().equals("start")) {
            myThread11.start();
            myThread22.start();
        }

        else {
            System.out.print("Ошибка!");
        }
    }

    public void print10() {

        for(int i = 0; i < 100; i++)
        {
            if((i % 10) == 0)
            {
                System.out.print("\n");
                System.out.printf("Thread = " + Thread.currentThread().getName());
            }
            System.out.printf(" %d",i);
        }
    }
}
