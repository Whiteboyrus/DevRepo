
public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void getRussianMessage () {
		System.out.print("Введите символы допустимого числового диапазона!");
	}
	
	public CustomException (String msg) {
		super(msg);
	}
}
