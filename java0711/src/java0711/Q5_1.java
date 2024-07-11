package java0711;

import java.util.Scanner;

public class Q5_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("n의 값을 입력하시오: ");
		int n = scanner.nextInt();
		for (int i = 0; i < n / 2; i++) {
			System.out.print("+-");
		}
		if (n % 2 != 0) {
			System.out.print("+");
		}
	}
}
