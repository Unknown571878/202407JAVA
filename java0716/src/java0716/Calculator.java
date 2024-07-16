package java0716;

public class Calculator {
	int x,y;
	int plus() {
//		int result = x + y;
		return x + y;
	}
	
	double avg() {
//		double sum = plus(x,y);
//		double result = sum /2;
		return this.plus() /2.0;
	}
	
	void execute() {
//		double result = avg(7,10);
		println("실행결과: " + avg());
	}
	
	void println(String message) {
		System.out.println(message);
	}
}
