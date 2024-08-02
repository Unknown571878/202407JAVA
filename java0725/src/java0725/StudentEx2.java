package java0725;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentEx2 {

	public static void main(String[] args) {
		List<Studenet> list = new ArrayList<>();
		list.add(new Studenet("홍길동", 50));
		list.add(new Studenet("기길동", 90));
		list.add(new Studenet("감길동", 70));
		list.add(new Studenet("고길동", 80));
		list.add(new Studenet("구길동", 60));
		
		Comparator<Studenet> c = new Comparator<Studenet>() {
			
			@Override
			public int compare(Studenet o1, Studenet o2) {
				return Integer.compare(o2.getScore(), o1.getScore());
			}
		};
		Collections.sort(list, c);
		System.out.println(list);
	}

}
