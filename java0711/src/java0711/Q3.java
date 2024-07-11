package java0711;

import java.util.Scanner;

public class Q3 {
	public static int sumOf(int a, int b) {
		int sum = 0;
		if (a >= b) {
			for (int i = b; i <= a; i++) {
				sum += i;
			}
		} else {
			for (int i = a; i <= b; i++) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 a,b를 포함하여 그사이의 모든 정수의 합을 구합니다");
		System.out.println("a값: ");
		int a = scan.nextInt();
		System.out.println("b값: ");
		int b = scan.nextInt();

		System.out.println(sumOf(a, b));
	}
}
