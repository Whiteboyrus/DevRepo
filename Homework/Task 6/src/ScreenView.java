/**
 * Created by Pavlik on 9/27/15.
 */
public class ScreenView implements Click {
    @Override
    public void onClick() {
System.out.println("onClick method");
    }

    public void showUI() {
        Button button = new Button();

       button.setClick(this);

        button.test();

        System.out.println("showUI method");

    }
}
