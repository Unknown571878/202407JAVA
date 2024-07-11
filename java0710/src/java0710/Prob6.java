package java0710;

import java.util.Scanner;

public class Prob6 {
	public static void main(String[] args) {
		System.out.print("출력할 구구단을 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		for (int i = 1; i < 10; i++)
			System.out.printf("%d x %d = %d\n", num, i, num * i);
	}
}
