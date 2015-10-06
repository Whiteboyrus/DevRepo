import java.io.*;
import java.util.Scanner;

/**
 * Created by Pavlik on 10/6/15.
 */
public class Read extends CheckException {

    public static String fileReader() throws FileNotFoundException {

        StringBuilder sBuilder = new StringBuilder();

        Scanner Sc = new Scanner(System.in);

        boolean chk = false;


        while (!chk) {
            System.out.println("Введите имя файла:");
            String fName = Sc.nextLine();
            if (fName.equals("exit")) {
                break;
            }

            File crfile = new File(fName);
            String string;

            exists(fName);

            try {
                BufferedReader sc = new BufferedReader(new FileReader(crfile.getAbsolutePath()));
                try {
                    while ((string = sc.readLine()) != null) {
                        sBuilder.append(string);
                        sBuilder.append("\n");
                    }
                    System.out.printf("Содержимое файла: ", fName);
                } finally {
                    sc.close();
                }
            } catch (IOException e) {
                System.out.print("\nОшибка ввода-вывода");
            }
            return sBuilder.toString();
        }
        return "";
        }
    }

