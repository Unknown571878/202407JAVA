package java0712;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("입력할 학생의 수: ");
		int stu = Integer.parseInt(scan.nextLine());
		double scores[][] = new double[stu][3];

		for (int i = 0; i < scores.length; i++) {
			System.out.println(i + 1 + "번째 학생");
			System.out.print("국어 점수:");
			scores[i][0] = Double.parseDouble(scan.nextLine());

			System.out.print("수학 점수:");
			scores[i][1] = Double.parseDouble(scan.nextLine());

			scores[i][2] = (scores[i][0] + scores[i][1]) / 2;
		}
		System.out.printf("\t국어\t수학\t평군\n");
		System.out.println("=====================================");
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번 학생\t%3.2f\t%3.2f\t%3.2f\n", i + 1, scores[i][0], scores[i][1], scores[i][2]);
		}
//		for (int i = 0; i < stu; i++) {
//			int cnt = 0;
//			for (int j = 0; j < 2; j++) {
//				System.out.println("점수를 입력하세요: ");
//				scores[i][j] = Integer.parseInt(scan.nextLine());
//				sum += scores[i][j];
//				cnt++;
//			}
//			avg = sum/cnt;
//			scores[i][2] = avg;
//		}
//		for (int n : scores) {
//			System.out.println(n);
//		}
	}
}
