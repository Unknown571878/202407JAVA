package iterator2;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		StudentList studentList = new StudentList(3);
		studentList.appendStudent(new Student("홍길동", "202401001", 90));
		studentList.appendStudent(new Student("김자바", "202401002", 78));
		studentList.appendStudent(new Student("강한나", "202401003", 95));
		
		Iterator<Student> it = studentList.iterator();
		while(it.hasNext()) {
			Student student = it.next();
			System.out.println(student);
		}
		System.out.println();
	}

}
