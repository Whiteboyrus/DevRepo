/**
 * Created by Pavlik on 9/27/15.
 */
public class Button {

    Click click;

    public void setClick(Click click) {
        this.click = click;
        System.out.println("setClick method");

    }

    public void test() {

        click.onClick();

        System.out.println("test method");
    }
}
