import java.io.*;
import java.util.Scanner;

/**
 * Created by Pavlik on 10/6/15.
 */

public class Creater extends Read {

    public void create() {

        Scanner sc = new Scanner(System.in);
        boolean chk = false;


        while (!chk) {
            System.out.println("Введите имя файла - exit - прекращение работы:");
            String fName = sc.nextLine();
            if (fName.equals("exit")) {
                break;
            }

            File crfile = new File(fName);

            System.out.printf("Введённое имя файла: \n" + fName);

            System.out.println("\n Введите строку для записи в файл:");
            String contain = sc.nextLine();
            if (contain.equals("exit")) {
                break;
            }

            try {

                if (!crfile.exists()) {
                    crfile.createNewFile();
                }

                PrintWriter write = new PrintWriter(crfile.getAbsoluteFile());

                try {
                    write.print(contain);

                } finally {
                    write.close();
                    System.out.println("Файл сохранён");
                }

            } catch (IOException e) {
                System.err.print(e);
            }
        }
    }
}