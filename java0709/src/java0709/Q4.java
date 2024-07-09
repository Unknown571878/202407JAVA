package java0709;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args)
	{
		System.out.print("첫번째 값을 입력하시오: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.print("두번째 값을 입력하시오: ");
		Scanner sc2 = new Scanner(System.in);
		int b = sc2.nextInt();
		System.out.print("세번째 값을 입력하시오: ");
		Scanner sc3 = new Scanner(System.in);
		int c = sc3.nextInt();
		if (a>b) {
			if(a>c) {
				System.out.printf("가장 큰 숫자는 %d입니다", a);
			}else {
				System.out.printf("가장 큰 숫자는 %d입니다", c);
			}
		}else {
			if(b>c) {
				System.out.printf("가장 큰 숫자는 %d입니다", b);
			}else {
				System.out.printf("가장 큰 숫자는 %d입니다", c);
			}
		}
	}
}
