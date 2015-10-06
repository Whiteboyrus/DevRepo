import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Pavlik on 10/6/15.
 */
public class CheckException {

    public static void exists (String fName) throws FileNotFoundException {

        File crfile = new File(fName);

        if (!crfile.exists()) {
            System.out.print("\n Файл не существует \n");
        }
    }
}
