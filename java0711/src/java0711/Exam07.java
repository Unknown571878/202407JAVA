package java0711;

import java.util.Scanner;

public class Exam07 {
	public static void main(String[] args) {
		boolean login = true;
		int balance = 0;
		Scanner scan = new Scanner(System.in);
		String name = "", usernum = "", adr = "";

		while (login) {
			System.out.println("----------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("----------------------------------");
			System.out.print("선택> ");
			int lognum = Integer.parseInt(scan.nextLine());
			switch (lognum) {
			case 1:
				System.out.println("로그인 처리");
				System.out.print("아이디: ");
				String insertname = scan.nextLine();
				System.out.print("패스워드: ");
				String insertpassword = scan.nextLine();
				if (insertname.equals(name)) {
					if (insertpassword.equals(usernum)) {
						System.out.println("로그인 성공");
					} else {
						System.out.println("로그인 실패:패스워드가 틀림");
					}
				} else {
					System.out.println("로그인 실패:아이디가 틀림");
				}
				break;
			case 2:
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]");
				System.out.print("1. 이름: ");
				name = scan.nextLine();
				System.out.print("2. 주민번호 앞 6자리: ");
				usernum = scan.nextLine();
				System.out.print("3. 전화번호: ");
				adr = scan.nextLine();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + name);
				System.out.println("2. 주민번호 앞 6자리: " + usernum);
				System.out.println("3. 전화번호: " + adr);
				break;
			case 3:
				System.out.println("예금 출금");
				boolean run = true;
				while (run) {
					System.out.println("----------------------------------");
					System.out.println("1.예금액 | 2.출금액 | 3.잔고 | 4.종료");
					System.out.println("----------------------------------");
					System.out.print("선택> ");
					int menunum = Integer.parseInt(scan.nextLine());
					switch (menunum) {
					case 1:
						System.out.print("예금액> ");
						balance += Integer.parseInt(scan.nextLine());
						break;
					case 2:
						System.out.println("출금액> ");
						balance -= Integer.parseInt(scan.nextLine());
						break;
					case 3:
						System.out.println("잔고> ");
						System.out.println(balance);
						break;
					case 4:
						System.out.println("예금/출금 프로그램 종료");
						run = false;
						break;
					}
				}
				break;
			case 4:
				System.out.println("프로그램 전체 종료");
				login = false;
				break;
			}

		}
	}
}
