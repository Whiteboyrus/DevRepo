import java.io.*;
import java.util.Scanner;

import static java.nio.file.Files.exists;

/**
 * Created by Pavlik on 10/6/15.
 */
public class Creater {



    public static void create (String fName) {

        //String text = null;
        File crfile = new File(fName);
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку для записи в файл:");
        String contain = sc.nextLine();

        try {

            if (!crfile.exists()) {
                crfile.createNewFile();
            }

            PrintWriter write = new PrintWriter(crfile.getAbsoluteFile());

            try {
                write.print(contain);
            } finally {
                write.close();
            }
            } catch (IOException e) {
            System.err.print(e);
        }
    }

    public static String fileReader (String fName) throws FileNotFoundException {

        StringBuilder sBuilder = new StringBuilder();
        File crfile = new File(fName);
        String string;


      //  exists(fName);

        try {
            BufferedReader sc = new BufferedReader(new FileReader(crfile.getAbsoluteFile()));
            try {
                while ((string = sc.readLine()) !=null) {
                    sBuilder.append(string);
                    sBuilder.append("\n");
                }
                System.out.printf("Содержимое файла:" , fName);
            }
            finally {
                sc.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return sBuilder.toString();
    }
}
