package p367;

import java.util.Scanner;

public class DriverExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("차량을 선택하세요(1:버스, 2:택시)");
		int num = scanner.nextInt();
		Driver driver = new Driver();
		Vehicle v1 = null;

		switch (num) {
		case 1: {
			v1 = new Bus();
			break;
		}
		case 2: {
			v1 = new Taxi();
			break;
		}
		default:
			System.out.println("선택 오류!");
		}
		driver.driver(v1);
	}
}
