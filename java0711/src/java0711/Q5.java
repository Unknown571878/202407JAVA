package java0711;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("n의 값을 입력하시오: ");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.print("-");
			} else {
				System.out.print("+");
			}
		}
	}
}
