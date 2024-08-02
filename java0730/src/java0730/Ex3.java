package java0730;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("ken", 100));
		list.add(new Student("shin", 60));
		list.add(new Student("kim", 80));
		System.out.println(list);
		Collections.sort(list, (s1, s2)->Integer.compare(s2.getScore(), s1.getScore()));
		// 객체 배열 Arrays.sort 사용
		
		System.out.println(list);
		list.stream().forEach(s->{
			System.out.println(s.getName() + ", " + s.getScore());
		});
	}

}
