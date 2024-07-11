package java0711;

public class Max {
	public static void main(String[] args) {
		int a[] = { 11, 33, 10, 266, 88 };
		int max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}

		System.out.println("최대값: " + max);
	}
}
