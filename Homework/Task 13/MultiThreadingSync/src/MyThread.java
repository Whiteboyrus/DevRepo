/**
 * Created by USER on 14.10.2015.
 */
public class MyThread extends Thread {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void run() {
    main.print10();
    }
}
