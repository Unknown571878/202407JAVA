package java0709;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		System.out.print("첫번째 숫자를 입력하시오: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.print("두번째 숫자를 입력하시오: ");
		Scanner sc2 = new Scanner(System.in);
		int b = scan.nextInt();
		if(a>b) {
			System.out.printf("첫번째 숫자 %d가 더 큽니다", a);
		} else if(a<b) {
			System.out.printf("두번째 숫자 %d가 더 큽니다", b);
		} else {
			System.out.print("0");
		}
	}
}
