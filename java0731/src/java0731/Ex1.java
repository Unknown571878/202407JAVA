package java0731;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Ex1 {
	static int sum = 0;
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 5).forEach(a->{  // 람다식
			sum += a; // 스트림에서 합계를 구하기 위해서는 변수를 전역변수로 사용해야 한다.
		});
		System.out.println(sum);
		IntStream.range(1, 5).forEach(new IntConsumer() {  // 익명 객체 생성
			
			@Override
			public void accept(int value) {
				System.out.println(value);
				
			}
		});
	}
	

}
