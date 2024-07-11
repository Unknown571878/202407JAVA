package java0709;

import java.util.Scanner;

public class Q3 {

	public static int maxNum(int x, int y, int z) {
		int max = 0;
		max = x;
		if (y > max)
			max = y;
		if (z > max)
			max = z;
		return max;
	}

	public static void main(String[] args) {
//		System.out.print("첫번째 숫자를 입력하시오: ");
//		Scanner scan = new Scanner(System.in);
//		int a = scan.nextInt();
//		System.out.print("두번째 숫자를 입력하시오: ");
//		Scanner sc2 = new Scanner(System.in);
//		int b = scan.nextInt();
//		if (a > b) {
//			System.out.printf("첫번째 숫자 %d가 더 큽니다", a);
//		} else if (a < b) {
//			System.out.printf("두번째 숫자 %d가 더 큽니다", b);
//		} else {
//			System.out.print("0");
//		}
		Scanner scan = new Scanner(System.in);
		System.out.print("3개의 수를 입력: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int max = 0;
		max = maxNum(a,b,c);
		
		System.out.println(max);
	}
}
