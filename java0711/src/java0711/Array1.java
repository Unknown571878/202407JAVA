package java0711;
public class Array1 {
	public static void main(String[] args) {
		int score[] = new int[] { 83, 90, 87 };
		int score2[] = { 83, 90, 87 };
		int sum = 0;

		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
			sum += score[i];
		}
		System.out.println(sum);
		double avg = (double) sum / score.length;
		System.out.println(avg);
		int[] myArr = new int[5];

		for (int i = 0; i < 5; i++) {
			System.out.println(myArr[i]);
		}
		double[] myArr2 = new double[5];

		for (int i = 0; i < 5; i++) {
			System.out.println(myArr2[i]);
		}
		boolean[] myArr3 = new boolean[5];

		for (int i = 0; i < 5; i++) {
			System.out.println(myArr3[i]);

		}
	}
}
