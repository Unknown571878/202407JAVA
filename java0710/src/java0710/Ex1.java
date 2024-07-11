package java0710;

public class Ex1 {
	public static void main(String[] args) {
		String str1 = 10+"";
		String str2 = String.valueOf(10);
		
		double s11 = Double.parseDouble("100.345") + 3;
		System.out.println(s11);

		String a11 = "가나다" + 3;
		System.out.println(a11);
		int x1 = 1;
		int x2 = 2;
		int x3 = x1 / x2;
		System.out.println(x3);

		double result1 = (double) x1 / x2;
		System.out.println(result1);

		float result = 1.5f + 3.4f;
		double res2 = 1.5 + 3.4;

		byte a1 = 10;
		byte b2 = 20;
		int s1 = a1 + b2;

		byte b1 = -65;
		char c1 = (char) b1;
		System.out.println(c1);

		int x = 200;
		byte y = (byte) x;
		System.out.println(y);

		double d1 = 3.14;
		int z = (int) d1;
		System.out.println(z);

	}
}