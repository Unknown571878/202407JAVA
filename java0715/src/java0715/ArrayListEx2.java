package java0715;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListEx2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
//		list.add(123);
		list.add("홍길동");
		list.add("자바");
		list.add("Hello");

//      이터레이터 (자바 디자인 패턴)
		Iterator<String> it = list.iterator(); // 반복자
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}

//		for(String str : list) {
//			System.out.println(str);
//		}

	}
}
