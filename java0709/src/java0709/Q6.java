package java0709;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		System.out.print("정수의 값을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (a < 0) {
			System.out.println(a * -1);
		} else {
			System.out.println(a);
		}
	}
}
