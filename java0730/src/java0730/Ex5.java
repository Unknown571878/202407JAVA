package java0730;

import java.util.stream.IntStream;

public class Ex5 {

	public static void main(String[] args) {
//		IntStream ii = IntStream.range(1, 5); // 5전까지
		IntStream ii = IntStream.rangeClosed(1, 5); //5까지 포함
//		ii.forEach(System.out::println); //아래와 같은문장
		ii.forEach(a->{
			System.out.println(a);
		});
		
	}

}
