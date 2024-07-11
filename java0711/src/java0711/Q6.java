package java0711;

import java.util.Scanner;

public class Q6 {
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

		for (int i = 1; i <= n; i++) {
			System.out.print("*");
			if (i % w == 0) {
				System.out.print("\n");
			}
		}
		if (n % w != 0) {
			System.out.println();
		}
		System.out.println("완료!!");
	}
}
