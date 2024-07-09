package java0709;

import java.util.Scanner;

public class Q2 {
	public static int getNumber() {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		return num;
	}
	public static int getcount(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	public static void main(String[] args) {
		
		System.out.println("사과의 개수: ");
		int apple = getNumber();
		System.out.println("나눠먹을 사람의 수: ");
		int p = getNumber();
		int a = apple % p;
		System.out.printf("남은 사과의 개수 %d", a);
	}
}
