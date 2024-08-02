package java0730;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("ken", 100));
		list.add(new Student("shin", 60));
		list.add(new Student("kim", 80));

		list.stream() // 스트림
		.filter(s->s.getScore() >= 70) // 중간 작업
		.forEach(s->System.out.println(s.getName())); // 최종 작업
		
//		for (Student st : list) {
//			int score = st.getScore();
//			if (score < 70) {
//				list.remove(st);
//			}
//		}
		
//		long sum = list.stream().filter(s->s.getScore() >= 70).sum
//		System.out.println("70점 이상은" + sum + "명");

		long num = list.stream().filter(s->s.getScore() >= 70).count();
		System.out.println("70점 이상은" + num + "명");
		
		
		list.stream().forEach(a->{
			String msg = MessageFormat.format("{0}, {1}", a.getName(), a.getScore());
			System.out.println(msg);
		});
//		for (Student st : list) {
//			String msg = MessageFormat.format("{0}, {1}", st.getName(), st.getScore());
//			System.out.println(msg);
//		}

	}

}
