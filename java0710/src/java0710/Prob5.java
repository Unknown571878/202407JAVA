package java0710;

public class Prob5 {
	public static void main(String[] args) {
//		for (int i = 2; i < 10; i++)
//			for (int j = 1; j < 10; j++)
//				System.out.printf("%d x %d = %d\n", i, j, i * j);
		for (int j = 1; j < 10; j++) {
			for (int i = 2; i < 10; i++) {
				System.out.printf("%d x %d = %d\t", i, j, i * j);
			}
			System.out.println();
		}
	}
}
