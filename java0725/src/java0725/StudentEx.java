package java0725;

import java.util.Arrays;
import java.util.Comparator;

public class StudentEx {

	public static void main(String[] args) {
		Studenet[] stduents = { new Studenet("홍길동", 57), new Studenet("기길동", 87), new Studenet("강길동", 69),
				new Studenet("천길동", 76), new Studenet("박길동", 95), };
		Comparator<Studenet> c = new Comparator<Studenet>() {
			
			@Override
			public int compare(Studenet o1, Studenet o2) {
				return Integer.compare(o1.getScore(), o2.getScore());
			}
		};
		
		Arrays.sort(stduents, c);
		for(Studenet st : stduents) {
			System.out.println(st);
		}
	}

}
