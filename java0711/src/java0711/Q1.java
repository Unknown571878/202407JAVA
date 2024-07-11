package java0711;

import java.util.Scanner;

public class Q1 {
	public static int middle(int a, int b, int c) {
		int middle = 0;
//		if (a > b) {
//			if (b > c) {
//				middle = b;
//			} else {
//				if (c > a) {
//					middle = a;
//				} else {
//					middle = c;
//				}
//			}
//		} else {
//			if (a > c) {
//				middle = a;
//			} else {
//				if (b > c) {
//					middle = c;
//				} else {
//					middle = b;
//				}
//			}
//		}
//
//		if ((b >= a && c <= a) || (b <= a && c >= a)) {
//			middle = a;
//		} else if ((a > b && c < b) || (a < b && c > b)) {
//			middle = b;
//		} else {
//			middle = c;
//		}
//		return middle;
		if ((b >= a && c <= a) || (b <= a && c >= a)) {
			return a;
		} else if ((a > b && c < b) || (a < b && c > b)) {
			return b;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("세 정수의 중앙값을 구합니다. ");
		System.out.println("a값: ");
		int a = scan.nextInt();
		System.out.println("b값: ");
		int b = scan.nextInt();
		System.out.println("c값: ");
		int c = scan.nextInt();

		System.out.println(middle(a, b, c));
	}
}
