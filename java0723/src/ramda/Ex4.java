package ramda;

public class Ex4 {
	public static void main(String[] args) {
		MyInterf3 interf3 = (a, b)->{
			System.out.println(a+b);
		};
		interf3.method(100, 2000);
	}
}
