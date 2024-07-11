package java0711;

import java.util.Scanner;

public class Q6_1 {
	public static void main(String[] args) {
		int n, w;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("n값: ");
			n = scan.nextInt();
		} while (n <= 0);
		do {
			System.out.println("w값: ");
			w = scan.nextInt();
		} while (w <= 0 || w > n);

		for (int i = 0; i < n / w; i++) {
			System.out.println("*".repeat(w));
		}
		int rest = n % w;
		if (rest != 0) {
			System.out.println("*".repeat(rest));
		}
		System.out.println("완료!!");
	}
}
