import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Pavlik on 10/6/15.
 */
public class Edit extends Creater {

    public void edit() throws FileNotFoundException {


        Scanner sc = new Scanner(System.in);
        String fName;

        boolean chk = false;


        while (!chk) {

            System.out.println("Введите имя файла для перезаписи (Изменения) - exit - прекращение работы: ");
            fName = sc.nextLine();
            if (fName.equals("exit")) {
                break;
            }
            exists(fName);
            System.out.println("Введите текст для перезаписи (Изменения) - exit - прекращение работы: ");
            String newText = sc.nextLine();
            if (newText.equals("exit")) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            String oFile = fileReader();
            sb.append(oFile);
            sb.append(newText);
            create();
        }
    }
}

