package java0709;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		System.out.print("점수을 입력하시오");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if (100>=a && a>=90) {
			System.out.print("당신의 학점은 A입니다");
		} else if(90>a && a>=80) {
			System.out.print("당신의 학점은 B입니다");
		} else if(80>a && a>=70) {
			System.out.print("당신의 학점은 C입니다");
		} else if(70>a && a>=60) {
			System.out.print("당신의 학점은 D입니다");
		} else if(60>a && a>=0) {
			System.out.print("당신의 학점은 F입니다");
		} else {
			System.out.print("점수를 잘못입력하셨습니다");
		}
	}
}
