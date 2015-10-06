import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Pavlik on 10/6/15.
 */
public class Delete extends CheckException{

public static void delete() throws FileNotFoundException {

    Scanner Sc = new Scanner(System.in);

    System.out.println("Введите имя удаляемого файла:");
    String fName = Sc.nextLine();
    exists(fName);
    new File(fName).delete();
    System.out.println("Файл удалён!");
    }
}