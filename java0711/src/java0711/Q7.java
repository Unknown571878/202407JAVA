package java0711;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no;

		System.out.println("2자리의 양수를 입력하세요.");

		do {
			System.out.print("no값: ");
			no = scan.nextInt();
		} while (no < 10 || no > 99);
		System.out.println("변수 no값은 " + no + " 이(가) 되었습니다.");
	}
}
