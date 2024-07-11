package java0711;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 더할 n을 작성하시오");
		int n;
		do {
			System.out.println("n값: ");
			n = scan.nextInt();
		}while(n<=0);
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
