package java0709;

public class Ex2 {
	public static void swap(int a, int b) {
		int c = a;
		a = b;
		b = c;
		System.out.printf("x=%d, y=%d", a, b);
	}
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		System.out.printf("x=%d, y=%d\n", x, y);
		swap(x, y);
//		int z = 0;
//		z = x;
//		x = y;
//		y = z;
//		System.out.printf("x=%d, y=%d", x, y);
	}
}
