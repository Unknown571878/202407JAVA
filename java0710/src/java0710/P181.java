package java0710;

import java.util.Scanner;

public class P181 {
	public static void main(String[] args) {
		boolean run = true, run2 = true;
		int balance = 0;
		String id = null, pw = "";
		Scanner scanner = new Scanner(System.in);
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------");
			System.out.println("선택> ");
			int num = Integer.parseInt(scanner.nextLine());
			switch (num) {
			case 1:
				System.out.println("아이디> ");
				if(id.equals(scanner.nextLine())) {
					System.out.println("비밀번호> ");
					if(pw.equals(scanner.nextLine())) {
						System.out.println("로그인 성공> ");
					} else {
						System.out.println("비밀번호가 틀렸습니다> ");
					}
				} else {
					System.out.println("아이디가 틀렸습니다> ");
				}
				break;
			case 2:
				System.out.println("아이디> ");
				id = scanner.nextLine();
				System.out.println("비밀번호> ");
				pw = scanner.nextLine();
				break;
			case 3:
				run2 = true;
				while (run2) {
					System.out.println("----------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("----------------------------------");
					System.out.println("선택> ");
					int choice = scanner.nextInt();
					if (choice == 1) {
						System.out.println("예금액> ");
						balance += scanner.nextInt();
					} else if (choice == 2) {
						System.out.println("출금액> ");
						balance -= scanner.nextInt();
					} else if (choice == 3) {
						System.out.printf("잔고> %d\n", balance);
					} else if (choice == 4) {
						run2 = false;
					}
				}
				break;
			case 4:
				run = false;
				break;
			}

		}
		System.out.println("프로그램 종료");
	}
}
