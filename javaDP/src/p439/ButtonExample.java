package p439;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setonClickListener(new CallListener());
		btn.touch();
		
		btn.setonClickListener(new MessageListener());
		btn.touch();
	}
}
