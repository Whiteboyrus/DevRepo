import java.io.FileNotFoundException;

/**
 * Created by Pavlik on 10/6/15.
 */
public class Main extends Creater {

    public static void main(String [] args) {

        Creater createmeth = new Creater();
        createmeth.create("testTextFile.txt");
        Creater readmeth = new Creater();
        try {
           String string = readmeth.fileReader("testTextFile.txt");
            System.out.printf(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }
}